package com.aq.orangehrm.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.orangehrm.util.vjElementutil;

public class vjSearchResultsPage {
	
	private WebDriver driver;
	private vjElementutil vjelementutil;
	
	public vjSearchResultsPage(WebDriver driver)
	{
		this.driver= driver;
		vjelementutil = new vjElementutil(driver);
	}
	
	private By productResults = By.cssSelector("div.product-thumb");
	
	public String checktitle()
	{
		String title =vjelementutil.gettitle();
		return title;
	}
	
	public int getproductresultscount()
	{
		int count = vjelementutil.waitforElementsforvisible(productResults,5).size();
		System.out.println("count of the product==>" +count);
		return count;
	}
	
	public vjProductinforpage selectproduct( String product)
	{
		System.out.println("productname==>" + product);
		vjelementutil.doclick(By.linkText(product));
		return new vjProductinforpage(driver);
	}
	
}
