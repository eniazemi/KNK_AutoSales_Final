package com.example.enifinal.controllers;

import com.example.enifinal.database.Queries;
import com.example.enifinal.models.CarModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class ExtendedViewController implements Initializable {

    @FXML
    private Label car_name_label, car_model_label, car_origin_label, car_color_label, car_top_speed_label, car_year_label, car_price_label;

    @FXML
    private static ImageView car_first_photo;

    @FXML
    private static int car_id;


    public void setID(int car_id) {
        System.out.println(car_id);
        ExtendedViewController.car_id = car_id;
    }

    public void update() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = new Queries().findWithId("cars","car_id", car_id);

        while (resultSet.next()) {
            CarModel.setCar_name(resultSet.getString("car_name").trim());
            CarModel.setCar_model(resultSet.getString("car_model").trim());
            CarModel.setCar_brand(resultSet.getString("car_brand").trim());
            CarModel.setCar_origin(resultSet.getString("car_origin").trim());
            CarModel.setCar_color(resultSet.getString("car_color").trim());
            CarModel.setCar_top_speed(resultSet.getInt("car_top_speed"));
            CarModel.setCar_year(resultSet.getInt("car_year"));
            CarModel.setCar_price(resultSet.getInt("car_price"));
            CarModel.setCar_photo_path(resultSet.getString("car_photo").trim());
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        car_name_label.setText(CarModel.getCar_brand() + " " + CarModel.getCar_model());
        car_model_label.setText(CarModel.getCar_name());
        car_origin_label.setText(CarModel.getCar_origin());
        car_color_label.setText(CarModel.getCar_color());
        car_top_speed_label.setText(String.valueOf(CarModel.getCar_top_speed()));
        car_year_label.setText(String.valueOf(CarModel.getCar_year()));
        car_price_label.setText(String.valueOf(CarModel.getCar_price()));

        String image_path = "src/main/resources/com/example/enifinal/img/cars/car_";
        Path image_full_path = Paths.get(image_path + CarModel.getCar_photo_path());
        try {
            System.out.println(image_full_path.toUri().toURL().toExternalForm());
            car_first_photo.setImage(new Image(image_full_path.toUri().toURL().toExternalForm()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}


