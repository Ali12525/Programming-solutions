package com.myproject;

public class Main {
    public static void main(String[] args) {

    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        final int MAX_ATTEMPTS = 3;

        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            RobotConnection connection = null;
            try {
                connection = robotConnectionManager.getConnection();
                connection.moveRobotTo(toX, toY);
                return;
            } catch (RobotConnectionException e) {
                if (attempt == MAX_ATTEMPTS) {
                    throw e;
                }
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Exception ignored) {}
                }
            }
        }
    }
}