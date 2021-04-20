package com.qa.TheInfiniteTesselatingSwamp;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Constants c = new Constants();
		GameBoard board = new GameBoard();
		Player player = new Player();
		String intro = "";
		Scanner sc = new Scanner(System.in);
		String playerChoice = "";
		
		intro += "You awake to find yourself in a swamp. \n";
		intro += "The area is offensively grey in all directions, you suspect it is infinite. \n" ;
		intro += "In the distance you hear a vague yell in a thick scottish accent. \n";
		intro += "Reaching into your pocket, you pull out a worn compass with barely legible letters at the edges. \n";
		intro += "'N', 'E', 'S', 'W' are your only options, it seems. \n";
		intro += "'Might aswell look for some loot.' you think to yourself. 'Nothing else to do.' \n";
		
		// set initial player and treasure locations
		board.setupGame();
		/*
		// DEBUG
		System.out.println("Player X: " + board.getPlayerPosX());
		System.out.println("Player Y: " + board.getPlayerPosY());
		
		System.out.println("Treasure X: " + board.getTreasurePosX());
		System.out.println("Treasure Y: " + board.getTreasurePosY()); */
		
		System.out.println(intro);
		
		while (! (playerChoice.equals(c.QUIT)) ) {
			System.out.println("Enter a direction... (N, E, S, or W)");
			System.out.println("Or type 'quit' to exit.");
			playerChoice = sc.next().toUpperCase();
			
			if (playerChoice.equals(c.NORTH)) {
				System.out.println("You squelch to the North");
				player.goNorth(board.getPlayerPosY());
				// DEBUG
				System.out.println("X position: " + board.getPlayerPosX());
				System.out.println("Y position: " + board.getPlayerPosY());
			}
			else if (playerChoice.equals(c.SOUTH)) {
				System.out.println("You squelch to the South");
				player.goSouth(player.getPlayerPosY());
			}
			else if (playerChoice.equals(c.EAST)) {
				System.out.println("You squelch to the East");
				player.goEast(player.getPlayerPosX());
			}
			else if (playerChoice.equals(c.WEST)) {
				System.out.println("You squelch to the West");
				player.goWest(player.getPlayerPosX());
			}
			else if (playerChoice.equals(c.QUIT)){
				System.out.println("Exiting...");
				System.out.println("Game Over");
			}
			else {
				System.out.println("\'" + playerChoice + "\'" + " is not valid, try again");
			}
		}
		sc.close();
	}
}
