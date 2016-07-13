package com.inportia.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	By assignment_group_name = By.xpath(".//*[@id='suggest-19949173']/a/span[2]");
	
	
	// assignments
	By assignment_tab = By.linkText("Assignment");
	By assignment_title = By.name("ass-title");
	By due_date = By.xpath(".//*[@id='postbox-assignment-content']/div[4]/input");
	// recipients
	//By assignment_desc = By.xpath(".//*[@id='postbox-assignment-content']/div[7]/textarea");
	By assignment_desc = By.xpath("//textarea[@class='placeholder-input assignment-description-input emoji-enabled auto-enhance-url']");
	
    // recipient locators
	By assignment_recipient = By.xpath("//textarea[@class='postbox-send-input-container placeholder-container teacher']");
	By asignment_send_button = By.xpath("//a[@class='postbox-send btn blue-btn']");
	
	
	
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
		 
//		 //wait for the text to be present
		 WebDriverWait wait = new WebDriverWait(browser,10);
		 wait.until(ExpectedConditions.textToBePresentInElementLocated(stream_container, noteMsg) );
		 
		 String stream_text = browser.findElement(stream_container).getText();
		 
		 System.out.println(stream_text);
		 
		 boolean is_note_posted = stream_text.contains(noteMsg);
		 Assert.assertTrue(is_note_posted, "Message not posted");
	}
	
	
	// actions for assignment
	
	public void click_assignment_tab()
	{
		browser.findElement(assignment_tab).click();
	}
	
	
	public void set_assignment_title(String assignmentTitle)
	{
	     browser.findElement(assignment_title).sendKeys(assignmentTitle);
	}
	
	public void set_due_date()
	{
		String date = "12/12/20" + "16" ;
		browser.findElement(due_date).sendKeys(date);
	}
	
	public void set_assignment_description(String desc)
	{
		browser.findElement(assignment_desc).sendKeys(desc);
	}
	
	public void click_send_assignment()
	{
		browser.findElement(asignment_send_button).click();
	}
	
	public void type_recipient_group_name_assignment()
	{
		List<WebElement> elem = browser.findElements(recipient_textBox);
		elem.get(1).sendKeys("TestGroup");
	}
	
	public void select_the_recipient_group_assignment()
	{
		browser.findElement(assignment_group_name).click();
	}
	
}
