package com.inportia.utils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;


public class BrowserManager {

	static WebDriver browser;
	static boolean is_created = false; 
	
	
    static FirefoxProfile getProfile(String type)
	{
  	    FirefoxProfile ffProfile = new FirefoxProfile();
	    File extensionFile = new File(System.getProperty("user.dir")+"/src/test/java/com/inportia/utils/extensions/modify_headers.xpi");
	    ffProfile.setEnableNativeEvents(false); 
	    try {
	      ffProfile.addExtension(extensionFile); 
	    } catch (IOException e) {
	      e.printStackTrace(); 
	    }
	    
	    //modifying the headers for adding the TURNOFFTESTS
	    ffProfile.setPreference("modifyheaders.headers.count", 1);
	    ffProfile.setPreference("modifyheaders.headers.action", "Add");
	    ffProfile.setPreference("modifyheaders.headers.name", "TURNOFFTESTS");
	    ffProfile.setPreference("modifyheaders.headers.value", "1");
	    ffProfile.setPreference("modifyheaders.headers.enabled", true);
	    ffProfile.setPreference("modifyheaders.config.active", true);
	    ffProfile.setPreference("modifyheaders.config.alwaysOn", true);
	    
		return ffProfile;
	}
	

	static WebDriver getBrowser(String browserType)
	{
		BrowserManager.is_created = true;
		    
		if(browserType.equalsIgnoreCase("Firefox")){
		    	  DesiredCapabilities capabilities = new DesiredCapabilities();
		    	  capabilities.setBrowserName("firefox");
		    	  capabilities.setPlatform(org.openqa.selenium.Platform.ANY);
		    	  capabilities.setCapability(FirefoxDriver.PROFILE, getProfile("ff"));
		    	  
		    	  // create the browser with the desired capabilities
		    	  BrowserManager.browser = new FirefoxDriver(capabilities);
		    	  BrowserManager.browser.manage().window().maximize();
		    	  BrowserManager.browser.manage().deleteAllCookies();
		    	  BrowserManager.browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
		
		return BrowserManager.browser;
	}
	
	
	public static WebDriver browser(String type)
	{
		if (BrowserManager.is_created == false)
		{
			System.out.println("------------- singleton factory ----------------------");
			getBrowser(type);
		}
		
		return BrowserManager.browser;
	}
	
	
	public static void tearDown()
	{
		System.out.println("tearing up the test...");
		try 
		{
			
			Thread.sleep(2);
	    	browser.close();
	    	is_created = false;
		}
		catch(Exception ex)
		{
		     System.out.println("Failed to close the browser safely.");	
		}
	}
	
	
}
