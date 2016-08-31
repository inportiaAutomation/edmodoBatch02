@post
Feature: User should be able to post on homepage


Background: User logins into the system
*  when user is on login page
*  user clicks on login button
*  user enters username and password



@post_001 
Scenario: verify if user can post note
* Click on the Note tab on homepage
* Enter the note message
* Select the recipient from the dropdown
* Send the note
* Verify if note is send and can be seen on the homepage stream


@post_002 @wip
Scenario: verify if user can post assignment
* Click on the Assignment tab on homepage
* Enter the Assignment title and set due date
* Enter the Assignment description
* Select the recipient from the dropdown for assignment
* Send the assignment
* Verify if note is send and can be seen on the homepage stream



@post_03 
Scenario: verify if user can post note with attachment
* Click on the Note tab on homepage
* Enter the note message
* Select the recipient from the dropdown
* Attach file with the note
* Send the note
* Verify if note is send and can be seen on the homepage stream
