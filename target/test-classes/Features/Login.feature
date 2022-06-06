Feature: Sauce Labs Demo Login Test cases

  Scenario Outline: Login Page with valid credentials
    Given the user launches the application
    When the user is on login page
    Then the user enters "<username>" in username field
    Then the user enters "<password>" in password field
    And the user clicks on submit button
    Then the user in on home page

    Examples: 
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

  Scenario Outline: Login Page with Invalid Credentials
    Given the user launches the application
    When the user is on login page
    Then the user enters "<username>" in username field
    Then the user enters "<password>" in password field
    And the user clicks on submit button
    Then the user verifies "<errormessage>" is displayed

    Examples: 
      | username                | password         | errormessage                                                |
      | standard_user           | invalid_password | Username and password do not match any user in this service |
      | invalid_user            | secret_sauce     | Username and password do not match any user in this service |
      | invalid_user            | invalid_password | Username and password do not match any user in this service |
      | [blank]                 | secret_sauce     | Username is required                                        |
      | standard_user           | [blank]          | Password is required                                        |
      | locked_out_user         | secret_sauce     | Sorry, this user has been locked out                        |
      | locked_out_user         | invalid_password | Username and password do not match any user in this service |
      | locked_out_user         | [blank]          | Password is required                                        |
      | problem_user            | invalid_password | Username and password do not match any user in this service |
      | problem_user            | [blank]          | Password is required                                        |
      | performance_glitch_user | invalid_password | Username and password do not match any user in this service |
      | performance_glitch_user | [blank]          | Password is required                                        |
