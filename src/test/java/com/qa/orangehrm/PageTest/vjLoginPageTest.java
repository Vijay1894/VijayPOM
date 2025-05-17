package com.qa.orangehrm.PageTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aq.orangehrm.BaseTest.vjBaseTest;
import com.qa.orangehrm.AppConstant.vjAppConstant;
import com.qa.orangehrm.AppConstant.vjAppError;

public class vjLoginPageTest extends vjBaseTest {
	
	
	@Test
	public void checkloginTitle()
	{
		String acttitle = vjloginpage.loginpagetitle();
		Assert.assertEquals(acttitle, vjAppConstant.LOGIN_PAGE_TITLE, vjAppError.TITLE_ERROR);
	}
	
	@Test
	public void checkloginurl()
	{
		String acturl = vjloginpage.loginpagegeturl();
		Assert.assertTrue(acturl.contains(vjAppConstant.LOGIN_PAGE_URL),vjAppError.URL_ERROR);
	}
	
	@Test(priority = Integer.MAX_VALUE)
	public void userlogin()
	{
		vjhomepage = vjloginpage.loginuser(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(vjhomepage.homepagetitle(), vjAppConstant.HOME_PAGE_TITLE, vjAppError.TITLE_ERROR);
	}
	

}
