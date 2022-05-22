package com.example.enifinal.controllers;

import com.example.enifinal.process.ChangeScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MenuController {
    @FXML
    Pane root;

    public void gotoHome(ActionEvent event) throws IOException {
        new ChangeScene().next_page(this.root,"views/greetingPage.fxml");
    }

    public void gotoAllCars(ActionEvent event) throws IOException {
        new ChangeScene().next_page(this.root,"views/allCars.fxml");
    }

    public void gotoStatistics(ActionEvent event) throws IOException {
        new ChangeScene().next_page(this.root,"views/statistics.fxml");
    }

    public void gotoProfile(ActionEvent event) throws IOException {
        new ChangeScene().next_page(this.root,"views/profile.fxml");
    }
    public void gotoUserEdit(ActionEvent event) throws IOException {
        new ChangeScene().next_page(this.root,"views/changePassword.fxml");
    }
    public void gotoSignOut(ActionEvent event) throws IOException {
        new ChangeScene().next_page(this.root,"views/greetingPage.fxml");
    }
    public void gotoChangeLanguage(ActionEvent event) throws IOException {
        new ChangeScene().next_page(this.root,"views/profile.fxml");
    }
    public void gotoAboutUs(ActionEvent event) throws IOException {
        new ChangeScene().next_page(this.root,"views/profile.fxml");
    }
}
