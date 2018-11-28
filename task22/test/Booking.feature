Feature: Test BookingPage

 Scenario Outline: Test check hotel availability
    Given I am on main booking page
    When I perform search hotel in  "<city>" with room "<countRoom>" and adults "<countAdults>"
    Then I see a list of hotels that match the parameters
    Examples:
            | city   | countRoom  |countAdults|
            | Moscow |      1     |     2     |
            | Paris  |      2     |     4     |

 Scenario Outline: Test search hotel with expected rating
    Given I am on main booking page
    When I perform search hotel in  "<city>" with room "<countRoom>" and adults "<countAdults>"
    When I sort list of hotel by rating and get first hotel
    Then I see the best hotel with expected "<rating>"
    Examples:
            | city   | countRoom  |countAdults|  rating |
            | Moscow |      1     |     2     |    9    |
            | Paris  |      2     |     4     |    8    |