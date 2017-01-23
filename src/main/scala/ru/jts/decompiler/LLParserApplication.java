/*
 * Copyright 2015-2017 JTS
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ru.jts.decompiler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import ru.jts.decompiler.class_model.ClassContainer;
import ru.jts.decompiler.config.AsyncConfig;
import ru.jts.decompiler.ll.AiClass;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Дмитрий on 15.05.2015.
 */
@EnableScheduling
@SpringBootApplication
public class LLParserApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(LLParserApplication.class);
    private static ConfigurableApplicationContext context;

    public final List<Future<AiClass>> futures = new ArrayList<>();
    int count = 0;
    private ReentrantLock lock = new ReentrantLock();
    @Autowired
    private LLParser parser;
    @Autowired
    private AsyncConfig asyncConfig;

    public static void main(String[] args) {
        SpringApplication.run(LLParserApplication.class, args);
    }


    // class 0 default_npc : (null)
    // ...
    // ...
    //
    // class_end

    @Override
    public void run(String... args) throws IOException {
        Files.walkFileTree(Paths.get("data/src/main/scala/pts_scripts"), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return super.visitFile(file, attrs);
            }
        });

        ClassContainer.getInstance();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.obj"), "UTF-8"))) {
            br.readLine(); // SizeofPointer 8
            br.readLine(); // SharedFactoryVersion 121
            br.readLine(); // NPCHVersion 182
            br.readLine(); // NASCVersion 56
            br.readLine(); // NPCEventHVersion 4
            br.readLine(); // Debug 0
            br.readLine(); // empty

            String line;

            while ((line = br.readLine()) != null) parse(line, br);

            int count = 0;
            int size = 0;

            int diff = 0;
            while (futures.size() > 0) {
                log.info("Waiting " + futures.size() + " tasks");
                Thread.sleep(1000);

                if (size == futures.size()) count++;
                else {
                    asyncConfig.getExecutor().setCorePoolSize(asyncConfig.getExecutor().getCorePoolSize() + diff);
                    diff = 0;
                    count = 0;
                }

                size = futures.size();

                if (count == 10) {
                    if (asyncConfig.getExecutor().getCorePoolSize() > 1)
                        diff++;
                    asyncConfig.getExecutor().setCorePoolSize(Math.max(asyncConfig.getExecutor().getCorePoolSize() - 1, 1));
                }
            }

            log.info("Job is done");
            System.exit(0);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void parse(String line, BufferedReader br) throws IOException {
        if (line.startsWith("class")) {
            readClass(line, br);
        } else if (!line.isEmpty()) {
            //System.err.println("Unknown line in LLParser.parse(line):");
            //System.err.println("Line: " + line);
        }
    }

    private void readClass(String line, BufferedReader br) throws IOException {
        //if(!line.startsWith("class 0 default_npc"))
        //	return;c

        // class 0 default_npc : (null)
        String parts[] = line.split(" ");
        int type = Integer.parseInt(parts[1]);
        String className = parts[2];
        String parent = parts[4].equals("(null)") ? null : parts[4];

        // fill class buffer
        StringBuilder buffer = new StringBuilder();

        while (!(line = br.readLine()).equals("class_end")) {
            if (!line.isEmpty()) {
                if (line.indexOf("//") > 0) {
                    line = line.substring(0, line.indexOf("//"));
                }
                buffer.append(line.trim()).append("\n");
            }
        }

        String buf = buffer.toString();

        Future<AiClass> future = parser.processClass(type, className, parent, buf);

        lock.lock();
        futures.add(future);
        lock.unlock();
    }

    @Scheduled(fixedRate = 1000)
    public void clearExecutedFutures() throws ExecutionException, InterruptedException {
        lock.lock();
        Iterator<Future<AiClass>> iterator = futures.iterator();

        while (iterator.hasNext()) {
            Future<AiClass> future = iterator.next();
            if (future.isDone()) {
                iterator.remove();
                future.get();
            }
        }
        lock.unlock();
    }
}
