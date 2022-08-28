Feature: New Payee Functionality

  Scenario Outline: Add New Payee Functionality in ZeroBank
    Given navigate to ZeroBank website
    When User login to ZeroBank with valid username and password
    Then User click on OnlineBanking
    Then User go to PayBills tab
    And  User go to AddNewPayee tab
    Then User should add "<Payee Name>"
    Then User should fill "<Payee Address>", "<Account>", "<Payee Details>"
    And  User click on Add Button
    Then User should see success message

    Examples:
    | Payee Name | Payee Address | Account | Payee Details |
    | Xfinity    | Golf Rd       | 9876543 | Internet      |




