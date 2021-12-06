package util;

import java.io.InputStream;
import java.util.Properties;

public class SystemProperties {

    private static final SystemProperties loader = new SystemProperties();
    private Properties properties;

    public SystemProperties() {
        getSystemProperties();
    }

    public static SystemProperties getInstance() {
        return loader;
    }

    private void getSystemProperties() {

        String fileName = "config.properties";
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName)) {
            this.properties = new Properties();

            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

}
