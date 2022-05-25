package com.example.enifinal.process;

import com.example.enifinal.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.ResourceBundle;

public class ChangeScene {

    public void next_page(ActionEvent event, String x) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Objects.requireNonNull(HelloApplication.class.getResource(x)));
        fxmlLoader.setResources(ResourceBundle.getBundle(ChangeLanguage.getLang()));
        Parent root = fxmlLoader.load();

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root));
        window.setTitle(getTitle(x));
        window.show();
    }

    public void next_page(Pane root, String x) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Objects.requireNonNull(HelloApplication.class.getResource(x)));
        fxmlLoader.setResources(ResourceBundle.getBundle(ChangeLanguage.getLang()));
        Parent a = fxmlLoader.load();
        Stage window = (Stage) root.getScene().getWindow();
        window.setScene(new Scene(a));
        window.setTitle(getTitle(x));
        window.show();
    }

    public void another_page(String x) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(x));
        fxmlLoader.setResources(ResourceBundle.getBundle(ChangeLanguage.getLang()));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle(getTitle(x));
        stage.setScene(scene);
        stage.show();
    }


    private String getTitle(String x) {
        return switch (x) {
            case "views/greetingPage.fxml" -> "Welcome";
            case "views/profilePage.fxml" -> "My profile";
            case "views/statisticsPage.fxml" -> "Statistics";
            case "views/loginPage.fxml" -> "Login";
            case "views/signupPage.fxml" -> "Sign Up";
            case "views/homePage.fxml" -> "Home";
            case "views/deleteUser.fxml" -> "Delete User";
            case "views/extendedInfo.fxml" -> "Extended view";
            case "views/changePassword.fxml" -> "Changing password";
            case "views/allCarsPage.fxml" -> "All cars";
            case "views/aboutUsPage.fxml" -> "About Us";
            default -> null;
        };
    }
}
