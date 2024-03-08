package Robot;

public class Robot {
    private Direction direction = Direction.UP;
    private int currentX = 0;
    private int currentY = 0;

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return currentX;
    }

    public int getY() {
        return currentY;
    }

    public void turnLeft() {
        direction = direction.turnLeft();
        System.out.println("Turned Left");
    }

    public void turnRight() {
        direction = direction.turnRight();
        System.out.println("Turned Right");
    }

    public void stepForward() {
        switch (direction) {
            case UP -> currentY++;
            case DOWN -> currentY--;
            case LEFT -> currentX--;
            case RIGHT -> currentX++;
        }
        System.out.println("Stepped Forward");
    }

    public static void moveTo(int X, int Y, Robot robot) {
        System.out.println("moveTo is called");
        while (robot.getX() != X || robot.getY() != Y) {
            if (robot.getX() < X && robot.getDirection() != Direction.RIGHT) {
                switch (robot.getDirection()) {
                    case UP:
                        robot.turnRight();
                        break;
                    case DOWN:
                        robot.turnLeft();
                        break;
                    case LEFT:
                        robot.turnLeft();
                        robot.turnLeft();
                        break;
                }
            }
            if (robot.getX() > X && robot.getDirection() != Direction.LEFT) {
                switch (robot.getDirection()) {
                    case UP:
                        robot.turnLeft();
                        break;
                    case DOWN:
                        robot.turnRight();
                        break;
                    case RIGHT:
                        robot.turnRight();
                        robot.turnRight();
                        break;
                }
            }
            if (robot.getY() < Y && robot.getDirection() != Direction.UP) {
                switch (robot.getDirection()) {
                    case LEFT:
                        robot.turnRight();
                        break;
                    case RIGHT:
                        robot.turnLeft();
                        break;
                    case DOWN:
                        robot.turnRight();
                        robot.turnRight();
                        break;
                }
            }
            if (robot.getY() > Y && robot.getDirection() != Direction.DOWN) {
                switch (robot.getDirection()) {
                    case LEFT:
                        robot.turnLeft();
                        break;
                    case RIGHT:
                        robot.turnRight();
                        break;
                    case UP:
                        robot.turnRight();
                        robot.turnRight();
                        break;
                }
            }
            robot.stepForward();
        }
    }
}
