Feature: New Payee Functionality

  Scenario Outline: Add New Payee Functionality in ZeroBank
    Given navigate to ZeroBank website
    When User login to ZeroBank with valid username and password
    Then User click on OnlineBanking
    Then User go to PayBills tab
    And  User go to AddNewPayee tab
    Then User should add "<Payee Name>"
    And User should fill "<Payee Address>", "<Account>", "<Payee Details>"
    Then  User click on Add Button
    Then Result should be "<Result>"

    Examples:
    | Payee Name | Payee Address | Account | Payee Details | Result       |
    | Xfinity    | Golf Rd       | 9876543 | Internet      | successful   |
    | NorthShore |               | 1234567 | Gas           | unsuccessful |
    | T-Mobile   | Town Rd       |         | Mobile        | unsuccessful |




