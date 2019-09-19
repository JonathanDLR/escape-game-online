package jdlr.escape.combination_game.mode;

import jdlr.escape.combination_game.AI;
import jdlr.escape.combination_game.User;

public class ChallengerMode implements Mode {
	
	/**
	 * Resolving the proposition
	 */
	public String inGame(AI pAi, User pUser) {
		System.out.println("CHALLENGER MODE");
		System.out.println("----------------");
		System.out.println("");
		pAi.setSolution(pAi.generateNumber());
		System.out.println(pAi.getSolution());
		do {
			System.out.println("Faites votre proposition: ");
			pUser.setResponse(pUser.setNumber());
			if (pAi.getSolution().equals(pUser.getResponse())) {
				System.out.println("YOU WIN!");
			} else {
				String verdict = pAi.giveResponseDef(pUser.getResponse());
				System.out.println(verdict + " Nope! New Try");
			}
		} while (!pAi.getSolution().equals(pUser.getResponse()));
		
		return "END";
	}
}
