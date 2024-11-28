package com.movie.platform.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainApp extends Application {

    private static Stage primaryStage;
    private static Scene mainScene;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("views/login-view.fxml")));
        mainScene = new Scene(root, 600, 400); // Set initial size

        stage.setScene(mainScene);
        stage.setTitle("Movie Platform");
        stage.setMinWidth(600);
        stage.setMinHeight(400);
        stage.show();
    }

    public static void switchView(String fxmlPath) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource(fxmlPath));
        Parent newRoot = loader.load();

        mainScene.setRoot(newRoot);
    }

    public static void main(String[] args) {
        launch();
    }
}