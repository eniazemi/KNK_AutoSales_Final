package com.example.enifinal.controllers;

import com.example.enifinal.database.Encrypt;
import com.example.enifinal.process.ChangeScene;
import com.example.enifinal.process.LoginProcess;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.sql.*;

public class LoginController {

    public BorderPane root;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label wrongLogIn;

    @FXML
    public void loginUser(ActionEvent event) throws SQLException, IOException, ClassNotFoundException {
        wrongLogIn.setText("");

        if (username.getText().isEmpty() || password.getText().isEmpty()) {
            wrongLogIn.setText("Fill all the required fields");
        }
        else {
            String user = username.getText();
            String pass = password.getText();
//            pass = new Encrypt().encryptionWithMD5(pass);
            LoginProcess lv = new LoginProcess();

            if (lv.validate(user,pass,"users")){
                wrongLogIn.setText("");
                new ChangeScene().next_page(event, "views/allCars.fxml");

            }
            else {
                wrongLogIn.setText("Wrong credentials");
            }
        }
    }

    @FXML
    public void newUser(ActionEvent event) throws IOException {
        new ChangeScene().next_page(event, "views/signupPage.fxml");
    }
}
