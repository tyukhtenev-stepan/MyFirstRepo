package com.jcourse.tyukhtenev.lab3.stackcalc2;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.*;

public class Factory {
    private static Factory factory = new Factory();    // Класс Фабрика будет Singleton
    private Stack<Double> stack = new Stack<>();             // Стэк для хранения значений
    private Map<String, Double> defineMap = new HashMap<>(); // map для хранения переменных
    private Map<String, Command> commands = new HashMap<>(); // map для хранения команд

    private Factory() {
        create();
    }

    public void create() {
        Properties prop = new Properties();

        // Читаем properties из файла command.properties
        try (InputStream in = getClass().getResourceAsStream("commands.properties")) {
            prop.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (Map.Entry<Object, Object> entry : prop.entrySet()) {
            String name = entry.getValue().toString();
            String className = entry.getKey().toString();
            try {
                Class classFile = Class.forName(name);
                Command command = (Command) classFile.newInstance();

                if (StackCalc2.isDebug) {
                    //
                    Command cmdProxy = (Command) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[] {command.getClass()}, new Invoker(command, stack, defineMap));
                    commands.put(className, cmdProxy);
                } else {
                    commands.put(className, command);
                }

                // Проверяем поля в аннотации
                Field[] fields = classFile.getDeclaredFields();
                if (fields != null) {
                    for (Field field : fields) {
                        if (field.isAnnotationPresent(In.class)) {
                            In annotation = field.getAnnotation(In.class);
                            Arg argType = annotation.getArg();

                            switch (argType) {
                                case STACK:
                                    field.setAccessible(true);
                                    field.set(command, stack);
                                    break;
                                case VARIABLES:
                                    field.setAccessible(true);
                                    field.set(command, defineMap);
                                    break;
                                default:
                                    throw new RuntimeException("Ошибка обработки аннотации " + argType);
                            }
                        }
                    }
                }

            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                System.out.println("Не удалось создать класс: " + className);
                e.printStackTrace();
            }
        }
    }

    public static Factory createFactory() {
        return factory;
    }

    // Получить команду по имени из hashmap
    public Command getCommandByName(String cmdName) {
        return commands.get(cmdName);
    }

    // Существует ли вообще команда в hashmap
    public boolean existCommand(String cmdName) {
        return commands.containsKey(cmdName);
    }

    // Получить стэк
    public Stack getStack() {
        return stack;
    }

    public Map getVariables() {
        return defineMap;
    }
}