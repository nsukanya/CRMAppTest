package com.crmapp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crmapp.qa.base.TestBase;

public class HomePage  extends TestBase{
	//Homepage
	//1.Define Page Objects
	
		@FindBy(xpath="//td[contains(text(),'User: Sukanya Natarajan')]")
		WebElement userNameLabel;
		
		@FindBy(xpath="//a[contains(text(),'Contacts')]")
		WebElement contactsLink;
		
		@FindBy(xpath="//a[contains(text(),'New Contact')]")
		WebElement newContactsLink;
		
		@FindBy(xpath="//a[contains(text(),'Deals')]")
		WebElement dealsLink;
		
		@FindBy(xpath="//a[contains(text(),'Tasks')]")
		WebElement tasksLink;
 //2.Constructor,Initialize the page objects	
	public HomePage()
	{
		 
			 //all the variables will be initialized using the below
			 PageFactory.initElements(driver,this) ;
		 
	}
	
	//3.Define Actions-Features
	 
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyUserName() {
		return userNameLabel.isDisplayed();
	}
	
	//since this is a page chaining model,when we click on contactlink,it should opem contacts page
	//so the method should return the next page that is openend,So that is why we create a seperate class for each page
	public ContactsPage clickOnContactsLink() {
		
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactsLink() {
		//This is for creating a new contact
		//for mouse over use actions class
		Actions action=new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactsLink.click();
		
	}
		
}
