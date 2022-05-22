package com.example.enifinal.models;

public class UserModel {
    static String name, lastname,pass, city,username,email,gender,birthday;
    static boolean isAdmin;
    static int id;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        UserModel.name = name;
    }

    public static String getLastname() {
        return lastname;
    }

    public static void setLastname(String lastname) {
        UserModel.lastname = lastname;
    }

    public static String getPass() {
        return pass;
    }

    public static void setPass(String pass) {
        UserModel.pass = pass;
    }

    public static String getCity() {
        return city;
    }

    public static void setCity(String city) {
        UserModel.city = city;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username_) {
        UserModel.username = username_;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        UserModel.email = email;
    }

    public static String getGender() {
        return gender;
    }

    public static void setGender(String gender) {
        UserModel.gender = gender;
    }

    public static String getBirthday() {
        return birthday;
    }

    public static void setBirthday(String birthday) {
        UserModel.birthday = birthday;
    }

    public static boolean isIsAdmin() {
        return isAdmin;
    }

    public static void setIsAdmin(boolean isAdmin) {
        UserModel.isAdmin = isAdmin;
    }

    public static void setId(int id) {UserModel.id = id;}

    public static int getId(){return id;}
}
