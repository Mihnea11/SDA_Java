package com.movie.platform.client.services;

import com.movie.platform.client.utility.ServiceResponse;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class AuthenticationService {

    private static final String BASE_URL = "http://localhost:8080/authentication";

    public ServiceResponse register(String username, String email, String password) throws IOException {
        URI uri = URI.create(BASE_URL + "/register");

        String jsonPayload = String.format("{\"username\":\"%s\", \"email\":\"%s\", \"password\":\"%s\"}",
                username, email, password);

        return sendPostRequest(uri, jsonPayload);
    }

    public ServiceResponse login(String email, String password) throws IOException {
        String queryParams = String.format("email=%s&password=%s",
                URLEncoder.encode(email, StandardCharsets.UTF_8),
                URLEncoder.encode(password, StandardCharsets.UTF_8));
        URI uri = URI.create(BASE_URL + "/login?" + queryParams);

        return sendGetRequest(uri);
    }

    private ServiceResponse sendPostRequest(URI uri, String jsonPayload) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonPayload.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        return handleResponse(connection);
    }

    private ServiceResponse sendGetRequest(URI uri) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
        connection.setRequestMethod("GET");

        return handleResponse(connection);
    }

    private ServiceResponse handleResponse(HttpURLConnection connection) throws IOException {
        int statusCode = connection.getResponseCode();
        String responseMessage = getResponseMessage(connection, statusCode);

        connection.disconnect();
        return new ServiceResponse(statusCode, responseMessage);
    }

    private String getResponseMessage(HttpURLConnection connection, int statusCode) throws IOException {
        InputStream stream = (statusCode >= 400) ? connection.getErrorStream() : connection.getInputStream();

        if (stream != null) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8))) {
                return readResponse(reader);
            }
        }
        return "No response message.";
    }

    private String readResponse(BufferedReader reader) throws IOException {
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line.trim());
        }
        return response.toString();
    }
}
