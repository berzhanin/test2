Feature: Tests mail page

  Scenario: Test move letter to spam
    Given I am on mail page
    When I move the first letter in spam
    Then I see valid message about moving to spam

  Scenario: Test extract letter to spam
    Given I go to the spam folder
    When I extract the first letter in spam
    Then I see valid message about extract to spam

  Scenario: Test send letters
    Given I send letter
    Then I see valid message about send message

  Scenario: Test mark flag letters
    Given I go to the incoming folder
    When  I mark flag of first three letters
    Then  I see mark flag on letters

  Scenario: Test deselect all flags
    Given I go to the incoming folder
    When  I remove all flag on letters
    Then  I not see mark flag on letters