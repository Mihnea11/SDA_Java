package com.movie.platform.client.controllers.authentication;

import com.movie.platform.client.MainApp;
import com.movie.platform.client.services.AuthenticationService;
import com.movie.platform.client.utility.ServiceResponse;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RegisterController {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Label errorLabel;

    private final AuthenticationService authService = new AuthenticationService();

    @FXML
    public void onRegister() {
        String username = usernameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            errorLabel.setText("All fields are required.");
            return;
        }

        if (!password.equals(confirmPassword)) {
            errorLabel.setText("Passwords do not match.");
            return;
        }

        Task<ServiceResponse> registerTask = new Task<>() {
            @Override
            protected ServiceResponse call() throws Exception {
                return authService.register(username, email, password);
            }

            @Override
            protected void succeeded() {
                ServiceResponse response = getValue();
                if (response.getStatusCode() == 201) { // HTTP 201 Created
                    errorLabel.setText(""); // Clear any previous errors
                    navigateToLogin(); // Navigate to the login page after successful registration
                } else if (response.getStatusCode() == 409) { // HTTP 409 Conflict
                    errorLabel.setStyle("-fx-text-fill: red;");
                    errorLabel.setText("Email already in use.");
                } else {
                    errorLabel.setStyle("-fx-text-fill: red;");
                    errorLabel.setText("Error: " + response.getMessage());
                }
            }

            @Override
            protected void failed() {
                Throwable error = getException();
                errorLabel.setStyle("-fx-text-fill: red;");
                errorLabel.setText("An error occurred: " + error.getMessage());
                error.printStackTrace();
            }
        };

        new Thread(registerTask).start();
    }

    @FXML
    public void onLogin() {
        navigateToLogin();
    }

    private void navigateToLogin() {
        try {
            MainApp.switchView("views/login-view.fxml");
        } catch (IOException e) {
            errorLabel.setStyle("-fx-text-fill: red;");
            errorLabel.setText("Failed to load the login view.");
            e.printStackTrace();
        }
    }
}
