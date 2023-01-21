package booking.api;

import Utils.ApiUrlProvider;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BookingApi {

    public static String api_url = ApiUrlProvider.getApiUrl();

    public static Response getAllBookingIds(){
        return RestAssured.given().relaxedHTTPSValidation().when().get(api_url);
    }



}
