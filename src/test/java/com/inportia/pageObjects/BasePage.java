package com.inportia.pageObjects;

import org.openqa.selenium.WebDriver;


public class BasePage {

public WebDriver browser;
	
	
	public BasePage(WebDriver driverp)
	{
		browser = driverp;
	}
	
	
	public void pageRefresh()
	{
	     browser.navigate().refresh();	
	}
	
	public void getPageUrl()
	{
		System.out.println(browser.getCurrentUrl());
	}
	
	

	
	
	
	
	
}
