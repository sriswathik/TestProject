package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.util.Constants;
import com.qa.opencart.util.ElementUtil;

public class LoginPage{
//1.declare private driver;
	private WebDriver driver;
	private ElementUtil eleutil;
	//crfeating s single obj n referred by multiple ref vars

	//2.login page  constructor
	
		public LoginPage(WebDriver driver) {
			this.driver=driver;
			eleutil = new ElementUtil(driver);
		}
		
	//3.Private By locators
		
		//encapsulation
		
		private By emailid = By.id("input-email");
		private By password = By.id("input-password");
		private By login = By.xpath("//input[@value='Login']");
		private By forgotpwd = By.linkText("Forgotten Password");
		private By register = By.linkText("Register");

		
		//4.page aactions
		//these methods are non static in nature
		//create obj og login class 
		//where to create?if we create in loginpage test then we have to create in base test also
		//so create in base test
		
		public String getLoginPageTitle() {
			return eleutil.doGetTitleWithFraction(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_TIME_TIMEOUT);
	
		}
		public boolean getLoginPageUrl() {
			return eleutil.waitForURLToContain(Constants.LOGIN_PAGE_URL_FRACTION, Constants.DEFAULT_TIME_TIMEOUT);
		}
		public Boolean IsForgotPwdLinkExist() {
			return eleutil.doIsDisplayed(forgotpwd);
			}
		public Boolean IsRegisterLinkExist() {
			return eleutil.doIsDisplayed(register);
			}
	public void doLogin(String un,String pwd) {
		System.out.println("Login with:" + un + " :  " + pwd);
		eleutil.doSendKeys(emailid, un);
		eleutil.doSendKeys(password, pwd);
		eleutil.doClick(login);

	}
	
	
}
