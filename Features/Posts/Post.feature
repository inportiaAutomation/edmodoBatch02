@post
Feature: User should be able to post on homepage


Background: User logins into the system
*  when user is on login page
*  user clicks on login button
*  user enters username and password



@post_01 
Scenario: verify if user can post note
* Click on the Note tab on homepage
* Enter the note message
* Select the recipient from the dropdown
* Send the note
* Verify if note is send and can be seen on the homepage stream


@post_02 @skip
Scenario: verify if user can post Assignment
* Click on the Assignment tab on homepage
* Enter the assignment message
* Select the recipient from the dropdown
* Send the assignment
* Verify if assignment is send and can be seen on the homepage stream


@post_03 @skip
Scenario: verify if user can post note with attachment
* Click on the Note tab on homepage
* Enter the note message
* Select the recipient from the dropdown
* Attach file with the note
* Send the note
* Verify if note is send and can be seen on the homepage stream