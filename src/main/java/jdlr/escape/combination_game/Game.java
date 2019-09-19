package jdlr.escape.combination_game;

import java.util.Scanner;

import jdlr.escape.combination_game.conf.ConfFactory;
import jdlr.escape.combination_game.gamer.AI;
import jdlr.escape.combination_game.gamer.User;
import jdlr.escape.combination_game.mode.ChallengerMode;
import jdlr.escape.combination_game.mode.DefenderMode;
import jdlr.escape.combination_game.mode.DuelMode;

/**
 * Properties of the game
 * @author jdlr
 *
 */
public class Game {
	Scanner sc = new Scanner(System.in);
	private ConfFactory confFactory;
	private int type;
	private AI ai;
	private User user;
	private String end;
	
	public Game(ConfFactory pConfFactory, AI pAi, User pUser) {
		this.confFactory = pConfFactory;
		this.ai = pAi;
		this.user = pUser;
	}
		
	/**
	 */
	public void start() {
		this.askType();
		this.launchMode(this.type);
	}
	
	/**
	 * end of the game, propose choice
	 */
	public void end(int pType) {
		System.out.println("");
		System.out.println("Que souhaitez vous faire: ");
		System.out.println("1 - Rejouer au même mode");
		System.out.println("2 - Choisir un nouveau mode");
		System.out.println("3 - Quitter");
		
		boolean responseIsGood;
		
		do {
            int response = sc.nextInt();
            responseIsGood = (response == 1 || response == 2 || response == 3);

            if (!responseIsGood) {
                System.out.println("Veuillez renseigner un chiffre parmi les choix proposés");
            } else if (response == 1) {
            	this.launchMode(pType);
            } else if (response == 2) {
            	this.start();
            } else if (response == 3) {
            	System.out.println("BYE");
            }
        } while (!responseIsGood);
	}
	
	/**
	 * Ask user the type of game he wanna play
	 * @return Type of game
	 */
	public int askType() {
		System.out.println("Choississez votre type de partie: ");
		System.out.println("1 - Mode Challenger");
		System.out.println("2 - Mode Défenseur");
		System.out.println("3 - Mode Duel");
		boolean responseIsGood;
		
		do {
            type = sc.nextInt();
            responseIsGood = (type == 1 || type == 2 || type == 3);

            if (!responseIsGood) {
                System.out.println("Veuillez renseigner un chiffre parmi les choix proposés");
            }
        } while (!responseIsGood);
        return type;	
	}
	
	/**
	 * lanch the mode choosed
	 * @param pType
	 */
	public void launchMode(int pType) {
		switch (pType) {
			case 1:
				ChallengerMode challengerMode = new ChallengerMode(confFactory);
				end = challengerMode.inGame(ai, user);
				if (end == "END") {
					this.end(1);
				}
				break;
			case 2:
				DefenderMode defensorMode = new DefenderMode(confFactory);
				end = defensorMode.inGame(ai, user);
				if (end == "END") {
					this.end(2);
				}
				break;
			case 3:
				DuelMode duelMode = new DuelMode(confFactory);
				end = duelMode.inGame(ai,  user);
				if (end == "END") {
					this.end(3);
				}
				break;
		}
	}
}
