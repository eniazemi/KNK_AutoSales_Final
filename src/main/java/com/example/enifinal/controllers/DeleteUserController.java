package com.example.enifinal.controllers;

import com.example.enifinal.process.ChangeScene;
import com.example.enifinal.process.DeleteUserProcess;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;


public class DeleteUserController {

    public TextField delete_user;

    public Label alert;

    public void confirm_delete(ActionEvent event) {
        String delete_user_id = delete_user.getText();
        try {
            DeleteUserProcess dup = new DeleteUserProcess((Integer.parseInt(delete_user_id)));

            boolean userExist = dup.checkIfExist();

            if (userExist) {
                if (!dup.checkIfAdmin()) {
                    Alert InformationAlert = new Alert(Alert.AlertType.INFORMATION);
                    InformationAlert.setContentText("User DELETED Successfully");
                    dup.deleteUser();
                    InformationAlert.show();
                    new ChangeScene().next_page(event, "views/profilePage.fxml");

                } else {
                    Alert error = new Alert(Alert.AlertType.ERROR);
                    error.setContentText("You can not delete an admin.");
                    error.show();
                }
            } else {
                alert.setText("User does not exist!");
            }
        } catch (Exception e) {
            alert.setText("Write a valid id!");
        }


    }

    public void cancel(ActionEvent event) throws IOException {
        new ChangeScene().next_page(event, "views/profilePage.fxml");
    }
}
