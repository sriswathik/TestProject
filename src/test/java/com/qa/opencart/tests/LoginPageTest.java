package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.util.Constants;

public class LoginPageTest extends BaseTest{
@Test(priority=1)
	public void loginpageTitleTest() {
	//we should never driver in test
	//write in login page class
	//assert
	String acTitle=loginpage.getLoginPageTitle();
System.out.println("page title:"+acTitle);
Assert.assertEquals(acTitle,Constants.LOGIN_PAGE_TITLE);
//instead of maintain hard code we can create constants

}
@Test(priority=2)
public void loginpageUrlTest() {
	
	
	Assert.assertTrue(loginpage.getLoginPageUrl());

}
@Test(priority=3)
public void ForgotPwdLinkTest() {
Assert.assertTrue(loginpage.IsForgotPwdLinkExist());
}
@Test(priority=4)
public void RegiterLinkTest() {
Assert.assertTrue(loginpage.IsRegisterLinkExist());
}
@Test(priority=5)
public void loginTest() {
	loginpage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	//we can trim spaces so that iun n pwd are always accurate.
	//in config.prop file maybe we put after value (browser)chrome we may \give a space
	//assert will do later in next chapter.
}
}

