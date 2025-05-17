package com.qa.orangehrm.PageTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aq.orangehrm.BaseTest.vjBaseTest;

public class vjSearchResultspageTest  extends vjBaseTest {
	
	
	
	@BeforeClass
	public void homepageSetup()
	{
		vjloginpage.loginuser("test22@gmail.com", "Vijay@1894");
	}
	
	
	@Test
	public void checkresultcount()
	{
		vjsearchResultsPage.getproductresultscount();   
	}

	@Test
	public void selectproduct()
	{
		vjproductinforpage= vjsearchResultsPage.selectproduct("MacBook");
		Assert.assertEquals(vjproductinforpage.productpagetitle(), "MacBook");	
	}
}
