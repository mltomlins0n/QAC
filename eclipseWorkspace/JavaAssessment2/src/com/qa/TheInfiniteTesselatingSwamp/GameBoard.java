package com.qa.TheInfiniteTesselatingSwamp;

public class GameBoard extends Game {
	private double playerPosX;
	private double playerPosY;
	private double treasurePosX;
	private double treasurePosY;
	private int boardSizeX;
	private int boardSizeY;
	private float distanceToTreasure;
	private int boardSize;
	
	public GameBoard() {
		
	}
	
	public GameBoard(int boardSizeX, int boardSizeY) {
		this.boardSizeX = boardSizeX;
		this.boardSizeY = boardSizeY;
	}
	
	public void setupGame() {
		setPlayerPosX(Math.round(1));
		setPlayerPosY(Math.round(1));
		
		setTreasurePosX(Math.round(1));
		setTreasurePosY(Math.round(1));
	}
	
	public void printDistanceToTreasure(float treasureDist) {
		// a2 + b2 = c2
		// c.sqrt() = distance to treasure
		//Math.sqrt(treasureDist);
	}
	
	public int getBoardSize() {
		return boardSize;
	}
	
	public double getPlayerPosX() {
		return playerPosX;
	}
	
	public double getPlayerPosY() {
		return playerPosY;
	}
	
	public double getTreasurePosX() {
		return treasurePosX;
	}
	
	public double getTreasurePosY() {
		return treasurePosY;
	}
	
	public void setPlayerPosX(double playerPosX) {
		playerPosX = Math.random() * 10;
		playerPosX = Math.round(playerPosX);
		this.playerPosX = playerPosX;
	}
	
	public void setPlayerPosY(double playerPosY) {
		playerPosY = Math.random() * 10;
		playerPosY = Math.round(playerPosY);
		this.playerPosY = playerPosY;
	}
	
	public void setTreasurePosX(double treasurePosX) {
		treasurePosX = Math.random() * 10;
		treasurePosX = Math.round(treasurePosX);
		this.treasurePosX = treasurePosX;
	}
	
	public void setTreasurePosY(double treasurePosY) {
		treasurePosY = Math.random() * 10;
		treasurePosY = Math.round(treasurePosY);
		this.treasurePosY = treasurePosY;
	}
	
	public float getDistanceToTreasure() {
		return distanceToTreasure;
	}
	
	public void setBoardSize(int boardSize) {
		this.boardSize = boardSize;
	}
	
	public void setDistanceToTreasure(float distanceToTreasure) {
		this.distanceToTreasure = distanceToTreasure;
	}
}
