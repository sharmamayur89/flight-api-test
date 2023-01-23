package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GetConfigFiles {

    public static String currentPath = System.getProperty("user.dir");

    public static Properties readConfig() {
        Properties configProperty = null;
        try {
            String configFilePath = currentPath
                    + "/src/main/resources/config.properties";
            FileInputStream config = new FileInputStream(configFilePath);
            configProperty = new Properties();
            try {
                configProperty.load(config);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return configProperty;
    }

}
