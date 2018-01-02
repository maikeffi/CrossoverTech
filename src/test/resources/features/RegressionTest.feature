@JobSearch
Feature: Test Job Search Feature in CrossOver
  Background: Open browser
    Given I open chrome browser

  @JobSearch-001
  Scenario:  Test home Page Works
    When I enter Url for CrossOver Home in the browser
    Then CrossOver Home Should Open