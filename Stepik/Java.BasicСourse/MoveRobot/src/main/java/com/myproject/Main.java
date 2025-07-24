package com.myproject;

public class Main {
    public static void main(String[] args) {

    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        int dx = toX - robot.getX();
        if (dx != 0) {
            Direction desiredDirection = (dx > 0) ? Direction.RIGHT : Direction.LEFT;

            turnRobot(robot, desiredDirection);

            for (int i = 0; i < Math.abs(dx); i++) {
                robot.stepForward();
            }
        }

        int dy = toY - robot.getY();
        if (dy != 0) {
            Direction desiredDirection = (dy > 0) ? Direction.UP : Direction.DOWN;

            turnRobot(robot, desiredDirection);

            for (int i = 0; i < Math.abs(dy); i++) {
                robot.stepForward();
            }
        }
    }

    private static void turnRobot(Robot robot, Direction desiredDirection) {
        while (robot.getDirection() != desiredDirection) {
            if (shouldTurnRight(robot.getDirection(), desiredDirection)) {
                robot.turnRight();
            } else {
                robot.turnLeft();
            }
        }
    }

    private static boolean shouldTurnRight(Direction current, Direction desired) {
        switch (current) {
            case UP: return desired == Direction.RIGHT;
            case RIGHT: return desired == Direction.DOWN;
            case DOWN: return desired == Direction.LEFT;
            case LEFT: return desired == Direction.UP;
            default: return false;
        }
    }
}