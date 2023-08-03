package com.christianjcodes.httpserver;

import com.christianjcodes.httpserver.config.Configuration;
import com.christianjcodes.httpserver.config.ConfigurationManager;
import com.christianjcodes.httpserver.core.ServerListenerThread;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * Driver Class for the Http Server
 *
 */

public class HttpServer {

    public static void main(String[] args) {

        System.out.println("Server starting...");

        ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/http.json");
        Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();

        System.out.println("Using Port: " + conf.getPort());
        System.out.println("Using WebRoot: " + conf.getWebroot());

        try {
            ServerListenerThread serverListenerThread = new ServerListenerThread(conf.getPort(), conf.getWebroot());
            serverListenerThread.start();
        } catch (IOException e) {
            e.printStackTrace();
            // TODO handle later.
        }
    }
}
