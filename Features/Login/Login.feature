
@login 
Feature: User should be able to login into the system 


@login_02 @skip
Scenario: login test
*  when user is on login page
*  user clicks on login button
*  user enters username and password
*  user should be on homepage


@login_01 @skip
Scenario: Verify if user can login
*  when user is on login page
*  user clicks on login button
*  user enters "inportia_batch01@yopmail.com" and "123456"
*  user should be on homepage


@login_01 @skip
Scenario Outline: Verify if user can login
*  when user is on login page
*  user clicks on login button
*  user enters "<username>" and "<password>"
*  user should be on homepage

Examples: Sample usernames and password
|username                    |password   |
|capyteacher1                | GotWic    |
|inportia_batch01@yopmail.com|123456     |
|inportia_batch02@yopmail.com|123456     |
|inportia_batch03@yopmail.com|123456     |
