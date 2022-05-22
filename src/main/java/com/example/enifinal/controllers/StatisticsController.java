package com.example.enifinal.controllers;


import com.example.enifinal.process.StatisticsProcess;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;

import java.net.URL;
import java.util.ResourceBundle;

public class StatisticsController extends MenuController implements Initializable {
    @FXML
    public BarChart barChartC;
    @FXML
    public PieChart pieChartC;

    @FXML
    public BarChart barChartU;
    @FXML
    public PieChart pieChartU;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            this.barChartC.getData().add(new StatisticsProcess().getDataSeriesBarChart("cars","car_fuel"));
            this.pieChartC.setData(new StatisticsProcess().getDataPieChart("cars","car_year"));

            this.barChartU.getData().add(new StatisticsProcess().getDataSeriesBarChart("users","City"));
            this.pieChartU.setData(new StatisticsProcess().getDataPieChart("users","Gender"));
        } catch (Exception ignore) {}

    }
}
