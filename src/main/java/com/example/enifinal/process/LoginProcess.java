package com.example.enifinal.process;

import com.example.enifinal.database.Queries;
import com.example.enifinal.models.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class LoginProcess {

    public boolean validate(String username, String password, String tableName) throws SQLException, ClassNotFoundException {

        ResultSet resultSet = new Queries().findAll(tableName);

        while (resultSet.next()) {
            if (Objects.equals(username, resultSet.getString("Username").trim()) && Objects.equals(password, resultSet.getString("Pasword").trim())) {

                UserModel.setId(resultSet.getInt("id"));
                UserModel.setName(resultSet.getString("FirstName").trim());
                UserModel.setLastname(resultSet.getString("LastName").trim());
                UserModel.setPass(resultSet.getString("Pasword").trim());
                UserModel.setEmail(resultSet.getString("Email").trim());
                UserModel.setGender(resultSet.getString("Gender").trim());
                UserModel.setBirthday(resultSet.getString("Birthday").trim());
                UserModel.setCity(resultSet.getString("City").trim());
                UserModel.setUsername(resultSet.getString("Username").trim());
                UserModel.setIsAdmin(resultSet.getBoolean("isAdmin"));

                return true;
            }
        }

        return false;
    }
}
