package com.qa.orangehrm.Factory;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.qa.orangehrm.AppConstant.vjAppConstant;
import com.qa.orangehrm.exception.FrameworkException;

public class vjDriverFactory {
	
	 WebDriver driver;
	Properties prop;
	OptionsManager optionsManager;
	public static String highlight;
	
	public vjDriverFactory(WebDriver driver)
	{
		this.driver= driver;
	}
	
	
	public static  ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	
	public WebDriver initialdriver(Properties prop)
	{
		String browsername =prop.getProperty("browser");
		
		highlight = prop.getProperty("highlight");
		
		optionsManager = new OptionsManager(prop);
		
		
		switch ((browsername).trim().toLowerCase()) {
		case "edge":
			tldriver.set(new EdgeDriver(optionsManager.getEdgeOptions()));
			//driver= new EdgeDriver(optionsManager.getEdgeOptions());
			break;
		case "chrome":
			driver= new ChromeDriver();
			break;

		default:
			System.out.println("plz pass the right browser ==>" +browsername );
			throw new FrameworkException("==invalid browser==");
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		getDriver().get(prop.getProperty("url"));
		return getDriver();
	}
	
	/**
	 * get driver using threadlocal
	 * @return 
	 */
	public static WebDriver getDriver()
	{
		return tldriver.get();
	}
	
	/**
	 * This method is used to initallize the properties form .properties file 
	 * @return
	 */
	
	public Properties intiprop()
	{
		prop= new Properties();
		try 
		{
		FileInputStream ip = new FileInputStream(vjAppConstant.CONFIG_PROP_FILE_PATH);
	    prop.load(ip);
		}
		catch(Exception e )
		{
			e.printStackTrace();
		}
		
		return prop;
	}
}
