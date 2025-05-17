package com.aq.orangehrm.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.orangehrm.util.vjElementutil;

public class vjLoginPage {
	
	private WebDriver driver;
	private vjElementutil vjelementutil;
	
	public vjLoginPage(WebDriver driver)
	{
		this.driver= driver;	
		vjelementutil = new vjElementutil(driver);
	}
	
	//By locator 
	
	private By emailid = By.id("input-email");
	private By Pwd = By.id("input-password");
	private By loginbtn = By.xpath("//input[@value='Login']");
	private By forgotpwd = By.partialLinkText("Forgotten Password");
	
	
	// public page actions 
	
	public String loginpagegeturl()
	{
	   return vjelementutil.geturl();
	
	}
	
	public String loginpagetitle()
	{
		return vjelementutil.gettitle();
	}
	
	
	public 	vjHomepage  loginuser(String username , String password )
	{
		vjelementutil.waitforElementforvisible(emailid, 5).sendKeys(username);
		vjelementutil.waitforElementforvisible(Pwd, 5).sendKeys(password);
		vjelementutil.doclick(loginbtn);
		return new vjHomepage(driver);
	}

	
	


	

	

}
