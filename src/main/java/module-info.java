module com.example.anar {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.anar to javafx.fxml;
    exports com.example.anar;

    opens com.example.anar.repository to javafx.fxml;
    exports com.example.anar.repository;

    opens com.example.anar.utils.utils to javafx.fxml;
    exports com.example.anar.utils.utils;

    opens com.example.anar.utils.observer to javafx.fxml;
    exports com.example.anar.utils.observer;

    opens com.example.anar.service to javafx.fxml;
    exports com.example.anar.service;

    opens com.example.anar.domain to javafx.fxml;
    exports com.example.anar.domain;

    opens com.example.anar.controller to javafx.fxml;
    exports com.example.anar.controller;
}