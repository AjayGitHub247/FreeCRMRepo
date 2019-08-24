Feature: Free CRM Deal Creation 

@TestTest
Scenario: Create a new deal scenario

Given User is already on login page
When Title of Login page is CMR
Then User Enter UserName and Password fields from data table
| ajay24789@gmail.com | Ajay4444 |
Then User Clicks on login button
And User is on Home page
Then User Mouse Hover and Clicks on Deal Tab
Then Verify the Deal page is loaded
Then User Clicks on Create New Button Deal
Then Enter Title and Description and Probability and Amount from data table
| Test Deal | Description for Test Deal | 50 | 2500 |
Then Click on Save Deal Button
Then User Mouse Hover and Clicks on Deal Tab
Then Verify the New Deal created with Title and Amount from data table
| Test Deal | 2500 |
And User Logout from CRM Application