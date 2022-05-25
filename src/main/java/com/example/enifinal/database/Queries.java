package com.example.enifinal.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Queries {

    Statement statement;

    public ResultSet findAll(String tableName) throws SQLException, ClassNotFoundException {

        DBConnect dbc = new DBConnect();
        statement = dbc.getConnection().createStatement();

        String query = "select * from " + tableName;

        return statement.executeQuery(query);
    }

    public ResultSet findWithId(String tableName, String conditionColumn, int id) throws SQLException, ClassNotFoundException {
        DBConnect dbc = new DBConnect();
        statement = dbc.getConnection().createStatement();

        String query = "select * from " + tableName + " where " + conditionColumn + " = " + id;

        return statement.executeQuery(query);
    }

    public void updateOne(String tableName, String columnUpdateName, String columnUpdateValue, String columnConitionName, int columnConitionValue) throws SQLException, ClassNotFoundException {

        DBConnect dbc = new DBConnect();
        statement = dbc.getConnection().createStatement();

        String query = "UPDATE " + tableName + " SET " + columnUpdateName + " = '" + columnUpdateValue + "' WHERE " + columnConitionName + " = " + columnConitionValue;

        statement.executeUpdate(query);
    }

    public void delete(String tableName, String columnCondition, int id) throws SQLException, ClassNotFoundException {

        DBConnect dbc = new DBConnect();
        statement = dbc.getConnection().createStatement();

        String query = "DELETE FROM " + tableName + " WHERE " + columnCondition + " = " + id;
        statement.executeUpdate(query);

    }

    public ResultSet count_values(String table_name, String column_count) throws SQLException, ClassNotFoundException {
        DBConnect dbc = new DBConnect();
        statement = dbc.getConnection().createStatement();
        String query = "select " + column_count + ", count(*) as num_count from " + table_name + " group by " + column_count;

        return statement.executeQuery(query);
    }


}
