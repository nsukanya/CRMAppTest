package com.crmapp.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyTestclass {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","C://Users/nsuka/AutomationTools/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://freecrm.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("username")).sendKeys("nsukanya");
		driver.findElement(By.name("password")).sendKeys("SukPro2018%");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
	
	}

}
