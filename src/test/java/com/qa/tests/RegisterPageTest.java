package com.qa.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.qa.base.BaseClass;
import com.qa.pages.RegisterPage;

public class RegisterPageTest {
	WebDriver driver;
	BaseClass basePage;
	Properties prop;
	RegisterPage registerAccount;
	
	
	@BeforeTest
	public void setUp()
	{
		basePage = new BaseClass();
		basePage.initProp();
		String browserName = prop.getProperty("browser");
		driver = basePage.initDriver(browserName);
		driver.get(prop.getProperty("url"));
		
		registerAccount = new RegisterPage(driver);
	}
	@Test(priority=1)
	public void verifySignInLink()
	{
	AssertJUnit.assertTrue(registerAccount.checkSignInLink());	
	}
	
	@Test(priority=2)
	public void registerTest()
	{
		registerAccount.doRegister(prop.getProperty("email"));
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
