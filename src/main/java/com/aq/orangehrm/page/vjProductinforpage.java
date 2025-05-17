package com.aq.orangehrm.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qa.orangehrm.util.vjElementutil;

public class vjProductinforpage {
	
	private WebDriver driver;
	private vjElementutil vjelementutil;
	
	public vjProductinforpage(WebDriver driver)
	{
		this.driver= driver;
		vjelementutil = new vjElementutil(driver);
	}
	
	
	private By productHeader = By.tagName("h1");
    private By MyAcoount = By.linkText("My Account");
    
	
	public String productpagetitle()
	{
		 return vjelementutil.gettitle();
		
	}
	
	public String getproductHeader()
	{
	 String header = driver.findElement(productHeader).getText();
	 System.out.println("productHeaer:==> " + header );
	 return header;
	}
	
	public vjHomepage logoutapp()
	{
		 vjelementutil.waitforElementforPresence(MyAcoount,5).click();
		return new vjHomepage(driver);
	}


	
	

}
