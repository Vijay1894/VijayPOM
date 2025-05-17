package com.qa.orangehrm.Factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;

public class OptionsManager {
	
	private Properties prop;
	

	private ChromeOptions co;
	private EdgeOptions eo;
	
	
	public OptionsManager (Properties prop)
	{
		this.prop =prop;
	}
	
	public EdgeOptions getEdgeOptions()
	{
		eo = new EdgeOptions();
		
		if (Boolean.parseBoolean(prop.getProperty("headless"))) {
			System.out.println("Running in headless mode");
			eo.addArguments("--headless");
		}
		
		if (Boolean.parseBoolean(prop.getProperty("incognito"))) {
			System.out.println("Running in incognito mode");
			eo.addArguments("--inprivate");
		}
		return eo;
	}
	
	public ChromeOptions getChromeOptions()
	{
		co = new ChromeOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless"))) {
			co.addArguments("--headless");
		}
		if (Boolean.parseBoolean(prop.getProperty("incognito"))) {
			co.addArguments("--incognito");
		}
		return co;
	}
	
	
	

}
