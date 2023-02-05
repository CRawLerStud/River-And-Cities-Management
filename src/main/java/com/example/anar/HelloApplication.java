package com.example.anar;

import com.example.anar.controller.AlertsController;
import com.example.anar.controller.RiversController;
import com.example.anar.repository.CityRepository;
import com.example.anar.repository.RiverRepository;
import com.example.anar.service.Service;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        String url = "jdbc:postgresql://localhost:5432/anar";
        String username = "postgres";
        String password = "postgres";

        RiverRepository riverRepository = new RiverRepository(url, username, password);
        CityRepository cityRepository = new CityRepository(url, username, password);

        Service service = new Service(riverRepository, cityRepository);

        FXMLLoader riverLoader = new FXMLLoader(HelloApplication.class.getResource("rivers.fxml"));
        Scene scene = new Scene(riverLoader.load(), 600, 400);
        stage.setTitle("Rivers");
        stage.setScene(scene);

        RiversController riversController = riverLoader.getController();
        riversController.setService(service);

        stage.show();

        FXMLLoader alertLoader = new FXMLLoader(HelloApplication.class.getResource("alerts.fxml"));
        Stage stage1 = new Stage();
        Scene scene1 = new Scene(alertLoader.load(), 600, 400);
        stage1.setTitle("Alerts");
        stage1.setScene(scene1);

        AlertsController alertsController = alertLoader.getController();
        alertsController.setService(service);

        stage1.show();

    }

    public static void main(String[] args) {
        launch();
    }
}