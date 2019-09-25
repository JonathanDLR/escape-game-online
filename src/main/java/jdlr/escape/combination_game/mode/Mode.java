package jdlr.escape.combination_game.mode;

import org.apache.log4j.Logger;

import jdlr.escape.combination_game.conf.ConfFactory;
import jdlr.escape.combination_game.gamer.AI;
import jdlr.escape.combination_game.gamer.User;
import jdlr.escape.combination_game.log.Logger4j;

public abstract class Mode {
	protected ConfFactory confFactory;
	protected int numberTry;
	protected String dev;
	protected static final Logger logger = Logger.getLogger(Logger4j.class);
	
	public Mode(ConfFactory pConfFactory) {
		this.confFactory = pConfFactory;
		this.numberTry = this.confFactory.getCombinationTry();
		this.dev = this.confFactory.getDevMode();
	}
	
	public abstract String inGame(AI pAi, User pUser);
}
