package jdlr.escape.combination_game.mode;

import jdlr.escape.combination_game.conf.ConfFactory;
import jdlr.escape.combination_game.gamer.AI;
import jdlr.escape.combination_game.gamer.User;

public class DefenderMode extends Mode {
	
	public DefenderMode(ConfFactory pConfFactory) {
		super(pConfFactory);
	}

	/**
	 * Resolving the proposition
	 * @param pAi
	 * @param pUser
	 */
	public String inGame(AI pAi, User pUser) {
		System.out.println("DEFENDER MODE");
		System.out.println("----------------");
		System.out.println("");
		System.out.println("Rentrez votre combinaison: ");
		pUser.setSolution(pUser.setNumber());
		pAi.setResponse(pAi.generateNumber());
		System.out.println(pAi.getResponse());
		do {
			System.out.println("Votre réponse: ");
			String response = pUser.giveResponseDef();
			
			pAi.setResponse(pAi.giveResponseAtak(response, pUser.getSolution()));
			
			System.out.println(pAi.getResponse());
			
			if (pAi.getResponse().equals(pUser.getSolution())) {
				System.out.println("You Lose!");
			}
		} while(!pAi.getResponse().equals(pUser.getSolution()));
		
		return "END";
	}
}
