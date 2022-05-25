package com.example.enifinal.database;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public String check_user_email(String email) {
        String emailregex = "^(.+)@(.+)$";

        Pattern pattern = Pattern.compile(emailregex);

        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            return "Invalid email!(e.g user@domain.com)";
        }
        return null;
    }

    public String check_user_password(String password) {
        String passwordregex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$";

        Pattern pattern2 = Pattern.compile(passwordregex);

        Matcher matcher2 = pattern2.matcher(password);

        if (!matcher2.matches()) {
            return "Password must have digit,uppercase and more than 9 chars.";
        }
        return null;
    }

}

