package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	WebDriver driver;
	Properties prop;
	
	public WebDriver initDriver(String browserName)
	{
		if(browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("safari"))
		{
			WebDriverManager.getInstance(SafariDriver.class).setup();
			driver = new SafariDriver();
		}
		else
		{
			System.out.println(browserName + " is not found, please correct the browser");
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		
		//driver.get(url)
		return driver;
	}
	
	public Properties initProp()
	{
		prop = new Properties();
		String path = "./src/main/java/com/qa/config/Config.properties";
		try 
		{
			InputStream input = new FileInputStream(path);
			prop.load(input);
		} 
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			System.out.println("Some issue with config file");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}

}
