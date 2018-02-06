package com.crmapp.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crmapp.qa.util.TestUtil;
import com.crmapp.qa.util.WebEventListener;

public class TestBase {
	//This is the base class
	//global variables
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver eventDriver;
	public static WebEventListener eventListener;
	public TestBase() 
	{
		
	try
	{
	//Constructor	
	//ChromeDriver
	 prop=new Properties();
	FileInputStream fis=new FileInputStream("C:\\Users\\nsuka\\eclipse-workspace\\CRMTest\\src\\main\\java\\com\\crmapp\\qa\\config\\config.properties");
	prop.load(fis);
	} //try block
	catch (FileNotFoundException e)
	{
		e.printStackTrace();
	} //catch block
 catch (IOException e) {
		e.printStackTrace();
	}

}
	
	public static void initialization()
	{
		String browserName=prop.getProperty("browser");
		if (browserName.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver","C://Users/nsuka/AutomationTools/chromedriver.exe");
		 driver=new ChromeDriver();	
		}
		if (browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C://Users/nsuka/AutomationTools/geckodriver.exe");
			 driver=new FirefoxDriver();
		}
		eventDriver = new EventFiringWebDriver(driver);
		eventListener=new WebEventListener();
		eventDriver.register(eventListener);
		driver=eventDriver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//defined the timeout in the utils class
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
}
