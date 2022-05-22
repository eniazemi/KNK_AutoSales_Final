package com.example.enifinal.controllers;

import com.example.enifinal.database.Encrypt;
import com.example.enifinal.process.ChangeScene;
import com.example.enifinal.database.Regex;
import com.example.enifinal.process.SignupProcess;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SignupController implements Initializable {
    @FXML
    private TextField emri, mbiemri, username, city, email;
    @FXML
    private PasswordField password;
    @FXML
    private RadioButton btn_gender, btn_gender_1;
    @FXML
    private DatePicker birthday;
    @FXML
    private Label alert;

    final ToggleGroup toggleGroup = new ToggleGroup();

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.btn_gender.setToggleGroup(toggleGroup);
        this.btn_gender_1.setToggleGroup(toggleGroup);
    }

    @FXML
    public void create_new_user(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        String alert_msg = null;

        if (emri.getText().isEmpty() || mbiemri.getText().isEmpty() || username.getText().isEmpty() ||
                city.getText().isEmpty() || email.getText().isEmpty() || password.getText().isEmpty()) {
            alert_msg = "Fill all the required files";
        }
        alert.setText(alert_msg);
        if (alert_msg == null) {
            alert_msg = new Regex().check_user_email(email.getText());
            alert.setText(alert_msg);
        }
        if (alert_msg == null) {
            alert_msg = new Regex().check_user_password(password.getText());
            alert.setText(alert_msg);
        }
        if (alert_msg == null) {
            SignupProcess sp = new SignupProcess();
            alert_msg = sp.add_user(emri.getText(),
                    mbiemri.getText(),
                    username.getText(),
                    city.getText(),
                    email.getText(),
                    new Encrypt().encryptionWithMD5(password.getText()),
                    ((RadioButton) toggleGroup.getSelectedToggle()).getText(),
                    birthday.getValue(),
                    false);
            alert.setText(alert_msg);
        }
        if (alert_msg == null) {
            new ChangeScene().next_page(event, "views/loginPage.fxml");
        }
    }

    @FXML
    private void clear_button(ActionEvent event) throws IOException {
        new ChangeScene().next_page(event, "views/loginPage.fxml");

        this.emri.clear();
        this.btn_gender.setSelected(false);
        this.btn_gender_1.setSelected(false);
        this.mbiemri.clear();
        this.username.clear();
        this.city.clear();
        this.email.clear();
        this.password.clear();
        this.birthday.getEditor().clear();
    }

    @FXML
    private void login_button(ActionEvent event) throws IOException {
        new ChangeScene().next_page(event, "views/loginPage.fxml");
    }
}