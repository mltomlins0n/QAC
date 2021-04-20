package com.qa.TheInfiniteTesselatingSwamp;

public abstract class Game {
	public int playerPosX;
	public int playerPosY;
	public float distanceToTreasure;
	
	public abstract void printDistanceToTreasure(float treasureDist);
}
