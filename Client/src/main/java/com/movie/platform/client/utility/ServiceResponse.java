package com.movie.platform.client.utility;

public class ServiceResponse {
    private final int statusCode;
    private final String message;

    public ServiceResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}