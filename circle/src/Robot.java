import java.util.ArrayList;

import rec.robotino.com.Bumper;
import rec.robotino.com.Com;
import rec.robotino.com.DistanceSensor;
import rec.robotino.com.Motor;
import rec.robotino.com.Odometry;
import rec.robotino.com.OmniDrive;

public class Robot implements Runnable {

	protected final String hostname;
	protected final Com com;
	protected final Motor motor1;
	protected final Motor motor2;
	protected final Motor motor3;
	protected final OmniDrive omniDrive;
	protected final Bumper bumper;
	protected final Odometry odometry;
	private float XFrontSpeed;
	private float YLeftSpeed;

	public Robot(String hostname) {
		this.hostname = hostname;
		com = new Com();
		motor1 = new Motor();
		motor2 = new Motor();
		motor3 = new Motor();
		omniDrive = new OmniDrive();
		bumper = new Bumper();
		odometry = new Odometry();
		
//		run();
	}
	
	public void run() {
		System.out.println("Robot started.");

		try {
			System.out.println("Initializing...");
			init();
			System.out.println("Connecting...");
			connect(hostname);
			System.out.println("Connected.");
			System.out.println("You cand driving...");
			
			SimpleDriver();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		System.out.println("Done.");
	}

	public void run(GlobalPoint point) {
		System.out.println("Robot started.");

		try {
			System.out.println("Initializing...");
			init();
			System.out.println("Connecting...");
			connect(hostname);
			System.out.println("Connected.");
			System.out.println("You cand driving...");
			
			driveToPoint2(point);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		System.out.println("Done.");
	}

	public void run(ArrayList<GlobalPoint> globalPoints) {
		System.out.println("Robot started.");

		try {
			System.out.println("Initializing...");
			init();
			System.out.println("Connecting...");
			connect(hostname);
			System.out.println("Connected.");
			System.out.println("You cand driving...");

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		System.out.println("Done.");
	}
	
	/*
	 * Just for test odometers.
	 */
	private void SimpleDriver() {
		System.out.println("Start driving");
		odometry.set(0, 0, 0);
		System.out.println(odometry.x());
		omniDrive.setVelocity(260, 0, 0);
		while (true) {
			if (odometry.x() > 400) {
				omniDrive.setVelocity(0, 0, 0);
				break;
			}
		}
		System.out.println(odometry.x());
		System.out.println("Stop driving");
	}
	
	private void driveToPoint2(GlobalPoint point) {
		System.out.println("Start driving");
		
		double distance = 0;
		double dx = 0;
		double dy = 0;
		double xSpeedCoef = 0;
		double ySpeedCoef = 0;
		double xSpeed = 0;
		double ySpeed = 0;
		
		distance = Math.sqrt(Math.pow(point.getX() - odometry.x(), 2) + 
				Math.pow(point.getY() - odometry.y(), 2));
		
		if (Math.abs(odometry.x() - point.getX()) > 1 || 
				Math.abs(odometry.y() - point.getY()) > 1) {
			 dx = point.getX() - odometry.x();
			 dy = point.getY() - odometry.y();
		
			 
			 xSpeedCoef = dx / distance;
			 ySpeedCoef = dy / distance;
			 
			 xSpeed = xSpeedCoef * Constants.LINE_SPEED;
			 ySpeed = ySpeedCoef * Constants.LINE_SPEED;
			
			 omniDrive.setVelocity((float)xSpeed, (float)ySpeed, 0);
			
			while (distance > Constants.SLOW_RADIUS) {
			
				distance = Math.sqrt(Math.pow(point.getX() - odometry.x(), 2) + 
						Math.pow(point.getY() - odometry.y(), 2));
				
				System.out.print("Remaining distance: ");
				System.out.println(distance);
				System.out.println(odometry.x());
				System.out.println(odometry.y());
				System.out.println(point.getX());
				System.out.println(point.getY());
			}
			
			double slowCoef = distance / Constants.SLOW_RADIUS;
			omniDrive.setVelocity((float)(xSpeed * slowCoef), (float)(ySpeed * slowCoef), 0);
				
			while (distance > Constants.MIN_RADIUS) {

				
				distance = Math.sqrt(Math.pow(point.getX() - odometry.x(), 2) + 
						Math.pow(point.getY() - odometry.y(), 2));

				slowCoef = distance / Constants.SLOW_RADIUS;
				omniDrive.setVelocity((float)(xSpeed * slowCoef), (float)(ySpeed * slowCoef), 0);
				
				System.out.print("Remaining distance: ");
				System.out.println(distance);
				System.out.println(odometry.x());
				System.out.println(odometry.y());
				System.out.println(point.getX());
				System.out.println(point.getY());
			}			
			
			omniDrive.setVelocity(0, 0, 0);
			
			// Stop the robot
		}
				
		
		System.out.println("Stop driving");
	}
	
	/*
	 * Main function to move to the XY coordinates.
	 */
	private void driveToPoint(GlobalPoint point) {
		System.out.println("Start driving");
		
		// Move the robot around itself to turn to 0 angle
		while (odometry.phi() > 1 || odometry.phi() < -1) {
			if (odometry.phi() > 0) {
				omniDrive.setVelocity(0, 0, -30);
			} else {
				omniDrive.setVelocity(0, 0, 30);
			}
			// System.out.println(odometry.phi());
		}
		
		// проверить координаты
		while (Math.abs(odometry.x() - point.getX()) > 1 || 
				Math.abs(odometry.y() - point.getY()) > 1) {
			
			XFrontSpeed = (point.getX() - odometry.x()) * 10;
			YLeftSpeed = (point.getY() - odometry.y()) * 10;
			
			if ( Math.abs(odometry.x() - point.getX()) > Constants.SENSOR_RADIUS-90) {
				if (odometry.x() - point.getX() < 0){
					XFrontSpeed = Constants.LINE_SPEED;
				} else {
					XFrontSpeed = -Constants.LINE_SPEED;
				}
			}
			if ( Math.abs(odometry.y() - point.getY()) > Constants.SENSOR_RADIUS-90) {
				if (odometry.y() - point.getY() < 0){
					YLeftSpeed = Constants.LINE_SPEED;
				} else {
					YLeftSpeed = -Constants.LINE_SPEED;
				}
			}

			omniDrive.setVelocity( XFrontSpeed, YLeftSpeed, 0);
			
			System.out.println(odometry.x() + "\t(" + point.getX() + ") - "
								+ odometry.y() + "\t(" + point.getY() + ")");
		}
		
		System.out.println("Stop driving");
	}

	private void drive(ArrayList<GlobalPoint> globalPoints) {
		System.out.println(globalPoints);

		for (GlobalPoint point : globalPoints) {
			// место
			// повернуться на 0
//			odometry.set(0, 0, 160);
			while (odometry.phi() > 1 || odometry.phi() < -1) {
				if (odometry.phi() > 0) {
					omniDrive.setVelocity(0, 0, -30);
				} else {
					omniDrive.setVelocity(0, 0, 30);
				}
				// System.out.println(odometry.phi()); 	//test
			}
			// проверить координаты
			while (Math.abs(odometry.x() - point.getX()) > 1 || 
					Math.abs(odometry.y() - point.getY()) > 1) {
				
				XFrontSpeed = (point.getX() - odometry.x())*10;
				YLeftSpeed = (point.getY() - odometry.y())*10;

				if ( Math.abs(odometry.x() - point.getX()) > Constants.SENSOR_RADIUS-90) {
					if (odometry.x() - point.getX() < 0){
						XFrontSpeed = Constants.LINE_SPEED;
					} else {
						XFrontSpeed = -Constants.LINE_SPEED;
					}
				}
				if ( Math.abs(odometry.y() - point.getY()) > Constants.SENSOR_RADIUS-90) {
					if (odometry.y() - point.getY() < 0){
						YLeftSpeed = Constants.LINE_SPEED;
					} else {
						YLeftSpeed = -Constants.LINE_SPEED;
					}
				}
	
				omniDrive.setVelocity( XFrontSpeed, YLeftSpeed, 0);
				
				System.out.println(odometry.x() + "\t(" + point.getX() + ") - "
									+ odometry.y() + "\t(" + point.getY() + ")");
			}
		}
	}

	protected void init() {
		motor1.setComId(com.id());
		motor1.setMotorNumber(0);

		motor2.setComId(com.id());
		motor2.setMotorNumber(1);

		motor3.setComId(com.id());
		motor3.setMotorNumber(2);

		omniDrive.setComId(com.id());

		bumper.setComId(com.id());
		
		odometry.setComId(com.id());

		odometry.set(0, 0, 0);
	}

	protected void connect(String hostname) {
		com.setAddress(hostname);
		com.connect();
	}

	protected void disconnect() {
		com.disconnect();
	}
	
	protected void driveAToB() throws InterruptedException {
//		long startTime = System.currentTimeMillis();

		ArrayList<Float> distances = new ArrayList<>();
		String flag = Constants.FIND_FRONT_LEFT_FLAG;
		
		odometry.set(0, 0, 0);

		while (!Thread.interrupted() && com.isConnected() && false == bumper.value()) {
//			long elapsedTime = System.currentTimeMillis() - startTime;

			distances = getDistance();
			System.out.println(distances.toString());

			float XFrontSpeed = (distances.get(0) - Constants.ACCESS_WALL_DISTANCE)* (-100);
			float YLeftSpeed = (distances.get(2) - Constants.ACCESS_WALL_DISTANCE)* (-100);
			float YRightSpeed = (distances.get(7) - Constants.ACCESS_WALL_DISTANCE)* (100);
			float XBackSpeed = (distances.get(4) - Constants.ACCESS_WALL_DISTANCE)* (100);

			switch (flag) {
				case Constants.FIND_FRONT_LEFT_FLAG:{
					omniDrive.setVelocity( XFrontSpeed, YLeftSpeed, 0);
					System.out.println(YLeftSpeed + " - " +  XFrontSpeed);
					
					if (Math.abs(YLeftSpeed) < Constants.ACCESS_WALL_DISTANCE + 50 && Math.abs(XFrontSpeed) < Constants.ACCESS_WALL_DISTANCE + 50){
						flag = Constants.ROTATE_FLAG;
						System.out.println("ROTATE_FLAG");
//						System.out.println("x: " + odometry.x() + "\ty: " + odometry.y() + "\tphi: " + odometry.phi());
					}
				}
				break;
				case Constants.FIND_BACK_LEFT_FLAG:{
					omniDrive.setVelocity( XBackSpeed, YLeftSpeed, 0);
					System.out.println(YLeftSpeed + " - " +  XFrontSpeed);
					
					if (Math.abs(YLeftSpeed) < Constants.ACCESS_WALL_DISTANCE + 50 && Math.abs(XBackSpeed) < Constants.ACCESS_WALL_DISTANCE + 50){
						flag = Constants.STOP_FLAG;
					}
				}
				break;
				case Constants.FIND_BACK_RIGHT_FLAG:{
					omniDrive.setVelocity( XBackSpeed, YRightSpeed, 0);
					
					if (Math.abs(YRightSpeed) < Constants.ACCESS_WALL_DISTANCE + 50 && Math.abs(XBackSpeed) < Constants.ACCESS_WALL_DISTANCE + 50){
						flag = Constants.ROTATE_FLAG;
						System.out.println("ROTATE_FLAG");
					}
				}
					break;
				case Constants.ROTATE_FLAG:{
			
					if (!(Math.abs(YRightSpeed) < Constants.ACCESS_WALL_DISTANCE + 50 && Math.abs(XBackSpeed) < Constants.ACCESS_WALL_DISTANCE + 50) ){
						omniDrive.setVelocity(0, 0, 50);
					} else {
						flag = Constants.FIND_BACK_LEFT_FLAG;
					}
				}
				break;
				
				default:{
					omniDrive.setVelocity( 0, 0, 0);
				}
					break;
			}

			com.waitForUpdate();
		}
	}
	
	protected void driveAToBToD() throws InterruptedException {
//		long startTime = System.currentTimeMillis();
		
		ArrayList<Float> distances = new ArrayList<>();
		String flag = Constants.FIND_START_POSITION_FLAG;
		
		odometry.set(0, 0, 0);
		
		while (!Thread.interrupted() && com.isConnected() && false == bumper.value()) {
//			long elapsedTime = System.currentTimeMillis() - startTime;
			
			distances = getDistance();
			System.out.println(distances.toString());
			
			float XFrontSpeed = (distances.get(0) - Constants.ACCESS_WALL_DISTANCE)* (-100);
			float YLeftSpeed = (distances.get(2) - Constants.ACCESS_WALL_DISTANCE)* (-100);
			float YRightSpeed = (distances.get(7) - Constants.ACCESS_WALL_DISTANCE)* (100);
			float XBackSpeed = (distances.get(4) - Constants.ACCESS_WALL_DISTANCE)* (100);
			
			switch (flag) {
			case Constants.FIND_START_POSITION_FLAG:{
				omniDrive.setVelocity( XFrontSpeed, YLeftSpeed, 0);
				System.out.println(YLeftSpeed + " - " +  XFrontSpeed);
				
				if (Math.abs(YLeftSpeed) < Constants.ACCESS_WALL_DISTANCE + 50 && Math.abs(XFrontSpeed) < Constants.ACCESS_WALL_DISTANCE + 50){
					flag = Constants.ROTATE_TO_START_POSIOTION_FLAG;
					System.out.println("ROTATE_TO_START_POSIOTION_FLAG");
//						System.out.println("x: " + odometry.x() + "\ty: " + odometry.y() + "\tphi: " + odometry.phi());
				}
			}
			break;
			case Constants.ROTATE_TO_START_POSIOTION_FLAG:{
				
				if (!(Math.abs(YLeftSpeed) < Constants.ACCESS_WALL_DISTANCE + 50 && Math.abs(XBackSpeed) < Constants.ACCESS_WALL_DISTANCE + 50) ){
					omniDrive.setVelocity(0, 0, 50);
				} else {
					odometry.set(0, 0, 0);
					flag = Constants.GO_TO_B_FLAG;
				}
			}
			break;
			case Constants.GO_TO_B_FLAG:{
				if (odometry.x() < 1400) {
					XFrontSpeed = 100;
				}
				omniDrive.setVelocity( XFrontSpeed, YLeftSpeed, 0);
				System.out.println(odometry.x() + " - " +  odometry.y());
				
				if (Math.abs(YLeftSpeed) < Constants.ACCESS_WALL_DISTANCE + 50 && Math.abs(XFrontSpeed) < Constants.ACCESS_WALL_DISTANCE + 50){
					flag = Constants.ROTATE_ON_B_POSITION_FLAG;
				}
			}
			break;
			case Constants.ROTATE_ON_B_POSITION_FLAG:{
				
				if (!(Math.abs(YRightSpeed) < Constants.ACCESS_WALL_DISTANCE + 50 && Math.abs(XBackSpeed) < Constants.ACCESS_WALL_DISTANCE + 50) ){
					omniDrive.setVelocity(0, 0, 50);
				} else {
					odometry.set(1500, 0, 180);
					flag = Constants.GO_TO_D_FLAG;
				}
			}
			break;
			case Constants.GO_TO_D_FLAG:{
				if (odometry.x() > 100) {
					XFrontSpeed = 100;
				}
				if (odometry.y() > -850) {
					YLeftSpeed = 100;
				}
				omniDrive.setVelocity( XFrontSpeed, YLeftSpeed, 0);
				System.out.println(odometry.x() + " - " +  odometry.y());
				
				if (Math.abs(YLeftSpeed) < Constants.ACCESS_WALL_DISTANCE + 50 && Math.abs(XFrontSpeed) < Constants.ACCESS_WALL_DISTANCE + 50){
					flag = Constants.STOP_FLAG;
				}
			}
			break;
			case Constants.FIND_BACK_RIGHT_FLAG:{
				omniDrive.setVelocity( XBackSpeed, YRightSpeed, 0);
				
				if (Math.abs(YRightSpeed) < Constants.ACCESS_WALL_DISTANCE + 50 && Math.abs(XBackSpeed) < Constants.ACCESS_WALL_DISTANCE + 50){
					flag = Constants.ROTATE_FLAG;
					System.out.println("ROTATE_FLAG");
				}
			}
			break;
			
			default:{
				omniDrive.setVelocity( 0, 0, 0);
			}
			break;
			}
			
			com.waitForUpdate();
		}
	}

	private ArrayList<Float> getDistance() {
		ArrayList<Float> distances = new ArrayList<>();
		DistanceSensor distanceSensor = new DistanceSensor();

		for (int i = 0; i < 9; i++){
			distanceSensor.setSensorNumber(i);
			distanceSensor.setComId(com.id());
			
			distances.add(distanceSensor.voltage());
		}
		return distances;
	}
}