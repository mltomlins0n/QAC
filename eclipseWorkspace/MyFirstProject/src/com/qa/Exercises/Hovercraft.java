package com.qa.Exercises;

public class Hovercraft extends Vehicle {
    private int hp;
    private int seats;
	
	public Hovercraft(int id, String name, 
			            int hp, int seats) {
		super(id, name);
		this.hp = hp;
		this.seats = seats;
	}
	
	public int getHp() {
		return hp;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public int getSeats() {
		return seats;
	}
	
	public void setSeats(int seats) {
		this.seats = seats;
	}
}