package jdlr.escape.combination_game.mode;

import org.apache.log4j.Level;

import jdlr.escape.combination_game.conf.ConfFactory;
import jdlr.escape.combination_game.gamer.AI;
import jdlr.escape.combination_game.gamer.User;

public class ChallengerMode extends Mode {
	public ChallengerMode(ConfFactory pConfFactory) {
		super(pConfFactory);
	}

	/**
	 * Resolving the proposition
	 */
	public String inGame(AI pAi, User pUser) {
		System.out.println("CHALLENGER MODE");
		System.out.println("----------------");
		System.out.println("You have "+numberTry+" try");
		System.out.println("");
		pAi.setSolution(pAi.generateNumber());
		if (Boolean.valueOf(dev)) {
			System.out.println(pAi.getSolution());
		}
		do {
			System.out.println("Faites votre proposition: ");
			pUser.setResponse(pUser.setNumber());
			if (pAi.getSolution().equals(pUser.getResponse())) {
				System.out.println("YOU WIN!");
			} else {
				String verdict = pAi.giveResponseDef(pUser.getResponse());
				numberTry = numberTry - 1;
				logger.setLevel(Level.INFO);
				logger.info("CHALLENGERMODE - user response: " + pUser.getResponse());
				
				System.out.println(verdict + " Nope! "+numberTry+" try remaining");
			}
			if (numberTry == 0) {
				System.out.println("You lose");
			}
		} while ((!pAi.getSolution().equals(pUser.getResponse())) && (numberTry != 0));
		
		return "END";
	}
}
