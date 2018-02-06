package com.crmapp.qa.testsuite;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crmapp.qa.base.TestBase;
import com.crmapp.qa.pages.HomePage;
import com.crmapp.qa.pages.LoginPage;
import com.crmapp.qa.util.TestUtil;

public class LoginPageTest extends TestBase {
	//create an object of the LoginPage class
	LoginPage lp;
	HomePage hp;
	public LoginPageTest () {
		//call the constructor of the parent class,because we need the properties to be initailized
		super();
		
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		 lp = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleValidationtest() {
		String actualTitle=lp.verifyLoginPageTitle();
		Assert.assertEquals(actualTitle,TestUtil.LOGINPAGEEXPECTEDTITLE);
	}
	
	
	@Test(priority=2)
	public void crmLogoImageValidation() {
		boolean flag=lp.validateCRMImage();
		Assert.assertTrue(flag);
		
	}
	
	@Test(priority=3)
	public void loginTest() {
	hp=	lp.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void tearDown() {
	 driver.quit();
	}
	
	
	

}
