package com.websites.testcases;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.websites.pageobjects.LoginPage;
import com.websites.testcases.BaseClass;
public class Login_TC extends BaseClass {
	@Test
	public void testlogin() throws IOException {
		
		LoginPage lpage = new LoginPage(driver);
		lpage.setUserName(username);
		logger.info("Entered Username");
		lpage.setPassword(password);
		logger.info("Entered Password");
		
		lpage.clickSubmit();
		logger.info("Clicked on login btn");
		
		 if (driver.getTitle().equals("Dashboard")) {
			 Assert.assertTrue(true);
			 logger.info("TestCase Passed");
		 }else {
			 captureScreen( driver, "testlogin");
			 Assert.assertTrue(false);
			 logger.info("TestCase Failed");
		 }
	}

}
