package com.example.enifinal.controllers;

import com.example.enifinal.process.ChangeScene;
import javafx.event.ActionEvent;
import javafx.scene.control.Menu;

import java.io.IOException;

public class HomePageController extends MenuController {

    public void gotoProfile(ActionEvent event) throws IOException {
        new ChangeScene().next_page(event, "views/profilePage.fxml");
    }

    public void gotoAboutUs(ActionEvent event) throws IOException {
        new ChangeScene().next_page(event, "views/aboutUsPage.fxml");
    }

    public void gotoStats(ActionEvent event) throws IOException {
        new ChangeScene().next_page(event, "views/statisticsPage.fxml");
    }

    public void gotoAllCars(ActionEvent event) throws IOException {
        new ChangeScene().next_page(event, "views/allCarsPage.fxml");
    }
}
