import Robot.Robot;
import Robot.Direction;

public class Main {
    public static void main(String[] args) {
        Robot robot = new Robot(-5, -3, Direction.UP);
        Robot.moveTo(3, 0, robot);
        System.out.println("Another moveTo:");
        Robot.moveTo(3, 0, robot);
    }
}