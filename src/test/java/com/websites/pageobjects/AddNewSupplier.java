package com.websites.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewSupplier {
   WebDriver ldriver;
   
   public AddNewSupplier(WebDriver rdriver) {
	      ldriver=rdriver;
	      PageFactory.initElements(rdriver, this);
   }  
	@FindBy(how=How.XPATH, using="//body/form[@id='Form_jweles']/div[@id='wrapper']/div[2]/div[1]/div[1]/div[2]/ul[1]/li[2]/a[1]/span[2]/i[1]")
    @CacheLookup
    WebElement subheadingWrapper;

 @FindBy(how=How.XPATH, using="//a[contains(text(),'Add Purchase Bills')]")
 @CacheLookup
 WebElement addPurchaseBillsLnk;


@FindBy(how=How.XPATH, using="//a[contains(text(),'Add New Suppiler')]")
@CacheLookup
WebElement addNewSupplier;

@FindBy(how=How.XPATH, using="//input[@id='Content_PlaceJwell_txt_AddCustomername']")
@CacheLookup
WebElement supplierName;

@FindBy(how=How.XPATH, using="//input[@id='Content_PlaceJwell_txt_AddCustomerMobile']")
@CacheLookup
WebElement mobileNo;

@FindBy(how=How.XPATH, using="//select[@id='Content_PlaceJwell_Drop_State']")
@CacheLookup
WebElement state;

@FindBy(how=How.XPATH, using="//input[@id='Content_PlaceJwell_txt_AddCustomerAddress']")
@CacheLookup
WebElement addressn;

/*@FindBy(how=How.XPATH, using="//input[@id='Content_PlaceJwell_txt_AddCustomerDOB']")
@CacheLookup
WebElement dob;*/

@FindBy(how=How.XPATH, using="//input[@id='Content_PlaceJwell_txt_AddCustomerPAN']")
@CacheLookup
WebElement panNo;

@FindBy(how=How.XPATH, using="//input[@id='Content_PlaceJwell_txt_AddCustomerGSTIN']")
@CacheLookup
WebElement gstinNo;

@FindBy(how=How.XPATH, using="//body/form[@id='Form_jweles']/div[@id='wrapper']/div[@id='Content_PlaceJwell_Up']/div[1]/div[2]/div[1]/div[1]/div[3]/input[1]")
@CacheLookup
WebElement saveDetailsbtn;

public void clickWrapper() {
	subheadingWrapper.click();
}
public void clickAddPurchaseBills() {
	addPurchaseBillsLnk.click();
}
public void clickAddNewSupplier() {
	addNewSupplier.click();
}
public void addSupplierName(String sname) {
	supplierName.sendKeys(sname);
}
public void addMobileNo(String mobno) {
	mobileNo.sendKeys(mobno);
} 
public void selectState() {
	Select s = new Select(state);
	 s.selectByVisibleText("Maharashtra");
}
public void addAddress(String address) {
	addressn.sendKeys(address);
}
public void addPan(String panno) {
	panNo.sendKeys(panno);
}
public void addGstin(String gstin) {
	gstinNo.sendKeys(gstin);
}
public void clickSaveDetails() {
	saveDetailsbtn.click();
 }
}

