package com.example.enifinal.process;

import com.example.enifinal.database.Queries;
import com.example.enifinal.models.CarModel;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExtendedViewProcess {
    private final int car_id;

    public ExtendedViewProcess(String button_id) throws SQLException, ClassNotFoundException, IOException {
        this.car_id = Integer.parseInt(button_id);
        setCarModel();
        try {
            new ChangeScene().another_page("views/extendedInfo.fxml");
        }catch (Exception ignore){}
    }

    public void setCarModel() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = new Queries().findWithId("cars", "car_id", car_id);
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

}
