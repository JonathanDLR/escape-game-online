package jdlr.escape.combination_game.conf;

import java.io.FileInputStream;
import java.util.Properties;

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
	
	public ConfFactory() {
		try {
			configuration = new Properties();
			configuration.load(new FileInputStream("src/main/resources/configuration.properties"));
			
			combinationNumber = Integer.parseInt(configuration.getProperty("combination.number"));
			combinationTry = Integer.parseInt(configuration.getProperty("combination.try"));
			devMode = configuration.getProperty("combination.dev");
		} catch (Exception e) {
            e.printStackTrace();
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
