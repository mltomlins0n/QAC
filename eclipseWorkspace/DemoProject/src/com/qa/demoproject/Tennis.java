package com.qa.demoproject;

public class Tennis extends Game {
	
	public Tennis(int score, int timeInMins, String name) {
		super(score, timeInMins, name);
	}
	
	@Override
	public int getScore() {
		return super.getScore() * 15;
	}
}
