import java.util.Arrays;

/**
 * 
 * @author Simkhotech
 *
 */
public class GlobalPoint {
	
	/**
	 * global location
	 * for odometry
	 * 
	 * [0] - X
	 * [1] - Y
	 * [2] = Phi
	 */
	int[] position;
	
	/**
	 * sensor values
	 * 
	 * 0..3 - voltage
	 * -1 - for ignore sensor
	 * 
	 * [0] - front
	 * [1] - left
	 * [2] - back
	 * [3] - right
	 */
	float[] positionBySensors;
	
	/**
	 * global location
	 * 
	 * int[3]
	 * @param position
	 * [0] - X
	 * [1] - Y
	 * [2] = Phi
	 * 
	 * float[9]
	 * @param positionBySensors
	 * [0] - front
	 * [1] - left
	 * [2] - back
	 * [3] - right
	 */
	public GlobalPoint(int x, int y, int phi, float front, float left, float back, float right) {
		int[] thatPosition = {x, y, phi};
		this.position = thatPosition; 
		
		float[] thatPositionBySensors = {front, left, back, right};
		this.positionBySensors = thatPositionBySensors;
	}

	public final int[] getPosition() {
		return position;
	}

	public void setPosition(int[] position) {
		this.position = position;
	}

	public final float[] getPositionBySensors() {
		return positionBySensors;
	}

	public void setPositionBySensors(float[] positionBySensors) {
		this.positionBySensors = positionBySensors;
	}

	@Override
	public String toString() {
		return "\nPoint [position=" + Arrays.toString(this.position)
				+ ", positionBySensors=" + Arrays.toString(this.positionBySensors)
				+ "]";
	}

	public int getX() {
		return position[Constants.X];
	}

	public int getY() {
		return position[Constants.Y];
	}

	public int getPhi() {
		return position[Constants.PHI];
	}

	public int getFront() {
		return position[Constants.FRONT];
	}
	
	public int getBack() {
		return position[Constants.BACK];
	}

	public int getLeft() {
		return position[Constants.LEFT];
	}
	
	public int getRight() {
		return position[Constants.RIGHT];
	}
}