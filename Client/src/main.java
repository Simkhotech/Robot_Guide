import by.bstu.robotics.Robot.Constants;
import by.bstu.robotics.Robot.GlobalPoint;
import by.bstu.robotics.Robot.Robot;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Robot robot = new Robot("172.26.1.1");
        robot.run(new GlobalPoint(100, 0, 0, -1f, Constants.ACCESS_WALL_DISTANCE, Constants.ACCESS_WALL_DISTANCE, -1f));

	}

}
