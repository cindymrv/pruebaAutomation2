#language: en

Feature: Product purchase flow test
  I as a user
  I want to select products
  To be able to buy them

  Background: Add two products to cart
  Given the 'user' is located on the opencart website
    When the user adds products to the cart
    Then the user can view 2 products in the cart


  Scenario: Buying products that are in the shopping cart
    When you checkout as a guest
    Then the user must be able to view the purchase confirmation.







