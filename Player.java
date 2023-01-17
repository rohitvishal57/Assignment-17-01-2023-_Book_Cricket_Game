package com.monocept.model;

public class Player {
	private String playerName;
	private int playerScore;
	private int turns;

	public Player(String playerName) {
		this.playerName = playerName;
		this.playerScore = 0;
		this.turns = 0;
	}

	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerScore(int playerScore) {
		this.playerScore += playerScore;
	}

	public int getPlayerScore() {
		return playerScore;
	}

	public void incrementTurnsByOne() {
		this.turns++;

	}

	public int getPlayerTurns() {
		return turns;
	}

}
