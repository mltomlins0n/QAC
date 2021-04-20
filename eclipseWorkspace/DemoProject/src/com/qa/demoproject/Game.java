package com.qa.demoproject;

public class Game extends Sports_Game {
	
	private String name;
	private int score;
	private int timeInMins;
	
	public Game() {
		
	}
	
	public Game(int score, String name) {
		this.score = score;
		this.name = name;
	}
	
	public Game(int score, int timeInMins, String name) {
		this.score = score;
		this.timeInMins = timeInMins;
		this.name = name;
	}
	
	public void addToScore(int score) {
		this.score += score;
	}
	
	public void additionalTime(int time) {
		this.timeInMins += time;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public int getTimeInMins() {
		return timeInMins;
	}
	
	public void setName(String name) {
	
		this.name = name;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public void setTimeInMins(int timeInMins) {
		this.timeInMins = timeInMins;
	}
}
