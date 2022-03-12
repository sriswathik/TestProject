package com.qa.opencart.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.LoginPage;

public class BaseTest  {
	DriverFactory df;
	Properties prop;
	WebDriver driver;
	LoginPage loginpage;

	//base test is supers class of all under src/test
	@BeforeTest
	public void setup() {
	//create an obj for driverfactory n loginpage.
		 df=new DriverFactory();
		prop =  df.init_prop();
		 driver=df.init_driver(prop);
		 loginpage=new LoginPage(driver);//we have to pass the driver
		 //login page constructor will be initialised.
		 

		
		
		
		
		
	}
	
	@AfterTest
	public void teardown() {
	//	driver.quit();
	}
	
	
}
