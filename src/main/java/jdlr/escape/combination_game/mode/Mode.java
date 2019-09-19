package jdlr.escape.combination_game.mode;

import jdlr.escape.combination_game.conf.ConfFactory;
import jdlr.escape.combination_game.gamer.AI;
import jdlr.escape.combination_game.gamer.User;

public abstract class Mode {
	protected ConfFactory confFactory;
	
	public Mode(ConfFactory pConfFactory) {
		this.confFactory = pConfFactory;
	}
	
	public abstract String inGame(AI pAi, User pUser);
}
