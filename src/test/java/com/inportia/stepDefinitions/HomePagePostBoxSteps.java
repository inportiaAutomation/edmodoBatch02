package com.inportia.stepDefinitions;

import com.inportia.pageObjects.HomePagePostBox;
import com.inportia.utils.CommonResourceHandler;

import cucumber.api.java.en.Given;

public class HomePagePostBoxSteps {

	HomePagePostBox homePagePostBox;
    static String sample_note_message;
	
	
	public HomePagePostBoxSteps()
	{
		homePagePostBox = new HomePagePostBox(Hooks.browser);
	}
	
	
	@Given("^Click on the Note tab on homepage$")
	public void click_on_the_Note_tab_on_homepage() throws Throwable {
		homePagePostBox.click_note_tab();
	}

	@Given("^Enter the note message$")
	public void enter_the_note_message() throws Throwable {
		HomePagePostBoxSteps.sample_note_message = "Sample Note message : "+CommonResourceHandler.getRandomString(5);
		homePagePostBox.set_note_text(HomePagePostBoxSteps.sample_note_message);
	}

	@Given("^Select the recipient from the dropdown$")
	public void select_the_recipient_from_the_dropdown() throws Throwable {
		homePagePostBox.type_recipient_group_name();
		homePagePostBox.select_the_recipient_group();
	}

	@Given("^Attach file with the note$")
	public void attach_file_with_the_note() throws Throwable {
		homePagePostBox.setUploadFileWithPost();
	}

	@Given("^Send the note$")
	public void send_the_note() throws Throwable {
		homePagePostBox.click_send_note();
	}

	@Given("^Verify if note is send and can be seen on the homepage stream$")
	public void verify_if_note_is_send_and_can_be_seen_on_the_homepage_stream() throws Throwable {
		// get the text of the whole stream
		// find the note recently posted
	    homePagePostBox.verify_if_note_posted(HomePagePostBoxSteps.sample_note_message);
	}

}
