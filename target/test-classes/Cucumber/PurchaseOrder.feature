@tag
Feature:  Purchse the order from Ecommerce WebSite
	I want to use this template for my feature file

Background:
Given I landed on Ecommerce Page

@tag2
Scenario Outline: Positive Test of Submitting the Order

	Given Logged in with username <name> and password <password>
	When I add Product <product name> to cart
	And Checkout <product name> and submit the order
	Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage
	
	Examples:
      | name  						| password   	|
      | mruthyunjaya3t@gmail.com   	| Ashu@1994    	|
      
    