package Utils;

public class ApiUrlProvider {

    private static final String baseUri = BaseUrl.BookingBaseUri;
    private static final String auth_endpoint = GetConfigFiles.readConfig().getProperty("auth_endpoint");
    private static final String booking_endpoint = GetConfigFiles.readConfig().getProperty("booking_endpoint");

    public static String getBaseUri() {
        return baseUri;
    }

    public static String getAuthApiUrl() {
        return baseUri + auth_endpoint;
    }

    public static String getBookingApiUrl() {
        return baseUri + booking_endpoint;
    }
}
