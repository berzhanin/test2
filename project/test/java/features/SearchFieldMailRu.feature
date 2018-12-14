Feature: Tests search page

  Scenario: Test search text
    Given I am on main page
    When I enter text in search bar and click search button
    Then I see valid search result
