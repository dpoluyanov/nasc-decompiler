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

package ru.jts.decompiler.ll;

import ru.jts.decompiler.class_model.MethodParameter;
import ru.jts.decompiler.gameserver.ScalaMakerEventHandler;
import ru.jts.decompiler.gameserver.ScalaNpcEventHandler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Дмитрий on 15.05.2015.
 */
public class AiClass {
    public final int type;
    private final String parent;
    private String className;
    // current processing handler
    public int handler;
    public EventHandler eventHandler;
    public Set<ParameterDefine> parameterDefines;
    public List<PropertyDefine> propertyDefines;
    private List<EventHandler> eventHandlers;
    private Set<String> imports;

    public AiClass(int type, String className, String parent) {
        this.type = type;
        this.className = className;
        this.eventHandlers = new ArrayList<>();
        this.parameterDefines = new HashSet<>();
        this.propertyDefines = new ArrayList<>();
        this.imports = new HashSet<>();

        if (parent == null) {
            this.parent = type == 0 ? ScalaNpcEventHandler.class.getSimpleName() : ScalaMakerEventHandler.class.getSimpleName();
            if (this.parent.equals(ScalaNpcEventHandler.class.getSimpleName())) {
                imports.add(ScalaNpcEventHandler.class.getName());
            } else {
                imports.add(ScalaMakerEventHandler.class.getName());
            }
        } else
            this.parent = parent;
    }

    public String getParent() {
        return parent;
    }

    public String getClassName() {
        return className;
    }

    public void writeToFile() throws IOException {
        String _package = "pts_scripts.npc";
        if (type == 1)
            _package = "pts_scripts.maker";

        String filePrefix = "data/src/main/scala/pts_scripts/npc/";
        if (type == 1) filePrefix = "data/src/main/scala/pts_scripts/maker/";

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(filePrefix + className + ".scala")))) {
            bufferedWriter.write("package " + _package + "\n\n");

            for (String import_ : imports) {
                bufferedWriter.write("import " + import_ + "\n");
            }

            if (imports.size() > 0)
                bufferedWriter.write("\n");

            if (className.equals("object"))
                className = "`object`";

            bufferedWriter.write("class " + className + " extends " + parent + " {\n");

            // parameter defines

            for (ParameterDefine parameterDefine : parameterDefines) {
                bufferedWriter.write("\tdef " + parameterDefine.getName() + " = " + parameterDefine.getValue() + "\n\n");
            }

            // property defines

            for (PropertyDefine propertyDefine : propertyDefines) {
                bufferedWriter.write(propertyDefine.toString() + "\n");
            }

            for (int i = 0; i < eventHandlers.size(); i++) {
                EventHandler eventHandler = eventHandlers.get(i);

                eventHandler.writeToFile(bufferedWriter);

                if (i + 1 != eventHandlers.size()) bufferedWriter.write("\n");
            }

            // class body

            bufferedWriter.write("}");

            bufferedWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setParameterDefines(Set<ParameterDefine> parameterDefines) {
        this.parameterDefines = parameterDefines;
    }

    public void addEventHandler(EventHandler eventHandler) {
        eventHandlers.add(eventHandler);
    }

    public void setPropertyDefines(List<PropertyDefine> propertyDefines) {
        this.propertyDefines = propertyDefines;
    }

    public void restoreImports() {
        if (parent == null) {
            if (type == 0) imports.add(ScalaNpcEventHandler.class.getName());
            else if (type == 1) imports.add(ScalaMakerEventHandler.class.getName());
        }

        for (ParameterDefine parameter : parameterDefines) {
            if (parameter.getTypeClass() != int.class && parameter.getTypeClass() != double.class
                    && parameter.getTypeClass() != String.class && parameter.getTypeClass() != long.class) {
                imports.add(parameter.getTypeClass().getName());
            }
        }

        if (propertyDefines.size() > 0) {
            for (PropertyDefine property : propertyDefines) {

                imports.add(property.getClazz().getName());
            }
        }


        for (EventHandler eventHandler : eventHandlers) {
            for (MethodParameter parameter : eventHandler.getMethod().getParameters().values()) {
                if (parameter.type != int.class && parameter.type != double.class && parameter.type != String.class) {
                    imports.add(parameter.type.getName());
                }
            }
        }
    }

    public void addStaticImport(String _import) {
        imports.add(_import);
    }
}
