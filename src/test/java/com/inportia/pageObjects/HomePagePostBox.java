package com.inportia.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.inportia.utils.CommonResourceHandler;


public class HomePagePostBox extends BasePage {
   
	public HomePagePostBox(WebDriver driverp)
	{
		super(driverp);
	}
	
	By note_link = By.linkText("Note");
	By note_text_box = By.className("placeholder-input emoji-enabled auto-enhance-url");
	By upload_tag = By.className("postbox-file-upload multi");
	By recipient_textBox = By.id("postbox-note-input");
	By recipient_group_name = By.xpath(".//*[@id='suggest-19949173']/a/span[2]");
	
	
	public void click_note_tab()
	{
		browser.findElement(note_link).click();;
	}
	
	public void set_note_text()
	{
		browser.findElement(note_text_box).sendKeys("Sample Note Text");
	}
	
	public void type_recipient_group_name()
	{
		browser.findElement(recipient_textBox).sendKeys("TestGroup-01");
	}
	
	public void select_the_recipient_group()
	{
		browser.findElement(recipient_group_name).click();
	}
	
	public void setUploadFileWithPost()
	{
		browser.findElement(upload_tag).sendKeys(CommonResourceHandler.getUploadTextFilePath());
	}
	
	
}
