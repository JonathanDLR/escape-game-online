package jdlr.escape.combination_game.mode;

import jdlr.escape.combination_game.AI;
import jdlr.escape.combination_game.User;

/**
 * Resoluving the game
 * @author jdlr
 *
 */
public class DuelMode implements Mode {
	public String inGame(AI pAi, User pUser) {
		System.out.println("DUEL MODE");
		System.out.println("----------------");
		System.out.println("");
		
		String userResponse = "";
		pAi.setSolution(pAi.generateNumber());
		System.out.println(pAi.getSolution());
		
		System.out.println("Rentrez votre combinaison: ");
		pUser.setSolution(pUser.setNumber());
		
		System.out.println("AI TURN");
		pAi.setResponse(pAi.generateNumber());
		System.out.println(pAi.getResponse());
		
		do {
			if (pAi.getResponse().equals(pUser.getSolution())) {
				System.out.println("You Lose!");
			} else {
				System.out.println("Votre réponse: ");
				userResponse = pUser.giveResponseDef();
				
				System.out.println("YOUR TURN");
				System.out.println(pAi.getSolution());
				
				
				System.out.println("Faites votre proposition: ");
				pUser.setResponse(pUser.setNumber());
				if (pAi.getSolution().equals(pUser.getResponse())) {
					System.out.println("YOU WIN!");
				} else {
					String verdict = pAi.giveResponseDef(pUser.getResponse());
					System.out.println(verdict);
					System.out.println("AI TURN");
					pAi.setResponse(pAi.giveResponseAtak(userResponse, pUser.getSolution()));
					System.out.println(pAi.getResponse());
					if (pAi.getResponse().equals(pUser.getSolution())) {
						System.out.println("You Lose!");
					}
				}
			}
				
		} while ((!pAi.getResponse().equals(pUser.getSolution())) && (!pAi.getSolution().equals(pUser.getResponse())));
		
		return "END";
	}
}
