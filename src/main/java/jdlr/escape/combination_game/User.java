package jdlr.escape.combination_game;

import java.util.Scanner;

public class User extends Player{
	Scanner sc = new Scanner(System.in);
	
	/**
	 * Generate a number
	 * @return
	 */
	public String generateNumber() {
		String number = "";
		
		return number;
	}
	
	/**
	 * Give response to the app
	 * @return The response: for each number set + if is higher, - if is lower, = if it's ok
	 */
	public String giveResponseDef() {	
		Boolean responseIsGood;
		String response;
		do {
			response = sc.next();
			responseIsGood = (response.matches("[\\+\\-\\=]{4}"));
			if (!responseIsGood) {
				System.out.println("Veuillez rentrer une réponse valide (4 caractères, uniquement +, - ou =):");
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
			responseIsGood = (number.matches("\\d{4}"));
			if (!responseIsGood) {
				System.out.println("Veuillez rentrer un nombre valide composé de 4 chiffres:");
			}
		} while(!responseIsGood);
		return number;
	}
}
