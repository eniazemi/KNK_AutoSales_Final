package com.example.enifinal.process;

import com.example.enifinal.database.Queries;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteUserProcess {
    private int id;
    private ResultSet resultSet;

    public DeleteUserProcess(int id) throws SQLException, ClassNotFoundException {
        this.id = id;
        resultSet = new Queries().findWithId("users", "id", id);

    }

    public boolean checkIfExist() throws SQLException {
        return resultSet.next();
    }

    public boolean checkIfAdmin() throws SQLException {
        return resultSet.getBoolean("isAdmin");
    }

    public void deleteUser() throws SQLException, ClassNotFoundException {
        new Queries().delete("users", "id", this.id);
    }
}
