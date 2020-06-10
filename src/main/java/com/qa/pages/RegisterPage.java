package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



import com.qa.base.BaseClass;

public class RegisterPage extends BaseClass{

		WebDriver driver;
		
		By signIn = By.linkText("Sign in");
		
		By email = By.xpath("//input[@id='email_create']");
		
		By createButton = By.xpath("//button[@id='SubmitCreate']");
		
		public RegisterPage(WebDriver driver)
		{
			this.driver = driver;
		}
		
		public boolean checkSignInLink()
		{
			return driver.findElement(signIn).isDisplayed();
		}
		
		public void doRegister(String email)
		{
			driver.findElement(this.email).sendKeys(email);
			driver.findElement(createButton).click();
		}
	}


