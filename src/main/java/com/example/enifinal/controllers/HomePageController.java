package com.example.enifinal.controllers;

import com.example.enifinal.process.ChangeScene;
import javafx.event.ActionEvent;

import java.io.IOException;

public class HomePageController {

    public void gotoProfile(ActionEvent event) throws IOException {
        new ChangeScene().next_page(event,"views/profile.fxml");
    }

    public void gotoAboutUs(ActionEvent event) throws IOException {
        new ChangeScene().next_page(event,"views/aboutUsPage.fxml");

    }

    public void gotoStats(ActionEvent event) throws IOException {
        new ChangeScene().next_page(event,"views/statistics.fxml");

    }

    public void gotoAllCars(ActionEvent event) throws IOException {
        new ChangeScene().next_page(event,"views/allCars.fxml");

    }
}
