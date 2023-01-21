@Regression
Feature: API Automation
  I want to test booking APIs

  Scenario Outline: Call booking API
    Given I get all booking IDs
#    Given I create a <UserType> user

    Examples:
      |UserType |
      |SBA		|

