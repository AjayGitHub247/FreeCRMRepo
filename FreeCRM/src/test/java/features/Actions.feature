Feature: Action Feature

Scenario: Verify the action test  

Given User is on Practice page
Then Scroll to Mouse Hover Label
Then Mouse Hover on button and Click on Top  

Scenario: Verify the Drag and Drop test  

Given User is on jquery Drag and Drop page
Then Perform Drag and Drop operation


Scenario: Verify the slider test  

Given User is on jquery slider page
Then Perform slide operation

Scenario: Verify the key press test   

Given User is on Practice page
When User Navigate to Login page
Then User Enters Invalid User ID and Password
And User Press Enter Key
Then User Verify the error message


Scenario: Verify the combination key press test   

Given User is on Practice page
Then User Press select all shortcut key 

@Smoke
Scenario: Verify the combination key press using action   

Given User is on Practice page
Then User Press select all shortcut key using Actions


