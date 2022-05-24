package com.example.enifinal.process;

import com.example.enifinal.database.Queries;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AllCarsProcess extends Pane {
    private String car_brand, car_model, car_photo;
    private int car_price, car_id;

    public VBox doMagic(VBox carlistbox) throws SQLException, ClassNotFoundException, MalformedURLException {

        ResultSet resultSet = new Queries().findAll("cars");
        while (resultSet.next()) {
            this.car_brand = resultSet.getString("car_brand");
            this.car_model = resultSet.getString("car_model");
            this.car_photo = resultSet.getString("car_photo");
            this.car_price = resultSet.getInt("car_price");
            this.car_id = resultSet.getInt("car_id");
            HBox oneBox = create();
            oneBox.setSpacing(40);
            carlistbox.getChildren().add(oneBox);
            carlistbox.setSpacing(20);
            oneBox.setStyle("-fx-border-color: black");
        }
        return carlistbox;
    }

    public HBox create() throws MalformedURLException {

        String image_path = "src/main/resources/com/example/enifinal/img/cars/car_";
        Path image_full_path = Paths.get(image_path + car_photo);
        HBox hb = new HBox();
        ImageView imgView = new ImageView();

        imgView.setFitHeight(150);
        imgView.setFitWidth(220);


        imgView.setImage(new Image(image_full_path.toUri().toURL().toExternalForm()));
        Label lbl = new Label(car_brand + " " + car_model);
        Label lbl2 = new Label("$ " + car_price);
        Button btn = new Button("SPECS");
        btn.setPrefHeight(100);
        btn.setPrefWidth(100);
        btn.setId(String.valueOf(car_id));

        EventHandler<ActionEvent> event11 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                try {
                    doSomeMoreMagic(btn);
                } catch (Exception ignored) {
                }
            }
        };

        btn.setOnAction(event11);


        VBox vBox = new VBox();
        vBox.getChildren().addAll(lbl, lbl2, btn);
        vBox.setSpacing(20);
        hb.getChildren().addAll(imgView, vBox);
        hb.setSpacing(10);
        return hb;
    }

    private void doSomeMoreMagic(Button btn) throws SQLException, ClassNotFoundException, IOException {
        new ExtendedViewProcess(btn.getId());
    }
}

