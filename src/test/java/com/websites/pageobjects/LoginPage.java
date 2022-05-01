package com.websites.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="txt_UserName")
	@CacheLookup
	WebElement username;
	
	@FindBy(id="txt_Password")
	@CacheLookup
	WebElement password;
	
	@FindBy(id="btn_Login")
	@CacheLookup
	WebElement loginbtn;
	
	@FindBy(xpath ="//body/form[@id='Form_jweles']/div[@id='wrapper']/div[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/a[1]/img[1]")
	@CacheLookup
	WebElement accountimage;
	
	@FindBy(linkText ="Logout")
	@CacheLookup
	WebElement logoutlnk;
	
	public void setUserName(String usrname) {
		username.sendKeys(usrname);
	}
	
	public void setPassword(String pswrd) {
		password.sendKeys(pswrd);
	}
	
	public void clickSubmit() {
		loginbtn.click();
	}
	
	public void clickAccountImage() {
		accountimage.click();
	}
	public void clickLogout() {
		logoutlnk.click();
	}
}
