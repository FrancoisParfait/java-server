package com.christianjcodes.httpserver.http;

public enum HttpStatusCodes {

    CLIENT_ERROR_400_BAD_REQUEST(400, "Bad Request");

    public final int STATUS_CODE;
    public final String MESSAGE;

    HttpStatusCodes(int STATUS_CODE, String MESSAGE) {
        this.STATUS_CODE = STATUS_CODE;
        this.MESSAGE = MESSAGE;
    }
}
