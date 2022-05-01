package com.websites.testcases;




import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.websites.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig= new ReadConfig();
	public String baseURL = readconfig.getApplicationURL();
	public String username =readconfig.getUsername();
	public String password =readconfig.getPassword();
	 public static WebDriver driver;
	 public static Logger logger;
	 
	 @Parameters("browser")
	 @BeforeClass
	 public void setup(String br) {
	logger = Logger.getLogger("Jwellery");
	  PropertyConfigurator.configure("log4j.properties");
	  
	   if(br.equals("chrome")) {
	  System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		 driver = new ChromeDriver();
	   }else if (br.equals("firefox")) {
		   System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
			 driver = new FirefoxDriver();
		   }else if (br.equals("edge")){
			   System.setProperty("webdriver.edge.driver",readconfig.getMsEdgePath());
				 driver = new EdgeDriver();
		   }
	      driver.get(baseURL);
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	   }
	 public void captureScreen(WebDriver driver, String tname) throws IOException {
		 TakesScreenshot ts= (TakesScreenshot)driver;
		 File source = ts.getScreenshotAs(OutputType.FILE);
		 File target = new File(System.getProperty("user.dir")+"/Screenshots/"+ tname +".png");
	     FileUtils.copyFile(source, target);
	     System.out.println("Screenshot Taken");
	     }
	  public String randomString() {
		  String generatedstring= RandomStringUtils.randomAlphabetic(0);
		  return generatedstring;
	  }
	  public String randomNumber() {
		  String generatedstring2= RandomStringUtils.randomNumeric(0);
		  return generatedstring2;
	  }
	
	 @AfterClass
	 public void tearDown() {
	   
		 driver.quit();
	 
	 }
		 
}


