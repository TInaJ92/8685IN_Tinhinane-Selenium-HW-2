package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Config {

    private static final File propertiesFile = new File(System.getProperty("user.dir") + File.separator + "src"
            + File.separator + "main" + File.separator + "resources" + File.separator + "config" + File.separator
            + "config.properties");
    private static Properties properties;
    public String appURL;
    public String appHost;
    public String appUser;
    public String appPassword;
    public long explicitTimeoutSeconds;
    public long fluentTimeoutSeconds;
    public long pollingIntervalMs;

    public Config() {
        try {
            properties = loadProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.appURL = properties.getProperty("app_url");
        this.appHost = properties.getProperty("app_host");
        this.appUser = properties.getProperty("app_user");
        this.appPassword = properties.getProperty("app_password");
        this.explicitTimeoutSeconds = Long.parseLong(properties.getProperty("explicit_timeout_seconds"));
        this.fluentTimeoutSeconds = Long.parseLong(properties.getProperty("fluent_timeout_seconds"));
        this.pollingIntervalMs = Long.parseLong(properties.getProperty("polling_interval_ms"));

    }

    private Properties loadProperties() throws IOException {
        Properties prop = new Properties();

        try (FileInputStream fis = new FileInputStream(propertiesFile)) {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }

}
