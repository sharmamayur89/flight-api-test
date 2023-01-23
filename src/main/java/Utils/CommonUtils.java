package Utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CommonUtils {

    private static final Map<String, Response> responseMap = new HashMap<>();

    public static Response getresponseMap(String key) {
        return responseMap.get(key);
    }

    public static void setresponseMap(String key, Response response) {
        responseMap.put(key, response);
    }

    public static String getValueFromResponse(Response response, String key) {
        JsonPath jsonPathEvaluator = response.jsonPath();
        Object obj = jsonPathEvaluator.get(key);
        return (obj != null) ? obj.toString() : null;
    }

    public static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(new Date());
    }

}
