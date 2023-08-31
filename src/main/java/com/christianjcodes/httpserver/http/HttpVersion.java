package com.christianjcodes.httpserver.http;

import java.util.regex.Matcher;
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

    public static HttpVersion getBestCompatibleVersion(String literalVersion) throws HttpParsingException {
        Matcher matcher = httpVerionRegexPattern.matcher(literalVersion);
        if (!matcher.find() || matcher.groupCount() != 2) {
            //TODO check if this is the exception we want to send
            throw new HttpParsingException(HttpStatusCode.SERVER_ERROR_500_INTERNAL_SERVER_ERROR);
        }
    }
}
