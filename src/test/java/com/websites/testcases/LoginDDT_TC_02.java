package com.websites.testcases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.websites.pageobjects.LoginPage;
import com.websites.utilities.XLUtils;

public class LoginDDT_TC_02 extends BaseClass {
	
@Test (dataProvider="logindata")	
public void loginDDT(String uname, String pswrd) throws InterruptedException {
	LoginPage lp= new LoginPage(driver);
	lp.setUserName(uname);
logger.info("username provided");
	lp.setPassword(pswrd);
logger.info("password provided");
	lp.clickSubmit();
logger.info("login button clicked");

Thread.sleep(3000);
	
	
	
	/*if(driver.getTitle().equals("Dashboard")) {
		System.out.println("User Logged in to Dashboard");
		logger.info("login passed");
		Thread.sleep(3000);
		lp.clickLogout();
		
		}else {
		System.out.println("Invalid Login credentials");
		logger.warn("Login failed");
		
	}
}*/
   if(isAlertPresent()==true) {
	   driver.switchTo().alert().accept(); //closing wrong credentials alert
	   driver.switchTo().defaultContent();
	   logger.warn("login Failed");
	   Assert.assertTrue(false);
	   
   }else {
	   Assert.assertTrue(true);
	   lp.clickAccountImage();
	   Thread.sleep(5000);
	   lp.clickLogout();
	  logger.info("login passed");
	   //driver.switchTo().alert().accept();//closing logout alert
	   //driver.switchTo().defaultContent();
   }
} 
   public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		   }catch(NoAlertPresentException e) {
			 return false;   
		   }
		} 



@DataProvider(name="logindata")
String[][] getData() throws IOException{
	
	String path =System.getProperty("user.dir")+"\\src\\test\\java\\com\\websites\\testdata\\logindata.xlsx";
      
	 int rowcount= XLUtils.getRowCount(path, "Sheet1");
	 int colcount= XLUtils.getCellCount(path, "Sheet1", 1);
	 
	 String logindata[][]= new String[rowcount][colcount];
	  
	 for (int i=1; i<=rowcount; i++) {
		 
	   for (int j=0; j<colcount; j++) {
		   logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);//for 1st row and 0 coloumn
	   }
	 }
  return logindata;

}
}
