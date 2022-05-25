package com.example.enifinal.process;

import com.example.enifinal.database.Queries;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StatisticsProcess {

    public XYChart.Series getDataSeriesBarChart(String tableName, String groupby) throws SQLException, ClassNotFoundException {

        ResultSet db_data = new Queries().count_values(tableName, groupby);

        XYChart.Series dataSeries1 = new XYChart.Series();
        while (db_data.next()) {
            int value = db_data.getInt("num_count");
            String key = db_data.getString(groupby);
            dataSeries1.getData().add(new XYChart.Data(key, value));
        }
        return dataSeries1;
    }

    public ObservableList<PieChart.Data> getDataPieChart(String tableName, String groupby) throws SQLException, ClassNotFoundException {

        ResultSet db_data = new Queries().count_values(tableName, groupby);

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        while (db_data.next()) {
            int value = db_data.getInt("num_count");
            String key = db_data.getString(groupby);
            PieChart.Data data = new PieChart.Data(key, value);
            pieChartData.addAll(FXCollections.observableArrayList(data));
        }
        return pieChartData;
    }


}
