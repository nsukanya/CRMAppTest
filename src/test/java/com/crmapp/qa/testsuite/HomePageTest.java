package com.crmapp.qa.testsuite;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crmapp.qa.base.TestBase;
import com.crmapp.qa.pages.ContactsPage;
import com.crmapp.qa.pages.HomePage;
import com.crmapp.qa.pages.LoginPage;
import com.crmapp.qa.util.TestUtil;

public class HomePageTest  extends TestBase{
	HomePage hp;
	LoginPage lp;
	TestUtil tu;
	ContactsPage cp;
	public HomePageTest() {
		//Constructor;
		//call the base class constructor
		super();
			}
	
@BeforeMethod
public void setUp()
{
	//We reach the home page after the login ,So this is provided in the setup()
	initialization();
	lp=new LoginPage();
	tu= new TestUtil();
	hp=	lp.login(prop.getProperty("username"),prop.getProperty("password"));
}

@Test(priority=1)
public void VerifyHomePageTitleTest() {
	String actualHomePageTitle=hp.verifyHomePageTitle();
	//the third parameter is displayed only when test fails
	Assert.assertEquals(actualHomePageTitle, "CRMPRO","Home Page title doesn't match");
}
@Test(priority=2)
public void verifyUserNameTest() {
	tu.switchToFrame();
	Assert.assertTrue(hp.verifyUserName());
}
@Test(priority=3)
public void verifyContactLinkTest() 
{
	tu.switchToFrame();
	//clicking on the contact link on the home page takes the user to contacts page
	cp=hp.clickOnContactsLink();
}


@AfterMethod
public void tearDown() {
 driver.quit();
}
}
