package com.qa.OOP;

public class Hovercraft extends Vehicle {
    private int hp;
	
	public Hovercraft(int id, String name, int hp) {
		super(id, name);
		this.hp = hp;
	}
	
	public String getHp() {
		return "Horsepower: " + hp;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
}
