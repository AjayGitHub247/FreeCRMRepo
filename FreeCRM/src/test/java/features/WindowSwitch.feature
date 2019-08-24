Feature: Windows Switch Feature

Scenario: Test Windwos Switch 

Given User is on Practice page
When User Clicks on Open Wnidow button 
Then Verify Two Windows Opened  


Scenario: Test iFrame Switch 

Given User is on Practice page
When Scroll to iFrame section
Then Performs action on Frame
Then Scroll to Name Textbox and Type


Scenario: Test Switch to alert 

Given User is on Practice page
When Scroll to Switch alert button section
Then Work with Alert and Confirm Popups  