package com.christianjcodes.httpserver.http;

import java.util.regex.Pattern;

public enum HttpVersion {
    HTTP_1_1("HTTP/1.1", 1, 1);

    public final String LITERAL;
    public final int MAJOR;
    public final int MINOR;

    HttpVersion(String LITERAL, int MAJOR, int MINOR) {
        this.LITERAL = LITERAL;
        this.MAJOR = MAJOR;
        this.MINOR = MINOR;
    }

    public static final Pattern httpVerionRegexPattern = Pattern.compile("^HTTP/(?<major>\\d+).(?<minor>\\d+)");

    public static HttpVersion getBestCompatibleVersion(String literalVersion) {

    }
}
