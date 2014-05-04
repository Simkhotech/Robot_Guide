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
	String imgURL;
	boolean use;
	String audioURL;
	String description;
	int x;
	int y;
	int phi;
	
	public Exhibit(int id, String imgURL, boolean use, String audioURL,
			String description, int x, int y, int phi) {
		this.id = id;
		this.imgURL = imgURL;
		this.use = use;
		this.audioURL = audioURL;
		this.description = description;
		this.x = x;
		this.y = y;
		this.phi = phi;
	}
	
	public int getPhi() {
		return phi;
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
	
	public String getImgURL() {
		return imgURL;
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
		return "\t\tExhibit \n[\n\t\tid=" + id + ",\n\t\tname=" + imgURL + ",\n\t\tuse=" + use
				+ ",\n\t\taudioURL=" + audioURL + ",\n\t\tdescription=" + description
				+ ",\n\t\tx=" + x + ",\n\t\ty=" + y + "\n\t\t]";
	}
}
