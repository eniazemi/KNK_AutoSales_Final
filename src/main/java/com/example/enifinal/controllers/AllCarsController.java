package com.example.enifinal.controllers;

import com.example.enifinal.process.AllCarsProcess;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;


public class AllCarsController extends MenuController implements Initializable {
    @FXML
    public VBox carlistbox, test;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            AllCarsProcess allCars = new AllCarsProcess();
            VBox e = allCars.doMagic(carlistbox);
            test.getChildren().add(e);
        } catch (Exception ignore) {}
    }
}
