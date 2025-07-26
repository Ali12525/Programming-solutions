package com.myproject;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class Main {
    public static void main(String[] args) {

    }

    private static void configureLogging() {
        Logger classALogger = Logger.getLogger("org.stepic.java.logging.ClassA");
        classALogger.setLevel(Level.ALL);

        Logger classBLogger = Logger.getLogger("org.stepic.java.logging.ClassB");
        classBLogger.setLevel(Level.WARNING);

        Logger stepicLogger = Logger.getLogger("org.stepic.java");

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        consoleHandler.setFormatter(new XMLFormatter());

        stepicLogger.addHandler(consoleHandler);
        stepicLogger.setUseParentHandlers(false);
    }
}