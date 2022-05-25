package com.example.enifinal.controllers;


import com.example.enifinal.process.StatisticsProcess;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;

import java.net.URL;
import java.util.ResourceBundle;

public class StatisticsController extends MenuController implements Initializable {
    @FXML
    public BarChart barChartC, barChartU;
    @FXML
    public PieChart pieChartC, pieChartU;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            this.barChartC.getData().add(new StatisticsProcess().getDataSeriesBarChart("cars", "car_origin"));
            this.pieChartC.setData(new StatisticsProcess().getDataPieChart("cars", "car_brand"));

            this.barChartU.getData().add(new StatisticsProcess().getDataSeriesBarChart("users", "City"));
            this.pieChartU.setData(new StatisticsProcess().getDataPieChart("users", "Gender"));
        } catch (Exception ignore) {
        }
    }
}
