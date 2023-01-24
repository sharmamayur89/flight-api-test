@Regression
Feature: GetBookingIds API Tet
  I want to test GetBookingIds endpoint

  Scenario: Test GetBookingIds API without filter
    Given I am able to make a call to GetBookingIds API
    Then Response body contains valid response from GetBookingIds

  Scenario: Test GetBookingIds API filter by first name
    Given I create a booking by calling the CreateBooking API
    And I retrieve the booking ID from CreateBooking response
    When I am able to make a call to GetBookingIds API by firstname
    Then I verify booking ID in response from GetBookingIds
#
  Scenario: Test GetBookingIds API filter by first and last name
    Given I create a booking by calling the CreateBooking API
    And I retrieve the booking ID from CreateBooking response
    When I am able to make a call to GetBookingIds API by firstname and lastname
    Then I verify booking ID in response from GetBookingIds

  Scenario: Test GetBookingIds API filter by checkin date
    Given I create a booking by calling the CreateBooking API
    And I retrieve the booking ID from CreateBooking response
    When I am able to make a call to GetBookingIds API by checkin date
    Then Response body contains valid response from GetBookingIds