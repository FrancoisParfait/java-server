package com.christianjcodes.httpserver.config;

public class ConfigurationManager {

    private static ConfigurationManager myConfigurationManager;

    private ConfigurationManager() {
    }

    public static ConfigurationManager getInstance() {
        if (myConfigurationManager == null) {
            myConfigurationManager = new ConfigurationManager();
        }
        return myConfigurationManager;
    }

    /**
     * Used to load a configuration file by the provided path
     */
    public void loadConfigurationFile(String filePath) {

    }

    /**
     * Returns the current loaded Configuration
     */
    public void getCurrentConfiguration() {

    }
}
