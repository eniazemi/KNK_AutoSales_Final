package com.example.enifinal.process;

import com.example.enifinal.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class ChangeScene {

    public void next_page(ActionEvent event, String x) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource(x)));
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root));

        window.show();
    }

    public void next_page(Pane root, String x) throws IOException {
        Parent a = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource(x)));
        Stage window = (Stage) root.getScene().getWindow();
        window.setScene(new Scene(a));
        window.show();
    }

    public void another_page(String name, String title) throws IOException {
        Stage stage = new Stage();
        Scene scene = new Scene(new FXMLLoader(HelloApplication.class.getResource(name)).load());
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
}
