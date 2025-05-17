package com.qa.orangehrm.PageTest;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aq.orangehrm.BaseTest.vjBaseTest;
import com.qa.orangehrm.AppConstant.vjAppConstant;
import com.qa.orangehrm.AppConstant.vjAppError;

public class vjHomePageTest  extends vjBaseTest{
	
	@BeforeClass
	public void homepageSetup()
	{
		vjhomepage = vjloginpage.loginuser(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	@Test
	public void checkTitle()
	{
		String actualtitle = vjhomepage.homepagetitle();
		Assert.assertEquals(actualtitle, vjAppConstant.HOME_PAGE_TITLE, vjAppError.TITLE_ERROR);
	}
	
	@Test
	public void checkurl()
	{
		String url = vjhomepage.homepagegeturl();
		Assert.assertTrue(url.contains(vjAppConstant.HOME_PAGE_URL), vjAppError.URL_ERROR);
		
	}
	
	@Test
	public void headerTest()
	{
	List<String >actualheaders =vjhomepage.getheaderslist();
	System.out.println("homepage headers:==>" +actualheaders );
	
	}
	
	@DataProvider
	public Object[][] getsearchdata()
	{
		return new Object[] [] {
			{"macbook", 3},
			{"imac", 1},
			{"samsung",2},
			{"canon",1},
			{"airtel",0}
		};
	}
	
	@Test(dataProvider = "getsearchdata")
	public void searchTest(String Searchkey , int resultcount)
	{
		vjsearchResultsPage = vjhomepage.doSearch(Searchkey);
		Assert.assertEquals(vjsearchResultsPage.getproductresultscount(),resultcount);
	}
	

}
