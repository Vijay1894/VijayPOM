package com.qa.orangehrm.PageTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aq.orangehrm.BaseTest.vjBaseTest;
import com.aq.orangehrm.page.vjLoginPage;
import com.qa.orangehrm.AppConstant.vjAppConstant;

public class vjproductinforpageTest extends vjBaseTest{
	
	
	@BeforeClass
	public void productinforSetup()
	{
		vjhomepage = vjloginpage.loginuser("test22@gmail.com", "Vijay@1894");
	}
	
	
	@Test(priority = 1)
	public void checktitle()
	{
		String acttile = vjproductinforpage.productpagetitle();
		Assert.assertEquals(acttile, "MacBook Pro");
	}
	
	 
	@Test
	public void productSearchHeaderTest()
	{
		vjsearchResultsPage = vjhomepage.doSearch("macbook");
		vjproductinforpage = vjsearchResultsPage.selectproduct("MacBook Pro");
		String actualProductHeader = vjproductinforpage.getproductHeader();
		Assert.assertEquals(actualProductHeader, "MacBook Pro");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test(priority = Integer.MAX_VALUE)
	public void logout()
	{
		 vjproductinforpage.logoutapp();
		 vjhomepage.logout();
		 Assert.assertEquals("My Account", vjAppConstant.HOME_PAGE_TITLE);	
	}
	


	
	
}
