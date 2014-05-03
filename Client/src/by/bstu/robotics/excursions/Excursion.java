/**
 * �������� ���������
 */

package by.bstu.robotics.excursions;

import java.util.ArrayList;

public final class Excursion {

	int id;
	String name;
	ArrayList<Exhibit> exhibits;

	public Excursion(int id, String name, ArrayList<Exhibit> exhibits) {
		this.id = id;
		this.name = name;
		this.exhibits = exhibits;
	}

	@Override
	public String toString() {
		return "Excursion \n\t[\n\tid=" + id + ",\n\tname=" + name + ",\n\texhibits="
				+ exhibits.toString() + "\n\t]";
	}

	public String getName() {
		return name;
	}

	public ArrayList<Exhibit> getExhibits() {
		return exhibits;
	}

	public Exhibit getExhibit(int id) {
		for (Exhibit exhibit : this.exhibits) {
			if (exhibit.getId() == id) {
				return exhibit;
			}
		}
		return null;
		
	}

}
