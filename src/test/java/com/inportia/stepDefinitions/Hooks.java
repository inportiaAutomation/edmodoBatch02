package com.inportia.stepDefinitions;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.inportia.utils.BrowserManager;

import cucumber.api.Scenario;
import cucumber.api.java.*;

public class Hooks
{

	
	
	public static WebDriver browser;
	
	@Before
	public void setUp()
	{
		System.out.println("Running before the suites");
		browser = BrowserManager.browser("Firefox");
	}
	
	
	public static void embedScreenShot(Scenario scenario)
	{
		if(scenario.isFailed()) {
	        try 
	        {
	        	 scenario.write("Current Page URL is " + browser.getCurrentUrl());
	             byte[] screenshot = ((TakesScreenshot)browser).getScreenshotAs(OutputType.BYTES);
	             scenario.embed(screenshot, "image/png");
	        } 
	        catch (WebDriverException somePlatformsDontSupportScreenshots) 
	        {
	            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
	        }
	        
	        }
	}
	
	@After
	public void tearDown(Scenario scenario)
	{
		System.out.println("Running after the suites...");
		Hooks.embedScreenShot(scenario);
		BrowserManager.tearDown();
	}
	
	
}
