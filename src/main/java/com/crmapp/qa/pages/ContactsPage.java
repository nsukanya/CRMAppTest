package com.crmapp.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crmapp.qa.base.TestBase;

public class ContactsPage  extends TestBase {

	
	//1.Define Page Objects
	
			@FindBy(xpath="//td[contains(text(),'Contacts')]")
			WebElement contactsLabel;
			
			@FindBy(id="first_name")
			WebElement firstName;
			
			@FindBy(id="surname")
			WebElement lastName;
			
			@FindBy(name="client_lookup")
			WebElement company;
			
			@FindBy(xpath="//input[@type='submit' and @value='Save']")
			WebElement saveBtn;
			
	//2.Constructor
			public ContactsPage()
			{
				 
					 PageFactory.initElements(driver,this) ;
				 
			}		
	//3.Methods	
			public boolean verifyContactsLabel()
			{
				//validate that contacts label is displayed in the contacts page
				return contactsLabel.isDisplayed();
			}
			
			public void selectContactsByName(String name)
			{
				//select the user CRMTEst from the contact list check box
				////a[text()='Rahul Dravid']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']
				driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();

			}
			
			public void createNewContact(String myTitle,String myFirstname,String myLastName,String myCompany) {
				//title  textbox is a dropdown-use select class
				Select select=new Select(driver.findElement(By.name("title")));
				select.selectByVisibleText(myTitle);
				firstName.sendKeys(myFirstname);
				lastName.sendKeys(myLastName);
				company.sendKeys(myCompany);
				saveBtn.click();
				
			}
}
