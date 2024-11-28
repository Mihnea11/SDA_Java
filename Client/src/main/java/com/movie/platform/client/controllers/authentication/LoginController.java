package com.movie.platform.client.controllers.authentication;

import com.movie.platform.client.MainApp;
import com.movie.platform.client.services.AuthenticationService;
import com.movie.platform.client.utility.ServiceResponse;
import com.sun.tools.javac.Main;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    private final AuthenticationService authService = new AuthenticationService();

    @FXML
    public void onLogin() {
        String email = emailField.getText();
        String password = passwordField.getText();

        if (email.isEmpty() || password.isEmpty()) {
            errorLabel.setText("Both email and password are required.");
            return;
        }

        Task<ServiceResponse> loginTask = new Task<>() {
            @Override
            protected ServiceResponse call() throws Exception {
                return authService.login(email, password);
            }

            @Override
            protected void succeeded() {
                ServiceResponse response = getValue();
                if (response.getStatusCode() == 200) {
                    errorLabel.setText("");
                    System.out.println("Navigate to the dashboard...");
                } else if (response.getStatusCode() == 401) {
                    errorLabel.setText("Invalid email or password.");
                } else {
                    errorLabel.setText("Error: " + response.getMessage());
                }
            }

            @Override
            protected void failed() {
                Throwable error = getException();
                errorLabel.setText("An error occurred: " + error.getMessage());
                error.printStackTrace();
            }
        };

        new Thread(loginTask).start();
    }


    @FXML
    public void onRegister() {
        try {
            MainApp.switchView("views/register-view.fxml");
        } catch (IOException e) {
            errorLabel.setText("Failed to load the register view.");
        }
    }
}