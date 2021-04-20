package com.qa.TheInfiniteTesselatingSwamp;

public class Player extends GameBoard {
	
	GameBoard board = new GameBoard();
	
	public Player() {
		
	}
	
	public void goNorth(double playerPosY) {
		playerPosY = super.getPlayerPosY() + 1;
	}
	
	public void goSouth(double playerPosY) {
		playerPosY = super.getPlayerPosY() - 1;
	}
	
	public void goEast(double playerPosX) {
		playerPosX = super.getPlayerPosX() + 1;
	}
	
	public void goWest(double playerPosX) {
		playerPosX = super.getPlayerPosX() - 1;
	}
	
	public double getPlayerPosX() {
		return super.getPlayerPosX();
	}
	
	public double getPlayerPosY() {
		return super.getPlayerPosY();
	}
}
