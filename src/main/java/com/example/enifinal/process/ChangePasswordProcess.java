package com.example.enifinal.process;

import com.example.enifinal.database.Encrypt;
import com.example.enifinal.database.Queries;
import com.example.enifinal.models.UserModel;

import java.sql.SQLException;

public class ChangePasswordProcess {
    public ChangePasswordProcess(String new_pw) throws SQLException, ClassNotFoundException {
        System.out.println("ss");
        new Queries().updateOne("users", "Pasword", new Encrypt().encryptionWithMD5(new_pw), "id", UserModel.getId());
        System.out.println("updated");
    }
}
