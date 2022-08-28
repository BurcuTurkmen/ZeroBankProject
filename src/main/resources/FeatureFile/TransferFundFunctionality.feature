Feature: Transfer Fund

  Scenario Outline: Transfer Fund Functionality in ZeroBank
    Given User navigate to ZeroBank2 website
    When  User login to ZeroBank2 with valid username2 and password2
    Then  User click on OnlineBanking2
    And   User go to TransferFund tab
    Then  User should select from account
    And   User should select to account
    Then  User should enter "<Amount>"
    And   User should fill the "<Description>"
    Then  User should click continue button
    Then  User should click submit button
    Then  User should see success text

    Examples:
    | Amount | Description         |
    | 500    | Credit card payment |





