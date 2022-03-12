package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.util.Constants;
import com.qa.opencart.util.ElementUtil;

public class AccountsPage {

	//header is available or not
	//left section headers
private WebDriver driver;
private ElementUtil eleutil;
	private By header = By.cssSelector("div#logo a");
	private By accountsSections = By.cssSelector("div#content a");
	private By SearchField = By.name("search");
	private By SearchButton = By.cssSelector("div#search button");


//from the accounyts logout veriffy
	private By logout = By.linkText("Logout");

	public AccountsPage(WebDriver driver) {
		this.driver=driver;
		eleutil = new ElementUtil(driver);
	}
	//page actions
	public String getAccountPageTitle() {
		return eleutil.doGetTitle(Constants.ACCOUNTS_PAGE_TITLE, Constants.DEFAULT_TIME_TIMEOUT);
	}
	
	public String getAccountsPageHeader() {
		return eleutil.doGetText(header);
	}
	
	public boolean islogoutLinkExist() {
		return eleutil.doIsDisplayed(logout);
	}
	public void logout() {
		if(islogoutLinkExist()) {
			eleutil.doClick(logout);
	}
}
public void getAccountsSecList() {
	eleutil.waitForElementToBeVisbile(accountsSections, 10);
}
}