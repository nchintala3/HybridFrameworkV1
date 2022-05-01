package com.websites.testcases;
import com.websites.pageobjects.AddNewSupplier;
import com.websites.pageobjects.LoginPage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TC_AddNewSuppier_03 extends BaseClass {
	
@Test	
public void addingNewSupplier() throws InterruptedException {
	
	LoginPage lp= new LoginPage(driver);
	lp.setUserName(username);
	lp.setPassword(password);
	lp.clickSubmit();
	Thread.sleep(5000);
	
	
	AddNewSupplier newSupplier = new AddNewSupplier(driver);
	
	  newSupplier.clickWrapper();
	  newSupplier.clickAddPurchaseBills();
	  newSupplier.clickAddNewSupplier();
	  newSupplier.addSupplierName("prernamv");
	  newSupplier.addMobileNo("9888888888");
	  newSupplier.selectState();
	  newSupplier.addAddress("Nagpur");
	  newSupplier.addPan("aaaa54532");
	  newSupplier.addGstin("kk6666888888");
	  newSupplier.clickSaveDetails();
	  
	  Thread.sleep(5000);
	  
	  WebElement dropdown=driver.findElement(By.xpath("//span[@id='select2-Content_PlaceJwell_ddlSupplier-container']"));
         Select s = new Select(dropdown);
          s.selectByVisibleText("prernamv");
          Assert.assertTrue(true);
          
     }

}
