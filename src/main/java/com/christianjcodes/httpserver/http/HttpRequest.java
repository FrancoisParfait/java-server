package com.christianjcodes.httpserver.http;

public class HttpRequest extends HttpMessage {

    private HttpMethod method;
    private String requestTarget;
    private String httpVersion;

    HttpRequest() {

    }

    public HttpMethod getMethod() {
        return method;
    }

    void setMethod(HttpMethod methodName) {
        this.method = HttpMethod.valueOf(String.valueOf(methodName));
    }
}
