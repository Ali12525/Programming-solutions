package com.myproject;

public class Main {
    public static void main(String[] args) {

    }

    public static String getCallerClassAndMethodName() {
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();

        if (stack.length < 4) {
            return null;
        }
        
        StackTraceElement caller = stack[3];
        return caller.getClassName() + "#" + caller.getMethodName();
    }
}