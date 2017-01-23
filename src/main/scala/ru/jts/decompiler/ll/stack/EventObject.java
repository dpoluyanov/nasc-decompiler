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

package ru.jts.decompiler.ll.stack;

import ru.jts.decompiler.class_model.ClassContainer;
import ru.jts.decompiler.class_model.ClassField;
import ru.jts.decompiler.class_model.ClassMethod;
import ru.jts.decompiler.class_model.MethodParameter;
import ru.jts.decompiler.gameserver.ScalaMakerEventHandler;
import ru.jts.decompiler.gameserver.ScalaNpcEventHandler;
import ru.jts.decompiler.ll.AiClass;

import java.util.List;
import java.util.Stack;

/**
 * Created by Дмитрий on 15.05.2015.
 */
public class EventObject extends StackObject {
    private final int eventId;
    public MethodParameter parameter;
    protected Class eventType;
    protected EventObject parent;
    String name;
    private boolean negate;

    public EventObject(AiClass aiClass, int eventId, EventObject parent) {
        super(aiClass);
        this.eventId = eventId;
        this.parent = parent;

        appendName();
    }


    private void appendName() {

        Class clazz = ScalaNpcEventHandler.class;
        if (aiClass.type == 1) clazz = ScalaMakerEventHandler.class;

        if (parent != null) {
            clazz = parent.eventType;
        }

        if (!(this instanceof FuncCallEvent)) {
            ClassContainer classContainer = ClassContainer.getInstance();

            ClassField field = classContainer.findField(eventId, clazz);

            if (field == null) {
                ClassMethod classMethod = classContainer.findMethod(aiClass.handler, clazz);

                MethodParameter parameter = classMethod.findParameter(eventId);

                String pName = parameter.eventName;
                if (pName.equals("private")) pName = "`private`";
                name = pName;
                eventType = parameter.type;
                this.parameter = parameter;
            } else if (field != null) {
                String fName = field.getEventName();
                if (fName.equals("type")) fName = "`type`";
                name = fName;
                eventType = field.getType();
            } else {
                System.err.println("EventObject: not found eventId=" + eventId + " in class=" + clazz.getSimpleName());
            }
        }
    }

    public int getEventId() {
        return eventId;
    }

    public Class getEventType() {
        return eventType;
    }

    public EventObject addSubEvent(int subEventId) {
        return new EventObject(aiClass, subEventId, this);
    }

    public ClassMethod getFunc(int eventId) {
        ClassContainer classContainer = ClassContainer.getInstance();

        ClassMethod classMethod = classContainer.findMethod(eventId, eventType);

        return classMethod;
    }

    public FuncCallEvent addFuncWith(int eventId, ClassMethod method, List<StackObject> params) {
        return new FuncCallEvent(aiClass, eventId, this, method, params);
    }

    @Override
    public String toString() {
        String str = "";
        Stack<EventObject> tempStack = new Stack<>();
        EventObject parent = this.parent;

        while (parent != null) {
            tempStack.push(parent);
            parent = parent.parent;
        }

        while (tempStack.size() > 0) {
            str += tempStack.pop().getName();
            str += ".";
        }
        str += this.getName();
        if (negate)
            str = "-" + str;

        return str;
    }

    public String getName() {
        String eventName = aiClass.eventHandler.getEventName(parameter);
        if (eventName != null) return eventName;
        return name;
    }

    public EventObject negate() {
        this.negate = !negate;
        return this;
    }
}
