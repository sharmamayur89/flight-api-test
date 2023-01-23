package api.steps;

import Utils.CreatePayload;
import booking.api.BookingApi;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Objects;

import static Utils.CommonUtils.*;
import static org.apache.http.HttpStatus.*;
import static org.junit.Assert.*;

public class BookingSteps {

    private String authToken, bookingId;

    @Given("I call auth api for creating token")
    public void i_call_auth_api_for_creating_token() {
        setresponseMap("createTokenResponse", BookingApi.createToken());
        assertEquals("Create Token API status code assertion failure", SC_OK, getresponseMap("createTokenResponse").statusCode());
    }

    @Given("I retrieve token from response")
    public void i_retrieve_token_from_response() {
        authToken = getValueFromResponse(getresponseMap("createTokenResponse"), "token");
    }

    @Given("I create a booking by calling the CreateBooking API")
    public void i_create_a_booking_by_calling_the_create_booking_api() {
        setresponseMap("CreateBookingResponse", BookingApi.createBooking());
        assertEquals("Create Booking API status code assertion failure", SC_OK, getresponseMap("CreateBookingResponse").statusCode());
    }

    @Given("I retrieve the booking ID from CreateBooking response")
    public void i_retrieve_the_booking_id_from_create_booking_response() {
        bookingId = getValueFromResponse(getresponseMap("CreateBookingResponse"), "bookingid");
        System.out.println("BOOKING ID : " + bookingId);
    }

    @When("^I update current booking by calling the UpdateBooking API with (.*) as (.*)$")
    public void iUpdateCurrentBookingByCallingTheUpdateBookingAPIWithParameterAsValue(String parameter, String value) {
        setresponseMap("UpdateBookingResponse", BookingApi.partialUpdateBooking(bookingId, authToken, parameter, value));
        assertEquals("UpdateBooking API status code assertion failure", SC_OK, getresponseMap("UpdateBookingResponse").statusCode());
    }

    @When("I update booking dates by calling UpdateBooking API")
    public void iUpdateBookingDates() {
        setresponseMap("PartialUpdateBookingDatesResponse", BookingApi.partialUpdateBookingDates(bookingId, authToken));
        assertEquals("UpdateBooking API status code assertion failure", SC_OK, getresponseMap("PartialUpdateBookingDatesResponse").statusCode());
    }

    @Then("I verify the booking has been updated by calling GetBooking API")
    public void i_verify_the_booking_has_been_updated_by_calling_get_booking_api() {
        setresponseMap("GetBookingResponse", BookingApi.getBooking(bookingId));
        assertEquals("GetBooking API status code assertion failure", SC_OK, getresponseMap("GetBookingResponse").statusCode());
    }

    @Then("^Key (.*) should have been updated with (.*) value$")
    public void i_verify_key_is_updated(String key, String value) {
        assertEquals("Booking was not updated", value, getValueFromResponse(getresponseMap("GetBookingResponse"), key));
    }

    @And("Booking should have been updated with new dates")
    public void bookingShouldHaveBeenUpdatedWithNewDates() {
        assertEquals("Booking Dates were not updated", getCurrentDate(), getValueFromResponse(getresponseMap("GetBookingResponse"), "bookingdates.checkin"));
        assertEquals("Booking Dates were not updated", getCurrentDate(), getValueFromResponse(getresponseMap("GetBookingResponse"), "bookingdates.checkout"));
    }

    @And("Verify other fields in booking remain unchanged")
    public void verifyOtherFieldsInBookingRemainUnchanged() {
        assertEquals("Actual payload not matching with expected after partial update", CreatePayload.createBookingPayloadCurrentDates().toString(), getValueFromResponse(getresponseMap("GetBookingResponse"), ""));
    }

    @Then("I verify the booking has been created by calling GetBooking API")
    public void i_verify_the_booking_has_been_created_by_calling_get_booking_api() {
        setresponseMap("GetCreatedBookingResponse", BookingApi.getBooking(bookingId));
        assertEquals("GetBooking API status code assertion failure", SC_OK, getresponseMap("GetCreatedBookingResponse").statusCode());
    }

    @When("I delete the booking by calling DeleteBooking API")
    public void iDeleteTheBookingDatesByCallingDeleteBookingAPI() {
        setresponseMap("DeleteBookingResponse", BookingApi.deleteBooking(bookingId, authToken));
        assertEquals("DeleteBooking API status code assertion failure", SC_CREATED, getresponseMap("DeleteBookingResponse").statusCode());
    }

    @Then("I verify the booking has been deleted by calling GetBooking API")
    public void i_verify_the_booking_has_been_deleted_by_calling_get_booking_api() {
        setresponseMap("GetDeletedBookingResponse", BookingApi.getBooking(bookingId));
        assertEquals("GetBooking API status code assertion failure", SC_NOT_FOUND, getresponseMap("GetDeletedBookingResponse").statusCode());
    }

    @Given("I am able to make a call to GetBookingIds API")
    public void i_am_able_to_make_a_call_to_get_booking_ids_api() {
        setresponseMap("getBookingIdsResponse", BookingApi.getAllBookingIds());
        assertEquals("GetBookingIds API status code assertion failure", SC_OK, getresponseMap("getBookingIdsResponse").statusCode());
    }

    @Given("I am able to make a call to GetBookingIds API by firstname")
    public void i_am_able_to_make_a_call_to_get_booking_ids_apiByFirstName() {
        setresponseMap("getBookingIdsResponse", BookingApi.getAllBookingIdsByName());
        assertEquals("GetBookingIds API status code assertion failure", SC_OK, getresponseMap("getBookingIdsResponse").statusCode());
    }

    @Given("I am able to make a call to GetBookingIds API by firstname and lastname")
    public void i_am_able_to_make_a_call_to_get_booking_ids_apiByFullName() {
        setresponseMap("getBookingIdsResponse", BookingApi.getAllBookingIdsByName());
        assertEquals("GetBookingIds API status code assertion failure", SC_OK, getresponseMap("getBookingIdsResponse").statusCode());
    }

    @Given("I am able to make a call to GetBookingIds API by checkin date")
    public void i_am_able_to_make_a_call_to_get_booking_ids_apiByDate() {
        setresponseMap("getBookingIdsResponse", BookingApi.getAllBookingIdsByCheckinDate());
        assertEquals("GetBookingIds API status code assertion failure", SC_OK, getresponseMap("getBookingIdsResponse").statusCode());
    }

    //    @Test
    @Given("Response body contains valid response from GetBookingIds")
    public void response_body_contains_valid_response() {
        assertFalse("GetBookingIds API response is empty", getresponseMap("getBookingIdsResponse").body().asString().isEmpty());
    }

    @Then("I verify booking ID in response from GetBookingIds")
    public void iVerifyBookingIDInResponseFromGetBookingIds() {
        assertTrue("Booking ID not present in Response", Objects.requireNonNull(getValueFromResponse(getresponseMap("getBookingIdsResponse"), "bookingid")).contains(bookingId));
    }
}