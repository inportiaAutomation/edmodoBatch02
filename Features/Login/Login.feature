
@login
Feature: User should be able to login into the system 


@login_01
Scenario: Verify if user can login
Given when user is on login page
And   user clicks on login button
When  user enters username and password
Then  user should be on homepage