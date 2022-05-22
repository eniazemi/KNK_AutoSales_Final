package com.example.enifinal.controllers;

import com.example.enifinal.database.Regex;
import com.example.enifinal.models.UserModel;
import com.example.enifinal.process.ChangePasswordProcess;
import com.example.enifinal.process.ChangeScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class ChangePasswordController extends MenuController implements Initializable {
    @FXML
    private PasswordField old_password;
    @FXML
    private PasswordField new_password;
    @FXML
    private PasswordField confirm_password;
    @FXML
    public Label welcomeMessage, alert;

    public void change_password(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        String alert_msg = null;
        if (Objects.equals(old_password.getText(), UserModel.getPass())) {
            if (Objects.equals(new_password.getText(), confirm_password.getText())) {
                alert_msg = new Regex().check_user_password(new_password.getText());
                if (alert_msg==null) {
                    new ChangePasswordProcess(new_password.getText());
                    new ChangeScene().next_page(event, "views/loginPage.fxml");
                }
            } else {
                alert_msg = "Passwords do not match";
            }

        } else {
            alert_msg = "Old Password is incorrect";
        }
        alert.setText(alert_msg);
    }

    public void cancel(ActionEvent event) throws IOException {
        new ChangeScene().next_page(event, "views/profile.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        welcomeMessage.setText("Welcome " + UserModel.getName());
    }
}
