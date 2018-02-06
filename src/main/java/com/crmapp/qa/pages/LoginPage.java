package com.crmapp.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crmapp.qa.base.TestBase;

public class LoginPage extends TestBase{

//Define Object factory OR(Object repositary)

//Define Page Objects
	@FindBy(name="username")
	WebElement username;
	
	 @FindBy(name="password")
	 WebElement password;
	 
	 @FindBy(xpath="//input[@type='submit']")
	 WebElement loginBtn;


	 @FindBy(xpath="//button[contains(text(),'Sign Up')]")
	 WebElement signUpButton;
	 
	 @FindBy(xpath="//img[contains(@class,'img-responsive')]")
	 WebElement crmLogo;
 
//methods
	 //Constructor,Initialize the page factory
	 public LoginPage()
	 {
		 //all the variables will be initialized using the below
		 PageFactory.initElements(driver,this) ;
	 }
	 
//Define Actions-Features
	 
public String verifyLoginPageTitle() {
	return driver.getTitle();
}
public boolean validateCRMImage() {
	return crmLogo.isDisplayed();
}
public HomePage login(String uid,String pwd)
{
	username.sendKeys(uid);
	password.sendKeys(pwd);
	//loginBtn.click();
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", loginBtn);
//since clicking on this takes u to home page it returns homepage
	 return new HomePage();
}
}
