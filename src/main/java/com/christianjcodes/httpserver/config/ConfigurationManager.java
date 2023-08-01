package com.christianjcodes.httpserver.config;

import com.christianjcodes.httpserver.util.Json;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConfigurationManager {

    private static ConfigurationManager myConfigurationManager;
    private static Configuration myCurrentConfiguration;

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
    public void loadConfigurationFile(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        StringBuffer sb = new StringBuffer();
        int i;
        while ( (i = fileReader.read()) != -1) {
            sb.append((char)i);
        }

        JsonNode conf = Json.parse(sb.toString());
        myCurrentConfiguration = Json.fromJson(conf, Configuration.class);
    }

    /**
     * Returns the current loaded Configuration
     */
    public Configuration getCurrentConfiguration() {
        if (myCurrentConfiguration == null) {
            throw new HttpConfigurationException("No Current Configuration Set.");
        }
        return myCurrentConfiguration;
    }
}
