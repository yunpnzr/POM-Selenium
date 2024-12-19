@All
  Feature: Para Bank Registration

    @positive @register
    Scenario Outline: Register
      Given User in on Parabank home page
      When User click register link button
      Then User is in register page
      When User input <firstName> and <lastName>
      And User input address detail like <address>, <city>, <state>, <zip>, <phone>, <ssn>
      And User fill valid <username> and <password>
      And User input password confirmation <repeatPassword>
      When User click register button
      Then User register <status>

      Examples:
        | firstName | lastName | address | city | state | zip | phone | ssn | username | password | repeatPassword | status |
        | John | Doe | 123 Main St | New York | NY | 12345 | 111-11-1111 | 123-45-6789 | johndoe05 | 123456 | 123456 | success |
        | John | Doe | 123 Main St | New York | NY | 12345 | 111-11-1111 | 123-45-6789 | johndoe06 | 123456 | 123456 | success |
        | John | Doe | 123 Main St | New York | NY | 12345 | 111-11-1111 | 123-45-6789 | johndoe05 | 123456 | 123456 | failed |
        | John | Doe | 123 Main St | New York | NY | 12345 | 111-11-1111 | 123-45-6789 | johndoe06 | 123456 | 123456 | failed |

    @negative @register
    Scenario Outline: Failed Register - Missmatch Password
      Given User in on Parabank home page
      When User click register link button
      Then User is in register page
      When User input <firstName> and <lastName>
      And User input address detail like <address>, <city>, <state>, <zip>, <phone>, <ssn>
      And User fill valid <username> and <password>
      And User input invalid password confirmation <repeatPassword>
      When User click register button
      Then User get error password did not match

      Examples:
        | firstName | lastName | address | city | state | zip | phone | ssn | username | password | repeatPassword | status |
        | John | Doe | 123 Main St | New York | NY | 12345 | 111-11-1111 | 123-45-6789 | johndoe03 | 123456 | 1234567 | failed |
        | John | Doe | 123 Main St | New York | NY | 12345 | 111-11-1111 | 123-45-6789 | johndoe04 | 123456 | 1234567 | failed |