import java.util.ArrayList;

// port of the c++ example
// without callbacks, as java does not support them directly

public class Main
{
	private static ArrayList<GlobalPoint> points;
	
    public static void main(String[] args)
    {
        String hostname = System.getProperty("hostname", "172.26.1.1");
//        String hostname = System.getProperty("hostname", "127.0.0.1:8080");

        init();
        
        Robot robot = new Robot(hostname);
//        robot.run(points.get(0));
//        robot.run(points.get(1));
//        robot.run(points.get(2));
//        robot.run();
//        robot.run(points.get(4));
        
    }

	private static void init() {
		points = new ArrayList<GlobalPoint>();
		
		points.add(0, new GlobalPoint(-1300, 450, 0, 
				-1f, Constants.ACCESS_WALL_DISTANCE, Constants.ACCESS_WALL_DISTANCE, -1f));
		points.add(1, new GlobalPoint(0, -950, 0, 
				Constants.ACCESS_WALL_DISTANCE, Constants.ACCESS_WALL_DISTANCE, -1f, -1f));
		points.add(2, new GlobalPoint(1300, 200, 0, 
				Constants.ACCESS_WALL_DISTANCE, -1f, Constants.ACCESS_WALL_DISTANCE, -1f));
		points.add(3, new GlobalPoint(0, 400, 0, 
				-1f, -1f, Constants.ACCESS_WALL_DISTANCE, Constants.ACCESS_WALL_DISTANCE));
		points.add(4, new GlobalPoint(0, -500, 0, 
				-1f, -1f, Constants.ACCESS_WALL_DISTANCE, Constants.ACCESS_WALL_DISTANCE));
		points.add(5, new GlobalPoint(0, 300, 0, 
				-1f, -1f, Constants.ACCESS_WALL_DISTANCE, Constants.ACCESS_WALL_DISTANCE));
	}	
	
}