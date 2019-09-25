package jdlr.escape.combination_game.log;

import org.apache.log4j.Logger;

public class Logger4j {
	private static Logger logger = Logger.getLogger(Logger4j.class);
	  
	public static void main(String[] args) {
		logger.debug("msg de debogage");
	    logger.info("msg d'information");
	    logger.warn("msg d'avertissement");
	    logger.error("msg d'erreur");
	    logger.fatal("msg d'erreur fatale");   
	}
}

