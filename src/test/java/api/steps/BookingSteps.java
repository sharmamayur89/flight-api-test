package api.steps;

import booking.api.BookingApi;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.apache.http.HttpStatus.SC_OK;


public class BookingSteps {

    @Test
    @Given("I get all booking IDs")
    public void i_get_all_booking_i_ds() {
        Response response = BookingApi.getAllBookingIds();
        System.out.println("********* RESPONSE ************ " + response.statusCode());
//        System.out.println("********* RESPONSE ************ " + response.body().asPrettyString());
        assertEquals("GetBookingIds API status code assetion failure", SC_OK, response.statusCode());
    }

//    public MyStepdefs() {
//        Given("^I get all booking IDs$", () -> {
//        });
//    }
}