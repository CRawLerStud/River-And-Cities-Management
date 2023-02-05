package com.example.anar.controller;

import com.example.anar.domain.City;
import com.example.anar.service.Service;
import com.example.anar.utils.observer.Observer;
import com.example.anar.utils.utils.ChangeEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class AlertsController implements Observer<ChangeEvent> {

    private Service service;

    @FXML
    TableView<City> smallTable;
    @FXML
    TableView<City> mediumTable;
    @FXML
    TableView<City> highTable;
    @FXML
    TableColumn<City, String> smallColumn;
    @FXML
    TableColumn<City, String> mediumColumn;
    @FXML
    TableColumn<City, String> highColumn;

    public void setService(Service service) {
        this.service = service;
        initializeTables();
        updateTables();
        service.addChangeObserver(this);
    }

    private void initializeTables(){
        smallColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        smallColumn.setStyle("-fx-text-fill: green");
        mediumColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        highColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        highColumn.setStyle("-fx-text-fill: red");
    }

    private void updateTables(){
        updateSmallRiskTable();
        updateMediumRiskTable();
        updateHighRiskTable();
    }

    private void updateSmallRiskTable(){
        List<City> smallRiskCities = (List<City>) service.getAllSmallRiskCities();
        ObservableList<City> observableList = FXCollections.observableList(smallRiskCities);
        smallTable.setItems(observableList);
    }

    private void updateMediumRiskTable(){
        List<City> mediumRiskCities = (List<City>) service.getAllMediumRiskCities();
        ObservableList<City> observableList = FXCollections.observableList(mediumRiskCities);
        mediumTable.setItems(observableList);
    }

    private void updateHighRiskTable(){
        List<City> highRiskCities = (List<City>) service.getAllHighRiskCities();
        ObservableList<City> observableList = FXCollections.observableList(highRiskCities);
        highTable.setItems(observableList);
    }


    @Override
    public void update(ChangeEvent event) {
        updateTables();
    }
}
