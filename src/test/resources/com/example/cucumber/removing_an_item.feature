#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@removeItem
Feature: Removing an item from order
  I want to be able to remove an item from a current order.

  @empty
  Scenario: Removing an item from an empty order
    Given I have not yet ordered anything
    When I remove the item "Cheeseburger"
    Then the order remains empty


  @empty
  Scenario: Removing an item from an empty order
    Given I have a current order
    And it already contains a "Chicken Sandwich"
    And it already contains a "Oreo Cheesecake"
    When I remove the item "Oreo Cheesecake"
    Then the order contains "Chicken Sandwich"
    But the order does not contain "Oreo Cheesecake"
    And my current order total is $9
