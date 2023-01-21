package Utils;

public class ApiUrlProvider {

    private static final String booking_endpoint = GetConfigFiles.readConfig().getProperty("endpoint");

    public static String getApiUrl(){
        String baseUri = BaseUrl.Base_Uri;
        String url = baseUri + booking_endpoint;
        System.out.println("\n Booking API URL: " + url);
        return url;
    }
}
