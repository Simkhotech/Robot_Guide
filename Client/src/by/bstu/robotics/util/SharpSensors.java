/**
 * 
 */

package by.bstu.robotics.util;

import java.util.Random;

/**
 * @author Simkhotech
 * 
 */
public class SharpSensors {
	int sensor1;
	int sensor2;
	int sensor3;
	int sensor4;
	int sensor5;
	int sensor6;
	int sensor7;
	int sensor8;

	public SharpSensors() {
		
		Random random = new Random();
				
		this.sensor1 = random.nextInt(120);
		this.sensor2 = random.nextInt(120);
		this.sensor3 = random.nextInt(120);
		this.sensor4 = random.nextInt(120);
		this.sensor5 = random.nextInt(120);
		this.sensor6 = random.nextInt(120);
		this.sensor7 = random.nextInt(120);
		this.sensor8 = random.nextInt(120);
	}

	public int getSensor1() {
		return sensor1;
	}

	public void setSensor1(int sensor1) {
		this.sensor1 = sensor1;
	}

	public int getSensor2() {
		return sensor2;
	}

	public void setSensor2(int sensor2) {
		this.sensor2 = sensor2;
	}

	public int getSensor3() {
		return sensor3;
	}

	public void setSensor3(int sensor3) {
		this.sensor3 = sensor3;
	}

	public int getSensor4() {
		return sensor4;
	}

	public void setSensor4(int sensor4) {
		this.sensor4 = sensor4;
	}

	public int getSensor5() {
		return sensor5;
	}

	public void setSensor5(int sensor5) {
		this.sensor5 = sensor5;
	}

	public int getSensor6() {
		return sensor6;
	}

	public void setSensor6(int sensor6) {
		this.sensor6 = sensor6;
	}

	public int getSensor7() {
		return sensor7;
	}

	public void setSensor7(int sensor7) {
		this.sensor7 = sensor7;
	}

	public int getSensor8() {
		return sensor8;
	}

	public void setSensor8(int sensor8) {
		this.sensor8 = sensor8;
	}

	@Override
	public String toString() {
		return "SharpSensors [sensor1=" + sensor1 + ", sensor2=" + sensor2
				+ ", sensor3=" + sensor3 + ", sensor4=" + sensor4
				+ ", sensor5=" + sensor5 + ", sensor6=" + sensor6
				+ ", sensor7=" + sensor7 + ", sensor8=" + sensor8 + "]";
	}

}