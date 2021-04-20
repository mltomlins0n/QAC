package com.qa.Exercises;

import java.util.ArrayList;

public class Garage {
	public static ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	public static void main(String[] args) {
		Garage garage = new Garage();
		
		Car car1 = new Car(1, "Alfa brera", 4, 3, "RWD");
		Motorbike bike1 = new Motorbike(2, "KTM", 250, "4 Stroke");
		Hovercraft hover1 = new Hovercraft(3, "Hovercraft", 300, 4);
		
		garage.addVehicle(car1);
		garage.addVehicle(bike1);
		garage.addVehicle(hover1);
		
		for (Vehicle v : vehicles) {
			System.out.println(v.toString());
			System.out.println(garage.calculateBill(v));
		}
		
	}
	
	public void addVehicle(Vehicle v) {
		vehicles.add(v);
	}
	
	public void addVehicleById(int id) {
		
	}
	
	public void emptyGarage() {
		vehicles.clear();
	}
	
	public int calculateBill(Vehicle v) {
		int bill = 0;
		
		if (v instanceof Car) {
			if (((Car) v).getDriveTrain() == "FWD") {
				bill = 200;
			}
			else if (((Car) v).getDriveTrain() == "AWD") {
				bill = 400;
			}
			else if (((Car) v).getDriveTrain() == "RWD") {
				bill = 300;
			}
		}
		else if (v instanceof Motorbike) {
			if (((Motorbike) v).getDisplacement() > 125){
				bill = 150;
			}
			else {
				bill = 100;
			}
		}
		else if (v instanceof Hovercraft) {
			if (((Hovercraft) v).getHp() > 400){
				bill = 1000;
			}
			else {
				bill = 750;
			}
		}
		return bill;
	}
}
