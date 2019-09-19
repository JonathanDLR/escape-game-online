package jdlr.escape.combination_game;

/**
 * Application launcher
 * @author jdlr
 *
 */
public class App {
	public static void main(String[] args) {
		AI ai = new AI();
		User user = new User();
		Game game = new Game(ai, user);
		game.start();
	}
}
