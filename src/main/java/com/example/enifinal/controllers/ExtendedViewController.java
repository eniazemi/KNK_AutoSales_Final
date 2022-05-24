package com.example.enifinal.controllers;

import com.example.enifinal.models.CarModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;


public class ExtendedViewController implements Initializable {

    @FXML
    private Label car_name_label, car_model_label, car_origin_label, car_color_label, car_top_speed_label, car_year_label, car_price_label;

    @FXML
    private ImageView car_first_photo;


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
            car_first_photo.setImage(new Image(image_full_path.toUri().toURL().toExternalForm()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
