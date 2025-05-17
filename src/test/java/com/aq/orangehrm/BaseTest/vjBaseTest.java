package com.aq.orangehrm.BaseTest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aq.orangehrm.page.vjHomepage;
import com.aq.orangehrm.page.vjLoginPage;
import com.aq.orangehrm.page.vjProductinforpage;
import com.aq.orangehrm.page.vjSearchResultsPage;
import com.qa.orangehrm.Factory.vjDriverFactory;

public class vjBaseTest {
	
	WebDriver driver;
	vjDriverFactory DF;
	
	protected Properties prop;
	protected vjLoginPage vjloginpage;
	protected vjHomepage vjhomepage;
	protected vjSearchResultsPage vjsearchResultsPage;
	protected vjProductinforpage vjproductinforpage;
	
	
	
	@BeforeClass
	public void setup ()
	{
		DF = new vjDriverFactory(driver);
		prop= DF.intiprop();
		driver = DF.initialdriver(prop);
		
		vjloginpage = new vjLoginPage(driver);
		
	}
	
	@AfterClass	
	public void tearDown()
	{
       driver.quit();
    }

}
