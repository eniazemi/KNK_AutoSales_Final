package com.example.enifinal.controllers;

import com.example.enifinal.process.ChangeLanguage;
import com.example.enifinal.process.ChangeScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Objects;

public class MenuController {
    @FXML
    Pane root;

    public void gotoHome(ActionEvent event) throws IOException {
        new ChangeScene().next_page(this.root, "views/homePage.fxml");
    }

    public void gotoAllCars(ActionEvent event) throws IOException {
        new ChangeScene().next_page(this.root, "views/allCarsPage.fxml");
    }

    public void gotoStatistics(ActionEvent event) throws IOException {
        new ChangeScene().next_page(this.root, "views/statisticsPage.fxml");
    }

    public void gotoProfile(ActionEvent event) throws IOException {
        new ChangeScene().next_page(this.root, "views/profilePage.fxml");
    }

    public void gotoUserEdit(ActionEvent event) throws IOException {
        new ChangeScene().next_page(this.root, "views/changePassword.fxml");
    }

    public void gotoSignOut(ActionEvent event) throws IOException {
        new ChangeScene().next_page(this.root, "views/greetingPage.fxml");
    }

    public void gotoChangeLanguage(ActionEvent event) throws IOException {
        String x = ChangeLanguage.lang;
        if(Objects.equals(x, "bundle_EN")){
            ChangeLanguage.setLang("bundle_SQ");
        }
        else{
            ChangeLanguage.setLang("bundle_EN");
        }

        new ChangeScene().next_page(this.root, "views/homePage.fxml");
    }

    public void gotoAboutUs(ActionEvent event) throws IOException {
        new ChangeScene().next_page(this.root, "views/aboutUsPage.fxml");
    }
}
