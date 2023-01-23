package booking.api;

import Utils.ApiUrlProvider;
import Utils.CreatePayload;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BookingApi {

    public static String BOOKING_API_URL = ApiUrlProvider.getBookingApiUrl();
    private static final String MEDIA_TYPE_JSON = "application/json";

    public static Response createToken() {
        return RestAssured.given()
                .log().all()
                .contentType(ContentType.JSON)
                .relaxedHTTPSValidation()
                .when()
                .body(CreatePayload.createAuthPayload())
                .post(ApiUrlProvider.getAuthApiUrl());
    }

    public static Response createBooking() {
        return RestAssured.given()
                .log().all().relaxedHTTPSValidation()
                .contentType(ContentType.JSON)
                .accept(MEDIA_TYPE_JSON)
                .when()
                .body(CreatePayload.createBookingPayload())
                .post(BOOKING_API_URL);
    }

    public static Response partialUpdateBooking(String bookingId, String authToken, String parameter, String value) {
        String urlPartialUpdate = BOOKING_API_URL + "/" + bookingId;
        String cookie = "token=" + authToken;
        return RestAssured.given()
                .log().all().relaxedHTTPSValidation()
                .contentType(ContentType.JSON)
                .accept(MEDIA_TYPE_JSON)
                .header("Cookie", cookie)
                .when()
                .body(CreatePayload.partialUpdateBookingPayload(parameter, value))
                .patch(urlPartialUpdate);
    }

    public static Response partialUpdateBookingDates(String bookingId, String authToken) {
        String urlPartialUpdate = BOOKING_API_URL + "/" + bookingId;
        String cookie = "token=" + authToken;
        return RestAssured.given()
                .log().all().relaxedHTTPSValidation()
                .contentType(ContentType.JSON)
                .accept(MEDIA_TYPE_JSON)
                .header("Cookie", cookie)
                .when()
                .body(CreatePayload.partialUpdateBookingPayloadDates())
                .patch(urlPartialUpdate);
    }

    public static Response getBooking(String bookingId) {
        String urlGetBooking = BOOKING_API_URL + "/" + bookingId;
        return RestAssured.given()
                .log().all().relaxedHTTPSValidation()
                .accept(MEDIA_TYPE_JSON)
                .when()
                .get(urlGetBooking);
    }

    public static Response deleteBooking(String bookingId, String authToken) {
        String urlDeleteBooking = BOOKING_API_URL + "/" + bookingId;
        String cookie = "token=" + authToken;
        return RestAssured.given()
                .log().all().relaxedHTTPSValidation()
                .accept(MEDIA_TYPE_JSON)
                .header("Cookie", cookie)
                .when()
                .delete(urlDeleteBooking);
    }

    public static Response getAllBookingIds() {
        return RestAssured.given()
                .log().all().relaxedHTTPSValidation()
                .when()
                .get(BOOKING_API_URL);
    }

    public static Response getAllBookingIdsByFirstName() {
        return RestAssured.given()
                .log().all().relaxedHTTPSValidation()
                .queryParam("firstname", "Mayur")
                .when()
                .get(BOOKING_API_URL);
    }

    public static Response getAllBookingIdsByName() {
        return RestAssured.given()
                .log().all().relaxedHTTPSValidation()
                .queryParam("firstname", "Mayur")
                .queryParam("lastname", "Sharma")
                .when()
                .get(BOOKING_API_URL);
    }

    public static Response getAllBookingIdsByCheckinDate() {
        return RestAssured.given()
                .log().all().relaxedHTTPSValidation()
                .queryParam("checkin", "1990-06-12")
                .when()
                .get(BOOKING_API_URL);
    }

}
