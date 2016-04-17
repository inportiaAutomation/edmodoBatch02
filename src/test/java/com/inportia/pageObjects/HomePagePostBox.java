package com.inportia.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.inportia.utils.CommonResourceHandler;


public class HomePagePostBox extends BasePage {
   
	public HomePagePostBox(WebDriver driverp)
	{
		super(driverp);
	}
	
	By note_link = By.linkText("Note");
	
	By note_text_box = By.name("content");
	
	By upload_tag = By.className("postbox-file-upload multi");
	By upload_tag_temp = By.tagName("file");
	
	By recipient_textBox = By.id("postbox-note-input");
	By recipient_group_name = By.xpath(".//*[@id='suggest-19949173']/a/span[2]");
	By send_button = By.xpath(".//*[@id='postbox-note-content']/form/div[1]/a[2]"); 
	By stream_container = By.className("stream-container");
	
	public void click_note_tab()
	{
		browser.findElement(note_link).click();;
	}
	
	public void set_note_text(String message)
	{
		browser.findElement(note_text_box).sendKeys(message);
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
		browser.findElement(upload_tag_temp).sendKeys(CommonResourceHandler.getUploadTextFilePath());
	}
	
	public void click_send_note()
	{
		browser.findElement(send_button).click();
	}
	
	public void verify_if_note_posted(String noteMsg)
	{
		 System.out.println(noteMsg);
		 
		 //wait for the text to be present
		 WebDriverWait wait = new WebDriverWait(browser,10);
		 wait.until(ExpectedConditions.textToBePresentInElementLocated(stream_container, noteMsg) );
		 
		 String stream_text = browser.findElement(stream_container).getText();
		 boolean is_note_posted = stream_text.contains(noteMsg);
		 Assert.assertTrue(is_note_posted, "Message not posted");
	}
	
}
