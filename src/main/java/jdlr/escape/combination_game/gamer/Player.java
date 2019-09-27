package jdlr.escape.combination_game.gamer;

import org.apache.log4j.Logger;

import jdlr.escape.combination_game.conf.ConfFactory;

public class Player {
	private String solution;
	private String response;
	protected ConfFactory confFactory;
	protected int combinationNumber;
	protected static Logger logger = Logger.getLogger(Player.class);
	
	public Player(ConfFactory pConfFactory) {
		this.confFactory = pConfFactory;
		this.combinationNumber = this.confFactory.getCombinationNumber();
	}
	
	// GETTERS
	public String getSolution() {
		return this.solution;
	}
	
	public String getResponse() {
		return this.response;
	}
	
	// SETTERS
	public void setSolution(String pSolution) {
		this.solution = pSolution;
	}
	
	public void setResponse(String pResponse) {
		this.response = pResponse;
	}
}
