Feature: Select All the Radio Button 

Scenario: Select the Rodio Buttons 
Given User is on Practice page
When User Selects the Radio button and Verify the button is selected
Then Close Browser Window

Scenario: Select the Rodio Buttons 
Given User is on Practice page
When User Selects the options from Dropdown
Then Close Browser Window

@SmokeTest
Scenario: Select the Rodio Buttons 
Given User is on Practice page
When User Multi Selects the options from Dropdown
Then Close Browser Window