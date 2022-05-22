package com.example.enifinal.controllers;

import com.example.enifinal.models.UserModel;
import com.example.enifinal.process.ChangeScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProfileController extends MenuController implements Initializable {
    @FXML
    private Label user_name,user_username, user_gender, user_email, user_birthday, user_lastname, user_city;
    @FXML
    public void adminAccess(ActionEvent event) throws IOException {
        if (UserModel.isIsAdmin()){
            new ChangeScene().next_page(event ,"views/deleteUser.fxml");
        }
        else{
            Alert alert =  new Alert(Alert.AlertType.ERROR);
            alert.setContentText("You do not have admin Access. Please contact Eni :)");
            alert.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        user_name.setText(UserModel.getName());
        user_lastname.setText(UserModel.getLastname());
        user_username.setText(UserModel.getUsername());
        user_gender.setText(UserModel.getGender());
        user_birthday.setText(UserModel.getBirthday());
        user_email.setText(UserModel.getEmail());
        user_city.setText(UserModel.getCity());
    }

    public void changePassword(ActionEvent event) {

    }
}
