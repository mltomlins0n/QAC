package com.qa.database;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBManager {

	Constants c = new Constants();
	
	Connection conn = null;
	Statement stmt = null;
	
	Scanner scanner = new Scanner(System.in);
	
	public void accessDB() throws ClassNotFoundException, SQLException {	
		System.out.println("Enter the name of the database to access...");
		String dbToUse = scanner.nextLine();
		
		Class.forName(c.JDBC_DRIVER);
		    System.out.println("Connecting to database...");
		    conn = DriverManager.getConnection(c.DB_URL, c.USER, c.PASS);
		    stmt = conn.createStatement();
	        stmt.executeUpdate("USE " + dbToUse);
	}
	
	public void createRecord() {
		System.out.println("Enter team name to add to database...");
		String teamName = scanner.nextLine();
		
		try {
			System.out.println("Inserting records into table...");
			stmt = conn.createStatement();
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		String sql =  "INSERT INTO F1 (Team_Name) " +
		              "VALUES ('"+ teamName +"')";
		
		try {
			stmt.executeUpdate(sql);
			System.out.println("Records inserted into the table.");
		}
		catch (SQLException sqle) {
			System.out.println("Cannot create a team with the same name"
					           + "as an existing team");
		}
		
	}
	// excuteQuery("DESCRIBE " + table;
	// Read each field, read each type
	// Add them to their own arrays
	// Check the type of each field (int, String)
	// Then either scanner.getInt or getLine
	public void readDB() {
        System.out.println("Enter the table to read from...");
		String table = scanner.nextLine();
		
		String readSql = "SELECT * FROM " + table;
		// "DESCRIBE "+ table;
		
		try {
			ResultSet rs = stmt.executeQuery(readSql);
			
			if (table.equals("Constructors")) {
				while(rs.next()) {
		            int id  = rs.getInt("id");
		            String team = rs.getString("Team_Name");

		            //Display values
		            System.out.print("ID: " + id + " Team: " + team + "\n");
		            }
				}
			else if (table.equals("Drivers")) {
				while(rs.next()) {
		            int id  = rs.getInt("id");
		            String driver = rs.getString("Driver_Name");
		            int points = rs.getInt("points");

		            //Display values
		            System.out.print("ID: " + id + " Name: " + driver + 
		            		         " Points: " + points + "\n");
		            }
				}
			rs.close();
			}
		catch (SQLException sqle) {
			sqle.printStackTrace();
			}
		};

    public void updateDB() {
		System.out.println("Enter the team name to update...");
		String teamToUpdate = scanner.nextLine();
		System.out.println("Enter new team name...");
		String newTeamName = scanner.nextLine();
		
		System.out.println("Creating statement...");
		try {
			stmt = conn.createStatement();
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		String updateSql = "UPDATE F1 " +
		                     "SET Team_Name = '"+ newTeamName +"' " +
				               "WHERE Team_Name = '"+ teamToUpdate +"'";
		try {
			stmt.executeUpdate(updateSql);
			System.out.println("Database updated.");
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	
	public void deleteFromDB() {
		System.out.println("Enter team to delete...");
		String teamToDelete = scanner.nextLine();
	
		try {
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		String deleteSql = "DELETE FROM F1 " +
		                     "WHERE Team_Name = '"+ teamToDelete +"'";
		
		try {
			stmt.executeUpdate(deleteSql);
			System.out.println("Records deleted.");
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	
	public void closeConnections() throws SQLException {
		try {
			if (stmt != null) {
				stmt.close();
			}
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
			}
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}
