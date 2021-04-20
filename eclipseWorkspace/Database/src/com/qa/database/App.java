package com.qa.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DBManager db = new DBManager();
        Scanner scanner = new Scanner(System.in);
        
        int choice = 0;
        
        ArrayList<String> options = new ArrayList<String>();
        
        options.add("1. Access a database.");
        options.add("2. Read from a table.");
        options.add("3. Create a record.");
        options.add("4. Update a record.");
        options.add("5. Delete a record.");
        options.add("6. Exit");
        
		while (choice != 6) {
			System.out.println("Choose an option:");
			for (String opt : options) {
				System.out.println(opt);
			}
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				db.accessDB();
				break;
			case 2:
				db.readDB();
				break;
			case 3:
				db.createRecord();
				break;
			case 4:
				db.updateDB();
				break;
			case 5:
				db.deleteFromDB();
				break;
			case 6:
				System.out.println("Exiting...");
				db.closeConnections();
				break;
			default:
				System.out.println("Invalid option, try again.");
				break;
				}
			}
		scanner.close();
		}
	};
