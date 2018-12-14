Feature: Tests login page

  Scenario: Test positive login page
    Given I am on main application page
    When I login as correct user
    Then I see logout link

  Scenario Outline: Test negative login page
    Given I am on main application page
    When I login as user with "<testLogin>" and "<testPassword>"
    Then I see error message
    Examples:
      | testLogin | testPassword |
      | ddd.berzhanin  | A123456      |

  Scenario: Test positive logout
    Given I am on main application page
    When I login as correct user
    Then I see logout link
    When I click logout button
    Then I see main application page

  Scenario: Test image link
    Given I am on main application page
    When I click image link
    Then I see a block of images
