@Graph
Feature: Navigation and interaction in dsAlgo Portal - Graph Section

  Background:
    Given The user logs into dsAlgo Portal with username "TestNinja" and password "C5Mha6FkdSAVEN@"
    And The user should be on the Home Dashboard

  Scenario: Open Graph main page from Home
    When The user selects the Get Started option under the Graph section
    Then The Graph main page should appear
    Then  The user chooses the Graph Topic link
    Then The Graph Topic information page should load
    Then  The user selects the Try Editor button on Graph Topic page
    Then The Try Editor page for Graph Topic should display with a Run option

  Scenario Outline: Validate alert handling for invalid input on Graph Topic Try Editor
    When The user selects the Get Started option under the Graph section
    Then The Graph main page should appear
    Then  The user chooses the Graph Topic link
    Then The Graph Topic information page should load
    Then  The user selects the Try Editor button on Graph Topic page
    Then The Try Editor page for Graph Topic should display with a Run option
    When The user is on the Try Editor page for Graph Topic
    And The user enters "<graphInput>" into the editor and clicks Run
    Then An alert message should be shown for Graph Topic invalid execution

    Examples:
      | graphInput |
      |            |
      | hi         |



  Scenario: Launch Graph Representations page
    When The user selects the Get Started option under the Graph section
    Then The user chooses the Graph Representations link
    Then The Graph Representations information page should load
    Then The user selects the Try Editor button on Graph Representations page
    Then The Try Editor page for Graph Representations should display with a Run option

  Scenario Outline: Validate alert handling for invalid input on Graph Representations Try Editor
    When The user is on the Try Editor page for Graph Representations
    And The user enters "<graphRepInput>" into the editor and clicks Run
    Then An alert message should be shown for Graph Representations invalid execution

    Examples:
      | graphRepInput |
      |               |
      | hi            |


