package com.qa.demoproject;

public abstract class Sports_Game {
	public int score;
	public int timeInMins;
	
	public abstract void addToScore(int score);
	public abstract void additionalTime(int mins);
}