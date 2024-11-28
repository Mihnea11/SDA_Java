module com.movie.platform.client {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires jdk.compiler;

    opens com.movie.platform.client to javafx.fxml;
    opens com.movie.platform.client.controllers.authentication to javafx.fxml;

    exports com.movie.platform.client;
}