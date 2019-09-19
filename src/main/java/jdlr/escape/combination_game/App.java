package jdlr.escape.combination_game;

import jdlr.escape.combination_game.conf.ConfFactory;
import jdlr.escape.combination_game.gamer.AI;
import jdlr.escape.combination_game.gamer.User;

/**
 * Application launcher
 * @author jdlr
 *
 */
public class App {
	public static void main(String[] args) {
		ConfFactory confFactory = new ConfFactory();
		AI ai = new AI(confFactory);
		User user = new User(confFactory);
		Game game = new Game(confFactory, ai, user);
		game.start();
	}
}
