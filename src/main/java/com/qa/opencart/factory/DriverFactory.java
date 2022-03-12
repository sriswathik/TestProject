package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DriverFactory {

	public WebDriver driver;
	public Properties prop;
/**
 * this method is used to initialize the webdriver
 * @param browsername
 * @return this will retuen the driver
 */
	public WebDriver init_driver(Properties prop) {
		String browsername = prop.getProperty("browser").trim();
		System.out.println("browser name is"+browsername);
		if(browsername.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
		}else if(browsername.equals("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
            
		}else if(browsername.equals("safari")) {
			
			WebDriverManager.safaridriver().setup();
            driver=new SafariDriver();
			
	}else {
		System.out.println("please pass the right browser:"+browsername);
		
	}
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		
		return driver;
	}
	/**
	 * this method is used to initialize the properties
	 * 
	 * @return
	 * this will return prop reference
	 */
	public Properties init_prop() {
		//we need to use properties class
		//fileinputstream class
		//connect with that file path
		//n load all properties in the prop obj
		//whenever u want to capture from the prop obj simply use prop.getproperty method
		//only these 3 lines for prop
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream("./src/test/resources/config/config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
		//./from current projectory
	}
}
	
	
	
	
	

