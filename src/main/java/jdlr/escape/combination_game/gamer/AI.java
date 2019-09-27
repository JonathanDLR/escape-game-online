package jdlr.escape.combination_game.gamer;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;

import jdlr.escape.combination_game.conf.ConfFactory;

public class AI extends Player {
	// Array of array of response given by AI
	public	ArrayList<ArrayList<Integer>> responsesGiven = new ArrayList<ArrayList<Integer>>();
	private String dev;
	
	public AI(ConfFactory pConfFactory) {
		super(pConfFactory);
		this.dev = confFactory.getDevMode();
		for (int i = 0; i < combinationNumber; i++) {
			ArrayList<Integer> responseGiven = new ArrayList<Integer>();
			responseGiven.add(-1);
			responseGiven.add(10);
			this.responsesGiven.add(responseGiven);
		}
	}
			
	/**
	 * Give response to the user
	 * @return The response: for each number set + if is higher, - if is lower, = if it's ok
	 */
	public String giveResponseDef(String pUserResponse) {
		String userResponse = pUserResponse;
		String[] partsTheSolution = this.getSolution().split("");
		String[] partsUserResponse = userResponse.split("");
		String response = "";
		
		for (int i = 0; i < partsTheSolution.length; i++) {
			if (Integer.parseInt(partsTheSolution[i]) > Integer.parseInt(partsUserResponse[i])) {
				response = response.concat("+");
			} else if (Integer.parseInt(partsTheSolution[i]) < Integer.parseInt(partsUserResponse[i])) {
				response = response.concat("-");
			} else {
				response = response.concat("=");
			}
		}

		return response;
	}
	
	/**
	 * Propose a solution to the number set by user
	 * ResponseGiven array contain the limits for each digit
	 * Array are update with each Ai proposition
	 * @return The response
	 */
	public String giveResponseAtak(String userResponse, String solution) {
		Random rand = new Random();
		String[] partsUserResponse = userResponse.split("");
		String[] partsAiResponse = this.getResponse().split("");
		String[] partsSolution = solution.split("");
		
		
		String response = "";
		int number = 0;
		
		for (int i = 0; i < partsUserResponse.length; i++) {
			if (Boolean.valueOf(dev)) {
				System.out.println(Integer.toString(i) + this.responsesGiven.get(i));
			}
			
			// Higher number given by AI
			Integer maxGiven = this.responsesGiven.get(i).stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new);
			
			// Lower number given by AI
			Integer minGiven = this.responsesGiven.get(i).stream().mapToInt(v -> v).min().orElseThrow(NoSuchElementException::new);
			
			// UPDATE ARRAY OF THE DIGIT
			if (!partsUserResponse[i].equals("=")) {
				if (!this.responsesGiven.get(i).contains(Integer.parseInt(partsAiResponse[i]))) {
					this.responsesGiven.get(i).add(Integer.parseInt(partsAiResponse[i]));
				}	
				
				if ((Integer.parseInt(partsAiResponse[i]) != -1) &&	(Integer.parseInt(partsAiResponse[i]) != 10)) {
					if (partsUserResponse[i].equals("+")) {
						this.responsesGiven.get(i).remove(minGiven);
						minGiven = this.responsesGiven.get(i).stream().mapToInt(v -> v).min().orElseThrow(NoSuchElementException::new); 							
							
					} else if (partsUserResponse[i].equals("-")) {
						this.responsesGiven.get(i).remove(maxGiven);
						maxGiven = this.responsesGiven.get(i).stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new);
					}
				}
				
				// GENERATE RANDOM DIGIT WITH ARRAY INFO. CONCAT EACH DIGIT IN NUMBER RESPONSE
				number = (minGiven + 1)  + rand.nextInt(maxGiven - minGiven);
				System.out.println(number);
				if (this.responsesGiven.get(i).contains(number)) {
					System.out.println("Error detected in your response. This number is reinitialized.");
					this.responsesGiven.get(i).remove(minGiven);
					this.responsesGiven.get(i).remove(maxGiven);
					this.responsesGiven.get(i).add(-1);
					this.responsesGiven.get(i).add(10);
					number = rand.nextInt(10);
				}
				
				
				response = response.concat(Integer.toString(number));
			} else {
				response = response.concat(partsAiResponse[i]);
			}
			if (Boolean.valueOf(dev)) {
				System.out.println(Integer.toString(i) + this.responsesGiven.get(i));
				System.out.println(number);
			}		
		}
		
		return response;
	}
	
	/**
	 * Generate random number
	 */
	public String generateNumber() {
		Random rand = new Random();
		String number = String.format("%0"+combinationNumber+"d", rand.nextInt((int) Math.pow(10, combinationNumber)));
		
		return number;
	}
}
