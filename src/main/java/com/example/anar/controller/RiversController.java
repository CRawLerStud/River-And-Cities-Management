package com.example.anar.controller;

import com.example.anar.domain.River;
import com.example.anar.service.Service;
import com.example.anar.validation.ValidationException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class RiversController {

    private Service service;

    @FXML
    TableView<River> riverTable;
    @FXML
    TableColumn<River, String> riverColumn;
    @FXML
    TableColumn<River, Float> elevationColumn;
    @FXML
    TextField averageElevationTextField;
    @FXML
    Button updateButton;

    public void setService(Service service){
        this.service = service;
        initializeTable();
        updateTable();
    }

    private void initializeTable(){
        riverColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        elevationColumn.setCellValueFactory(new PropertyValueFactory<>("averageElevation"));

        riverTable.setRowFactory(tv -> {
            TableRow<River> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if(event.getClickCount() == 1 && !row.isEmpty()){
                    River selectedRiver = row.getItem();
                    averageElevationTextField.setText(selectedRiver.getAverageElevation().toString());
                }
            });
            return row;
        });
    }

    private void updateTable(){
        List<River> riverList = (List<River>) service.getAllRivers();
        ObservableList<River> observableList = FXCollections.observableList(riverList);
        riverTable.setItems(observableList);
    }

    @FXML
    public void updateRiver(){

        String averageElevationText = averageElevationTextField.getText();
        try{
            Float averageElevation = Float.parseFloat(averageElevationText);
            River selectedRiver = riverTable.getSelectionModel().getSelectedItem();
            if(selectedRiver == null)
                throw new ValidationException("River not selected!");
            service.updateRiverAverageElevation(selectedRiver, averageElevation);
            updateTable();
        }
        catch(NumberFormatException | ValidationException e){
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
            alert.showAndWait();
        }

    }



}
