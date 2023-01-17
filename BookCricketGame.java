package com.monocept.test;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import com.monocept.model.Player;

public class BookCricketGame {

	public static void main(String[] args) {
		System.out.println("Welcome to BookCricketGame !!");
		System.out.println("Rules for the Game :");
		System.out.println("***Assume a  book of 300 Pages***");
		System.out.println("1.Assume a book of 300 pages "
				+ "\n2.Player 1 opens the book to read a page number (Randomly generated)"
				+ "\n3.Total score of a player = page number % 7 (number % 7 will always be between 0 - 6)");
		System.out
				.println("4.Player 1 continues and keeps adding to the score untill page number results in a 0 score");
		System.out.println("5.Player 2 starts the game and tries to beat the score of player 1");
		System.out.println("6.In case of a tie, check the number of turns(player with lesser turns is winner)");
		System.out.println("7.Show the winner of the game.");
		System.out.println("Enter 1 to start Game and 0 for Exit :");
		Scanner sc = new Scanner(System.in);
		int ch = sc.nextInt();
		switch (ch) {
		case 1:
			System.out.println("Enter player 1 Name : ");
			sc.nextLine();
			String player = sc.nextLine();
			Player playerOne = new Player(player);
			System.out.println("Enter player 2 Name : ");
			String player2 = sc.nextLine();
			Player playerTwo = new Player(player2);
			playGame(playerOne);
			System.out.println("\n\n" + playerOne.getPlayerName() + " Needs To Score " + playerOne.getPlayerScore()
					+ " Or more in " + playerOne.getPlayerTurns() + " Rounds");
			playGame(playerTwo);
			System.out.println("\n.........................................");
			if (playerOne.getPlayerScore() > playerTwo.getPlayerScore()) {
				printWinner(playerOne);
			} else if (playerOne.getPlayerScore() == playerTwo.getPlayerScore()) {
				if (playerOne.getPlayerTurns() > playerTwo.getPlayerTurns())
					printWinner(playerOne);
				else
					printWinner(playerOne);
			} else {
				printWinner(playerOne);
			}

		case 0:
			System.out.println("exit...");
			System.exit(0);

		}
	}

	public static void printWinner(Player player) {
		System.out.println(player.getPlayerName() + " Win Match!!!!");

	}

	public static void playGame(Player player) {
		System.out.println(player.getPlayerName() + " is Playing : ");
		int point = 0;
		do {
			System.out.println("Enter 1 To Open Book : ");
			point = ThreadLocalRandom.current().nextInt(300);
			player.incrementTurnsByOne();
			player.setPlayerScore(point % 7);
			printCurrentScore(point, player);
		} while (point != 0);
		System.out.println("OOPS!!! " + player.getPlayerName() + " your turns ended.....");
		System.out.println(player.getPlayerName() + " Total Score : " + player.getPlayerScore());
		System.out.println(player.getPlayerName() + " Takes " + player.getPlayerTurns() + " Rounds");

	}

	public static void printCurrentScore(int point, Player player) {
		System.out.println(
				"page Number : " + point + "     Point : " + point % 7 + "     Score : " + player.getPlayerScore());

	}

}
