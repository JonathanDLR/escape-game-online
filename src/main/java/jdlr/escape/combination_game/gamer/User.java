package jdlr.escape.combination_game.gamer;

import java.util.Scanner;

import org.apache.log4j.Level;

import jdlr.escape.combination_game.conf.ConfFactory;

public class User extends Player{
	public User(ConfFactory pConfFactory) {
		super(pConfFactory);
		// TODO Auto-generated constructor stub
	}

	Scanner sc = new Scanner(System.in);
	
	/**
	 * Give response to the app
	 * @return The response: for each number set + if is higher, - if is lower, = if it's ok
	 */
	public String giveResponseDef(String pAiResponse) {	
		Boolean responseIsGood;
		Boolean responseIsGood2;
		String response;
		do {
			response = sc.next();
			responseIsGood = (response.matches("[\\+\\-\\=]{"+combinationNumber+"}"));
			if (!responseIsGood) {
				logger.setLevel(Level.DEBUG);
				logger.debug("DEFENDERMODE - wrong user response: " + response);
				System.out.println("Veuillez rentrer une réponse valide ("+combinationNumber+" caractères, uniquement +, - ou =):");
			}
			
			// Check if user doesn't invite ia to propose > 10 or < 0 number
			String[] partsAiResponse = pAiResponse.split("");
			String[] partsResponse = response.split("");		
			for (int i = 0; i < partsResponse.length; i++) {
				if (partsAiResponse[i].equals("0") && partsResponse[i].equals("-")) {
					responseIsGood = false;
					logger.debug("DEFENDERMODE - wrong user response: " + response);
					System.out.println("Un nombre ne peut être inférieur à 0. Entrez une réponse valide:");
				} else if (partsAiResponse[i].equals("9") && partsResponse[i].equals("+")) {
					responseIsGood = false;
					logger.debug("DEFENDERMODE - wrong user response: " + response);
					System.out.println("Un nombre ne peut être supérieur à 10. Entrez une réponse valide:");
				} 
			}
		} while(!responseIsGood);
		
		return response;
	}
	
	/**
	 * Create a number for response or solution
	 * @return The number with x digits
	 */
	public String setNumber() {
		Boolean responseIsGood;
		String number;
		do {
			number = sc.next();
			responseIsGood = (number.matches("\\d{"+combinationNumber+"}"));
			if (!responseIsGood) {
				logger.setLevel(Level.DEBUG);
				logger.debug("wrong user combination: " + number);
				System.out.println("Veuillez rentrer un nombre valide composé de "+combinationNumber+" chiffres:");
			}
		} while(!responseIsGood);
		return number;
	}
}
