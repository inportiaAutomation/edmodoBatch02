package com.inportia.stepDefinitions;

import com.inportia.pageObjects.HomePagePostBox;

import cucumber.api.java.en.Given;

public class HomePagePostBoxSteps {

	HomePagePostBox homePagePostBox;
   
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
		homePagePostBox.set_note_text();
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
	}

	@Given("^Verify if note is send and can be seen on the homepage stream$")
	public void verify_if_note_is_send_and_can_be_seen_on_the_homepage_stream() throws Throwable {
	}

}
