package com.crmapp.qa.testsuite;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crmapp.qa.base.TestBase;
import com.crmapp.qa.pages.ContactsPage;
import com.crmapp.qa.pages.HomePage;
import com.crmapp.qa.pages.LoginPage;
import com.crmapp.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{

	LoginPage loginp;
	HomePage homep;
	TestUtil tutil;
	ContactsPage contactsp;
	String  getCRMTestData;
	String contactSheetName ="contacts";
	
	
public ContactsPageTest() {
		//Constructor;
		//call the base class constructor
		super();
			}
	
@BeforeMethod
public void setUp()
{
	//We reach the  page after the login ,So this is provided in the setup()
	initialization();
	loginp=new LoginPage();
	homep=new HomePage();
	tutil= new TestUtil();
	contactsp= new ContactsPage();
	homep=	loginp.login(prop.getProperty("username"),prop.getProperty("password"));
	tutil.switchToFrame();
	contactsp=homep.clickOnContactsLink();
	
}

@Test(priority=1)
public void verifyContactsLabelTest() {
	//validates if "Contacts" is displayed or not
	Assert.assertTrue(contactsp.verifyContactsLabel(),"Contacts label is not present");
}

@Test(priority=2)
public void selectSingleContactsByNameTest() {
	//Select one user
contactsp.selectContactsByName("Rahul Dravid");
}

@Test(priority=3)
public void selectMultipleContactsByNameTest() {
	//Select multiple user
contactsp.selectContactsByName("Rahul Dravid");
contactsp.selectContactsByName("QA Tester");
}

@DataProvider
public Object[][] getCRMTestData() {

	Object data[][]=TestUtil.getTestData(contactSheetName);

	return data;
}


@Test(priority=4,dataProvider="getCRMTestData")
//since  2 cols will be returned in the excel sheet,enter 4 parameters
public void validateCreateNewContactTest(String title,String firstName,String lastName,String company) {
homep.clickOnNewContactsLink();
contactsp.createNewContact(title,firstName,lastName,company);
}


@AfterMethod
public void tearDown() {
 driver.quit();
}

}
