package com.aq.orangehrm.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.orangehrm.util.vjElementutil;

public class vjHomepage {
	
	private WebDriver driver;
	private vjElementutil vjelementutil;
	
	public vjHomepage(WebDriver driver)
	{
		this.driver= driver;
		vjelementutil = new vjElementutil(driver);
		
	}
	
	By headers = By.cssSelector("div#content>h2");
	By search = By.name("search");
	By searchicon = By.cssSelector("div#search button");
	By logout = By.linkText("Logout");
	
	public String homepagegeturl ()
	{
		String url = driver.getCurrentUrl();
		return url;
	}
	
	public String homepagetitle()
	{
		String title = driver.getTitle();
		return title;
	}
	
	public List<String> getheaderslist()
	{
		List<WebElement> list = driver.findElements(headers);
		List<String> headersvaluelist = new ArrayList<String>();
		for (WebElement e : list )
		{
			String text = e.getText();
			headersvaluelist.add(text);
		}
		return headersvaluelist;
	}
	
	
	public vjSearchResultsPage doSearch(String userpreference)
	{
		System.out.println("searchkey:==>" +userpreference);
		WebElement searchele = vjelementutil.waitforElementforvisible(search, 5);
		searchele.clear();
		searchele.sendKeys(userpreference);
		vjelementutil.doclick(searchicon);
		return new vjSearchResultsPage(driver);	
	}

	public void logout()
	{
		 driver.findElement(logout).click();

	}
	



	

	

	



	

}
