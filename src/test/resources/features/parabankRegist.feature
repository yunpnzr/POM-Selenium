@All
  Feature: Para Bank Registration

    @positive @register
    Scenario: Success Register
      Given User in on Parabank home page
      When User click register link button
      Then User is in register page
      When User input name
      And User input address detail
      And User fill valid username and password
      And User input password confirmation
      When User click register button
      Then User register successfully

    @negative @register
    Scenario: Failed Register - Missmatch Password
      Given User in on Parabank home page
      When User click register link button
      Then User is in register page
      When User input name
      And User input address detail
      And User fill valid username and password
      And User input password confirmation
      And User input invalid password confirmation
      When User click register button
      Then User get error password did not match