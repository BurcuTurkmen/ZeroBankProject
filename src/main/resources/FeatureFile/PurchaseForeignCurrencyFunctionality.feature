Feature: Foreign Currency Functionality

  Scenario Outline: Purchase Foreign Currency Functionality in ZeroBank
    Given User navigate to ZeroBank1 website
    When  User login to ZeroBank1 with valid username1 and password1
    Then  User click on OnlineBanking1
    And   User go to PayBills1 tab
    Then  User click on PurchaseForeignCurrencyTab
    Then  User should select currency type
    Then  User should enter the "<Amount>"
    Then  User should select the calculation currency
    When  User click on calculate cost button
    Then  User should see the conversion amount
    And   User click on purchase button
    Then  User should see confirmation message


    Examples:
    | Amount |
    | 100    |













