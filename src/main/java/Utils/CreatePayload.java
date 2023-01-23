package Utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class CreatePayload {

    public static Map<String, Object> createAuthPayload() {
        Map<String, Object> parentObject = new LinkedHashMap<>();
        parentObject.put("username", "admin");
        parentObject.put("password", "password123");
        return parentObject;
    }

    public static Map<String, Object> createBookingPayload() {
        Map<String, Object> parentObject = new LinkedHashMap<>();
        parentObject.put("firstname", "Mayur");
        parentObject.put("lastname", "Sharma");
        parentObject.put("totalprice", "100");
        parentObject.put("depositpaid", true);

        Map<String, Object> dates = new LinkedHashMap<>();
        dates.put("checkin", "1990-06-12");
        dates.put("checkout", "1991-01-01");
        parentObject.put("bookingdates", dates);
        parentObject.put("additionalneeds", "Dinner");
        return parentObject;
    }

    public static Map<String, Object> partialUpdateBookingPayload(String parameter, String value) {
        Map<String, Object> parentObject = new LinkedHashMap<>();
        if (parameter.equals("depositpaid")) {
            parentObject.put(parameter, Boolean.parseBoolean(value));
        } else
            parentObject.put(parameter, value);
        return parentObject;
    }

    public static Map<String, Object> partialUpdateBookingPayloadDates() {
        Map<String, Object> parentObject = new LinkedHashMap<>();
        Map<String, Object> dates = new LinkedHashMap<>();
        dates.put("checkin", CommonUtils.getCurrentDate());
        dates.put("checkout", CommonUtils.getCurrentDate());
        parentObject.put("bookingdates", dates);
        return parentObject;
    }

    public static Map<String, Object> createBookingPayloadCurrentDates() {
        Map<String, Object> parentObject = new LinkedHashMap<>();
        parentObject.put("firstname", "Mayur");
        parentObject.put("lastname", "Sharma");
        parentObject.put("totalprice", "100");
        parentObject.put("depositpaid", true);

        Map<String, Object> dates = new LinkedHashMap<>();
        dates.put("checkin", CommonUtils.getCurrentDate());
        dates.put("checkout", CommonUtils.getCurrentDate());
        parentObject.put("bookingdates", dates);
        parentObject.put("additionalneeds", "Dinner");
        return parentObject;
    }


}
