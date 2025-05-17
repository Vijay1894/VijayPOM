package com.qa.orangehrm.util;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.orangehrm.Factory.vjDriverFactory;

public class vjElementutil {
	
	private WebDriver driver;
	private vjJavascriptutility js;
	
	public vjElementutil(WebDriver driver)
	
	{
		this.driver = driver;
		js = new vjJavascriptutility(driver);
		
	}
	
	public  WebElement  getElement(By locator)
	{
		WebElement element = driver.findElement(locator);
		highlightElement(element);
		return element;
	}
	
	
	
	private WebElement highlightElement(WebElement element )
	{
		if (Boolean.parseBoolean(vjDriverFactory.highlight)) {
			js.flash(element);
		}
		return element;
	}
	
	public  WebElement  getElements(By locator)
	{
		return driver.findElement(locator);
	}
	
	public String geturl()
	{
		String url = driver.getCurrentUrl();
		return url;
	}
	
	public String gettitle()
	{
		String title =  driver.getTitle();
		return title;
	}
	
	
	public void doclick(By locator)
	{
		driver.findElement(locator).click();
	}
	
	
	private void nullCheck(CharSequence[] value) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page and visible.
	 * Visibility means that the element is not only displayed but also has a height and width that is greater than 0.
	 * @param Timeouts
	 * @return
	 */
	public WebElement waitforElementforvisible (By logout , long Timeouts)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeouts));
		 WebElement element =  wait.until(ExpectedConditions.visibilityOfElementLocated(logout));
		 highlightElement(element);
		 return element;
		
	}
	
	/**
	 * An expectation for checking that all elements present on the web page that match the locatorare visible. 
	 * Visibility means that the elements are not only displayed but also have a heightand width that is greater than 0
	 * @param Timeouts
	 * @return
	 */
	public List<WebElement> waitforElementsforvisible(By locator , long Timeouts)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeouts));
		try {
		 return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		}
		
	 catch(TimeoutException e)
		{
		 return Collections.emptyList();
		}
	
	}
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page. 
	 *This does notnecessarily mean that the element is visible.
	 * @param Timeouts
	 * @return
	 */
	public WebElement waitforElementforPresence(By locator ,long Timeouts)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeouts));
		 WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		highlightElement(element);
		return element;
	}

	
	/**
	 * An expectation for checking that there is at least one element present on a web page.
	 * @param locator
	 * @param Timeouts
	 * @return
	 */
	public List<WebElement> waitforElementsforPresence(By locator ,long Timeouts)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeouts));
		try 
		{
		 return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		}
		catch(TimeoutException e)
		{
			return Collections.emptyList();
		}
	}
    
	
	
}
