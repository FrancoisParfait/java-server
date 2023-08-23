package com.christianjcodes.httpserver.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class HttpParser {

    private final static Logger LOGGER = LoggerFactory.getLogger(HttpParser.class);

    public HttpRequest parseHttpRequest(InputStream inputStream) {
        InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.US_ASCII);

        HttpRequest request = new HttpRequest();

        parseRequestLine(inputStream, request);
        parseHeaders(inputStream, request);
        parseBody(inputStream, request);

        return request;
    }

    private void parseBody(InputStream inputStream, HttpRequest request) {

    }

    private void parseHeaders(InputStream inputStream, HttpRequest request) {

    }

    private void parseRequestLine(InputStream inputStream, HttpRequest request) {

    }

}
