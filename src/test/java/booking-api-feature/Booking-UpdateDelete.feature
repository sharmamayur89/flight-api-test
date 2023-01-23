@Regression
Feature: Booking API Test
  I want to test booking APIs update and delete

  Background: Generate Auth Token
    Given I call auth api for creating token
    And I retrieve token from response

  Scenario Outline: Test PartialUpdate API by updating <Parameter>
    Given I create a booking by calling the CreateBooking API
    And I retrieve the booking ID from CreateBooking response
    When I update current booking by calling the UpdateBooking API with <Parameter> as <Value>
    Then I verify the booking has been updated by calling GetBooking API
    And Key <Parameter> should have been updated with <Value> value

    Examples:
      | Parameter       | Value      |
      | firstname       | UFIRSTNAME |
      | lastname        | ULASTNAME  |
      | totalprice      | 999        |
      | depositpaid     | false      |
      | additionalneeds | None       |

  Scenario: Test PartialUpdate API by updating dates
    Given I create a booking by calling the CreateBooking API
    And I retrieve the booking ID from CreateBooking response
    When I update booking dates by calling UpdateBooking API
    Then I verify the booking has been updated by calling GetBooking API
    And Booking should have been updated with new dates
    And Verify other fields in booking remain unchanged

  Scenario: Test DeleteUpdate API by deleting recently created booking
    Given I create a booking by calling the CreateBooking API
    And I retrieve the booking ID from CreateBooking response
    Then I verify the booking has been created by calling GetBooking API
    When I delete the booking by calling DeleteBooking API
    Then I verify the booking has been deleted by calling GetBooking API
