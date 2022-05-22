package com.example.enifinal.controllers;

import com.example.enifinal.process.ChangeScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class FirstPageController extends MenuController{
    @FXML
    public Pane root;

    @FXML
    private void signup_btn(ActionEvent event) throws IOException {
        new ChangeScene().next_page(event, "views/signupPage.fxml");
    }
    @FXML
    private void login_btn(ActionEvent event) throws IOException {
        new ChangeScene().next_page(event, "views/loginPage.fxml");
    }

}
