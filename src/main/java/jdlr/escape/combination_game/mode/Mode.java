package jdlr.escape.combination_game.mode;

import jdlr.escape.combination_game.conf.ConfFactory;
import jdlr.escape.combination_game.gamer.AI;
import jdlr.escape.combination_game.gamer.User;

public abstract class Mode {
	protected ConfFactory confFactory;
	protected int numberTry;
	protected String dev;
	
	public Mode(ConfFactory pConfFactory) {
		this.confFactory = pConfFactory;
		this.numberTry = this.confFactory.getCombinationTry();
		this.dev = this.confFactory.getDevMode();
	}
	
	public abstract String inGame(AI pAi, User pUser);
}
