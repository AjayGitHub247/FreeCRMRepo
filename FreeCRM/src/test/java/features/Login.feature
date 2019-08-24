Feature: Free CRM login feature

@Smoke
Scenario: Free CRM Login Test
Given User is already on login page
When Title of Login page is CMR
Then User Enter UserName and Password
Then User Clicks on login button
And User is on Home page
And User Logout from CRM Application


Scenario: Free CRM Calendar Verification
Given User is already on login page
When Title of Login page is CMR
Then User Enter UserName and Password
Then User Clicks on login button
And User is on Home page
Then User clicks on Calender tab
Then User should see Calender content
And User Logout from CRM Application


Scenario: Free CRM Login Test Regular Exp
Given User is already on login page
When Title of Login page is CMR
Then User Enter UserName "ajay24789@gmail.com" and Password "Ajay4444" fields
Then User Clicks on login button
And User is on Home page
And User Logout from CRM Application


Scenario Outline: Free CRM Login Test Example
Given User is already on login page
When Title of Login page is CMR
Then User Enter UserName <Username> and Password <Password> fields from Example 
Then User Clicks on login button
And User is on Home page
And User Logout from CRM Application

Examples: 
| Username | Password |
| ajay24789@gmail.com | Ajay4444 |


Scenario Outline: Free CRM Login Create Contact Test 
Given User is already on login page
When Title of Login page is CMR
Then User Enter UserName <Username> and Password <Password> fields from Example 
Then User Clicks on login button
And User is on Home page
Then User Mouse Hover and Clicks on Contact Tab
Then Verify the Contact page is loaded
Then User Clicks on Create New Button
Then Enter FirstName <FirstName> and LastName <LastName>
Then Click on Save Button
Then User Mouse Hover and Clicks on Contact Tab
Then Verify the New Contact Created <FirstName> and <LastName>
And User Logout from CRM Application

Examples: 
| Username | Password | FirstName | LastName |
| ajay24789@gmail.com | Ajay4444 | Ajay | Kumar |
| ajay24789@gmail.com | Ajay4444 | Bimal | Kumar |







