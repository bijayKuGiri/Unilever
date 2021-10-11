Feature: Verifying Article page redirection

Scenario: Verifying Article page redirection
Given The site is Up and Running
When i try to click on article image
Then the page should redirect to Article page