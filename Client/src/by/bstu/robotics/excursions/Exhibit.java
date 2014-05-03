/**
 * �������� ���������
 */
package by.bstu.robotics.excursions;


/**
 * @author Performance
 * 
 */
public class Exhibit {

	int id;
	String name;
	boolean use;
	String audioURL;
	String description;
	int x;
	int y;
	
	public Exhibit(int id, String name, boolean use, String audioURL,
			String description, int x, int y) {
		this.id = id;
		this.name = name;
		this.use = use;
		this.audioURL = audioURL;
		this.description = description;
		this.x = x;
		this.y = y;
	}
	
	public int getId() {
		return id;
	}
	
	public boolean getUse() {
		return use;
	}
	
	public void setUse(boolean use) {
		this.use = use;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAudioURL() {
		return audioURL;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	@Override
	public String toString() {
		return "\t\tExhibit \n[\n\t\tid=" + id + ",\n\t\tname=" + name + ",\n\t\tuse=" + use
				+ ",\n\t\taudioURL=" + audioURL + ",\n\t\tdescription=" + description
				+ ",\n\t\tx=" + x + ",\n\t\ty=" + y + "\n\t\t]";
	}
}
