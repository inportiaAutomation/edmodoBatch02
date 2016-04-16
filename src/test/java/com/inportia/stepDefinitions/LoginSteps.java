package com.inportia.stepDefinitions;


import com.inportia.pageObjects.LoginPage;
import com.inportia.utils.BrowserManager;

import cucumber.api.java.en.Given;


public class LoginSteps {

LoginPage loginPage ; 

public LoginSteps()
{
	loginPage = new LoginPage(Hooks.browser);
}


@Given("^when user is on login page$")
public void when_user_is_on_login_page() throws Throwable {
	loginPage.goToLoginPage();
}

@Given("^user clicks on login button$")
public void user_clicks_on_login_button() throws Throwable {
    loginPage.click_on_login_button();
}

@Given("^user enters username and password$")
public void user_enters_username_and_password() throws Throwable {
	
}


@Given("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
public void user_enters_and(String arg1, String arg2) throws Throwable {

	  System.out.println(arg1);
	  System.out.println(arg2);
	  loginPage.enterUserName(arg1);
	  loginPage.enterPassword(arg2);
	  loginPage.click_login_submit();
} 


@Given("^user should be on homepage$")
public void user_should_be_on_homepage() throws Throwable {
	loginPage.verify_if_login_successfull();
}


}
