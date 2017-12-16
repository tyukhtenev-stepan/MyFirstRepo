package com.jcourse.tyukhtenev.lab3.stackcalc2;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationHandler;
import java.util.Map;
import java.util.Stack;

public class Invoker implements InvocationHandler {
    private Command command;
    private Stack stack;
    private Map varMap;
    private Logger logger;

    public Invoker (Command command, Stack stack, Map varMap) {
        this.command = command;
        this.stack = stack;
        this.varMap = varMap;

        this.logger = LogManager.getLogger("1.log");
        this.logger = LogManager.getLogger(command.getClass());
    }

    @Override
    public Object invoke(Object proxy, Method method, Object args[]) throws Throwable {
        logger.debug("Stack before " + stack);
        logger.debug("Context " + varMap);
        logger.debug("Arguments " + args[0]);

        if (method.getName().equals("getEnoughParams")) {
            return command.getEnoughParams();
        }

        if (method.getName().equals("execute")) {
            command.execute((String) args[0]);
        }
        logger.debug("Stack after" + stack);
        return null;
    }
}
