package jdlr.escape.combination_game.conf;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Factory giving access to the configuration app
 * @author jdlr
 *
 */
public class ConfFactory {
	Properties configuration;
	private int combinationNumber;
	private int combinationTry;
	private String devMode;
	protected static Logger logger = Logger.getLogger(ConfFactory.class);
	
	public ConfFactory() {
		try {
			configuration = new Properties();
			configuration.load(new FileInputStream("src/main/resources/configuration.properties"));
			
			combinationNumber = Integer.parseInt(configuration.getProperty("combination.number"));
			combinationTry = Integer.parseInt(configuration.getProperty("combination.try"));
			devMode = configuration.getProperty("combination.dev");
		} catch (IOException e) {
            logger.setLevel(Level.ERROR);
			logger.error("ERROR FILE NOT FOUND");
			System.out.println("ERROR FILE NOT FOUND");
        } 
	}
	
	
	// GETTERS 
	public int getCombinationNumber() {
		return this.combinationNumber;
	}
	
	public int getCombinationTry() {
		return this.combinationTry;
	}
	
	public String getDevMode() {
		return this.devMode;
	}
}
