package com.sapient.match.model;

public class MatchResult {

	private String team1;
	private String team2;
	private String score;
	private String roundRotation;

	public MatchResult() {
		super();
	}

	public MatchResult(String team1, String team2, String score, String roundRotation) {
		super();
		this.team1 = team1;
		this.team2 = team2;
		this.score = score;
		this.roundRotation = roundRotation;
	}

	public String getTeam1() {
		return team1;
	}

	public void setTeam1(String team1) {
		this.team1 = team1;
	}

	public String getTeam2() {
		return team2;
	}

	public void setTeam2(String team2) {
		this.team2 = team2;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getRoundRotation() {
		return roundRotation;
	}

	public void setRoundRotation(String roundRotation) {
		this.roundRotation = roundRotation;
	}

}
