package com.example.enifinal.process;

import com.example.enifinal.database.DBConnect;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.time.LocalDate;


public class SignupProcess {

    public String add_user(String name, String surname, String username, String city, String email, String password, String gender, LocalDate birthday, boolean isAdmin) throws SQLException, ClassNotFoundException {


        try {
        Statement statement = new DBConnect().getConnection().createStatement();
        String query = "INSERT INTO users(FirstName,LastName,Username,City,Email,Pasword,Gender,Birthday,isAdmin) Values ('"
                + name + "', '"
                + surname + "', '"
                + username + "','"
                + city + "', '"
                + email + "', '"
                + password + "', '"
                + gender + "', '"
                + birthday + "', '"
                +  (isAdmin ? 1 : 0) + "')";
        statement.executeUpdate(query);
        }
        catch (SQLIntegrityConstraintViolationException e){
            return "This username is already taken";
        }

        return null;
    }
}
