#language: en

Feature: API consumption tests
  I as the Automator
  I want to perform the API consumptions
  To obtain the expected results in each type of consumption.

  Background: Define Own Preconditions for all scenarios.
    Given 'User' performs the consumption of the base url 'https://petstore.swagger.io/v2'

  Scenario: Creating a user
    When a user is created with the following characteristics
      | Id         | 2                  |
      | User name  | cindyprueba        |
      | First name | pruebacindy        |
      | Last name  | apellidopure       |
      | email      | cindymrv@gmail.com |
      | password   | pass123            |
      | phone      | 311002             |
      | status     | 0                  |
    Then the service should answer me with a status code 200
    And when querying the username 'cindytest' of the previously created user
    Then the service should answer me with a status code 200


  Scenario: Update user's name and email address
    When you update the user's name and email with the following characteristics
      | Id         | 2                   |
      | User name  | cindyprueba         |
      | First name | pruebaactua         |
      | Last name  | apellidopure        |
      | email      | cindymrv2@gmail.com |
      | password   | pass123             |
      | phone      | 311002              |
      | status     | 0                   |
    Then the service should answer me with a status code 200


