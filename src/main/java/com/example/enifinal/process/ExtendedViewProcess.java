//package com.example.enifinal.process;
//
//import com.example.enifinal.database.Queries;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.Label;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//
//import java.net.MalformedURLException;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class ExtendedViewProcess {
//
//    @FXML
//    private static String car_name, car_model, car_origin, car_color, car_brand, car_photo_path ;
//    private static int car_price, car_year, car_top_speed, id;
//
//    public static String getCar_name() {
//        return car_name;
//    }
//
//    public static String getCar_model() {
//        return car_model;
//    }
//
//    public static String getCar_origin() {
//        return car_origin;
//    }
//
//    public static String getCar_color() {
//        return car_color;
//    }
//
//    public static String getCar_brand() {
//        return car_brand;
//    }
//
//    public static String getCar_photo_path() {
//        return car_photo_path;
//    }
//
//    public static int getCar_price() {
//        return car_price;
//    }
//
//    public static int getCar_year() {
//        return car_year;
//    }
//
//    public static int getCar_top_speed() {
//        return car_top_speed;
//    }
//
//    @FXML
//    public void eni(ActionEvent event) {
//        System.out.println(car_year);
//        System.out.println(car_name);
//    }
//
//    public void setID(int car_id) {
//        System.out.println(car_id);
//        id = car_id;
//    }
//
//    public void update() throws SQLException, ClassNotFoundException {
//
//        ResultSet resultSet = new Queries().findWithId("cars", id);
//
//        while (resultSet.next()) {
//            car_name = resultSet.getString("car_name").trim();
//            car_model = resultSet.getString("car_model").trim();
//            car_brand = resultSet.getString("car_brand").trim();
//            car_origin = resultSet.getString("car_origin").trim();
//            car_color = resultSet.getString("car_color").trim();
//            car_top_speed = resultSet.getInt("car_top_speed");
//            car_year = resultSet.getInt("car_year");
//            car_price = resultSet.getInt("car_price");
//            car_photo_path = resultSet.getString("car_photo").trim();
//
//        }
//    }
//}