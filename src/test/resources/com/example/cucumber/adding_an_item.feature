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
@addItem
Feature: Adding an item to order
  I want to be able to add an item to a current order.

  @empty
  Scenario: Adding an item to an empty order
    Given I have not yet ordered anything
    When I go to the "Burgers" category
    And I select a "Cheeseburger"
    Then I have a new order
    And the order has 1 item in it

  @price
  Scenario Outline: Price of a single item order
    Given I have not yet ordered anything
    When I go to the "<category>" category
    And I select <item>
    Then my current order total is <price>

    Examples: 
      | category   | item                 | price |
      | Sandwiches | a "Chicken Sandwich" | $9    |
      | Dessert    | an "Oreo Cheesecake" | $7    |

