Feature: Free CRM Deal Creation 

@TestTest
Scenario: Create a new deal scenario with Maps

Given User is already on login page
When Title of Login page is CMR
Then User Enter UserName and Password fields with Maps
| UserName | Password |
| ajay24789@gmail.com | Ajay4444 |
Then User Clicks on login button
And User is on Home page
Then User Mouse Hover and Clicks on Deal Tab
Then Verify the Deal page is loaded
Then User Clicks on Create New Button Deal
Then Enter Title and Description and Probability and Amount with Maps
| Title | Description | Probability | Amount |
| Test Deal two | Description for Test Deal two | 40 | 3500 |
Then Click on Save Deal Button
Then User Mouse Hover and Clicks on Deal Tab
Then Verify the New Deal created with Title and Amount with Maps
| Title | Amount |
| Test Deal two | 3500 |
And User Logout from CRM Application



Scenario: Create Multiple deal scenario with Maps

Given User is already on login page
When Title of Login page is CMR
Then User Enter UserName and Password fields with Maps
| UserName | Password |
| ajay24789@gmail.com | Ajay4444 |
Then User Clicks on login button
And User is on Home page
Then Create a Multiple deals with Maps Data
| Title | Description | Probability | Amount |
| Test Deal one | Description for Test Deal one | 30 | 3000 |
| Test Deal two | Description for Test Deal two | 40 | 3500 |
| Test Deal three | Description for Test Deal three | 50 | 4000 |
| Test Deal four | Description for Test Deal four | 60 | 4500 |

Then User Mouse Hover and Clicks on Deal Tab
Then Verify the Deal page is loaded
Then User Clicks on Create New Button Deal
Then Enter Title and Description and Probability and Amount with Maps

Then Click on Save Deal Button
Then User Mouse Hover and Clicks on Deal Tab
Then Verify the New Deal created with Title and Amount with Maps
| Title | Amount |
| Test Deal two | 3500 |
And User Logout from CRM Application