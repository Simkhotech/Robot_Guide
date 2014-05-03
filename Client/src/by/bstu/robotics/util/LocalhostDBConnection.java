package by.bstu.robotics.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import by.bstu.robotics.excursions.Excursion;
import by.bstu.robotics.excursions.Exhibit;

import com.mysql.jdbc.ResultSetMetaData;

public class LocalhostDBConnection {

	final String driverName = "com.mysql.jdbc.Driver";
	final String serverName = "";
	final String url = "jdbc:mysql://localhost:3306/db_robot_guide";
	final String username = "Robot";
	final String password = "robotpassword";

	Connection connection;
	String query;
	String[][] columns;
	ResultSet rs;
	ResultSetMetaData rsmd;

	ArrayList<Excursion> excursions;

	public ArrayList<Excursion> getExcursions() {
		return excursions;
	}

	public LocalhostDBConnection() {
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, username, password);

			this.excursions = new ArrayList<Excursion>();
			this.excursions = getExcursion();

//			System.out.println(excursions.toString());
			// ArrayList<Exhibit> exhibits = getExhibits();

//			System.out.println(getExcursionCount());
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private ArrayList<Excursion> getExcursion() {
		// TODO Auto-generated method stub
		try {
				query = "select * from excursion_tbl";
	
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
	
				ArrayList<Integer> excursion_id = new ArrayList<Integer>();
				ArrayList<String> excursion_name = new ArrayList<String>();
				
				int i = 0;
				while (rs.next()) {
					excursion_id.add( rs.getInt(1) );
					excursion_name.add( rs.getString(2) );
					
//					System.out.println("excursion_id: " + excursion_id.get(i) + "\t excursion_name: " + excursion_name.get(i++));
					
				}
				
				for (i = 0; i < excursion_id.size(); i++) {
					
					query = "select exhibit_id from excursion_exhibit_tbl where excursion_id = " + excursion_id.get(i);
					rs = stmt.executeQuery(query);
					rsmd = (ResultSetMetaData) rs.getMetaData();
		
					ArrayList<Integer> exhibit_id = new ArrayList<Integer>();
					ArrayList<Exhibit> exhibits = new ArrayList<Exhibit>();
					
					while (rs.next()) {
						exhibit_id.add(rs.getInt(1));
					}
//					System.out.println(exhibit_id.toString());
					

					for (int j = 0; j < exhibit_id.size(); j++) {
						query = "select * from exhibit_tbl where exhibit_id = " + exhibit_id.get(j);
						rs = stmt.executeQuery(query);
						rsmd = (ResultSetMetaData) rs.getMetaData();
						
					
						while (rs.next()) {
							exhibits.add(new Exhibit(rs.getInt(1), rs.getString(2), rs.getBoolean(3),
									rs.getString(5), rs.getString(4), rs.getInt(6), rs.getInt(7)));
						}
						
					}
					this.excursions.add(new Excursion(excursion_id.get(i), excursion_name.get(i), exhibits));
				}

				System.out.println(excursions.toString());

				return excursions;
			// Excursion excursion = new Excursion(getExhibits(), id)
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

/*	private Exhibit[] getExhibitsByExcursionId(String id) {
		// TODO Auto-generated method stub
		try {
			ArrayList<Excursion> excursions = new ArrayList<Excursion>();
			
			Connection connection = DriverManager.getConnection(url, username, password);
			
			String query = "Select exhibit_id from Excursion_Exhibit_tbl where excursion_id = " + id;
			Statement stmt = connection.createStatement();

			ResultSet rs = stmt.executeQuery(this.query);
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();

			while (rs.next()) {

				String ExhibitsId = rs.getString(1);
				System.out.println("ExhibitsId: " + ExhibitsId);
				
//				Excursion excursion = new Excursion(Integer.parseInt(rs.getString(1)), 
//						rs.getString(2), getExhibits());
			}

			return null;
			// Excursion excursion = new Excursion(getExhibits(), id)
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * TODO!!!
	 * 
	 * @param excursion
	 * @return
	 */ /*
	private ArrayList<Exhibit> getExhibitForExcursion(Excursion excursion) {
		ArrayList<String> rows = new ArrayList<String>();
		ArrayList<String> columns = new ArrayList<String>();

		query = "Select * FROM Exhibit_tbl";
		Statement stmt = this.connection.createStatement();

		ResultSet rs = stmt.executeQuery(query);
		ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();

		for (int i = 0; i < rsmd.getColumnCount(); i++) {
			columns.add(i, rsmd.getColumnName(i + 1));
		}

		query = "Select * from Exhibit_tbl;";

		rs = stmt.executeQuery(this.query);
		ArrayList<Exhibit> exhibits = new ArrayList<Exhibit>();

		int j = 0;
		while (rs.next()) {
			Exhibit exhibit = new Exhibit(Integer.parseInt(rs.getString(columns.get(0))), 
											rs.getString(columns.get(1)), 
											Boolean.parseBoolean(rs.getString(columns.get(2))), 
											rs.getString(columns.get(3)),
											rs.getString(columns.get(4)),
											Integer.parseInt(rs.getString(columns.get(5))),
											Integer.parseInt(rs.getString(columns.get(6))));

			System.out.println(exhibit.toString());
			
			exhibits.add(exhibit);

		}

		return exhibits;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
	}
	private ArrayList<Exhibit> getExhibits() {
		// TODO Auto-generated method stub
		// определить количество строк
		try {

			ArrayList<String> rows = new ArrayList<String>();
			ArrayList<String> columns = new ArrayList<String>();

			query = "Select * FROM Exhibit_tbl";
			Statement stmt = this.connection.createStatement();

			ResultSet rs = stmt.executeQuery(query);
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();

			for (int i = 0; i < rsmd.getColumnCount(); i++) {
				columns.add(i, rsmd.getColumnName(i + 1));
			}

			query = "Select * from Exhibit_tbl;";

			rs = stmt.executeQuery(this.query);
			ArrayList<Exhibit> exhibits = new ArrayList<Exhibit>();

			int j = 0;
			while (rs.next()) {
				Exhibit exhibit = new Exhibit(Integer.parseInt(rs.getString(columns.get(0))), 
												rs.getString(columns.get(1)), 
												Boolean.parseBoolean(rs.getString(columns.get(2))), 
												rs.getString(columns.get(3)),
												rs.getString(columns.get(4)),
												Integer.parseInt(rs.getString(columns.get(5))),
												Integer.parseInt(rs.getString(columns.get(6))));

				System.out.println(exhibit.toString());
				
				exhibits.add(exhibit);

			}

			return exhibits;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}*/

	public int getExcursionCount() {
		// TODO Auto-generated method stub
		return excursions.size();
	}
}