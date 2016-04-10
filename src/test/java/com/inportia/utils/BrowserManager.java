package com.inportia.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BrowserManager {

	static WebDriver browser;
	
	
	@Before
	public static WebDriver getBrowser(String browserType)
	{
		switch(browserType)
		{
		    case "Firefox":
		    	  browser = new FirefoxDriver();
		    	  browser.manage().window().maximize();
		    	  browser.manage().deleteAllCookies();
		    	  browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			      break;
			default:
				  break;
		}
		
		return browser;
	}
	
	
	@After
	public void tearDown()
	{
		System.out.println("tearing up the test...");
	}
	
	
}
