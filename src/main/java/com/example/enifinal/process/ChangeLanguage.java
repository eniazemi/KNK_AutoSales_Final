package com.example.enifinal.process;

public class ChangeLanguage {
    public static String lang = "bundle_EN";

    public static void setLang(String lang){
        ChangeLanguage.lang = lang;
    }
    public static String getLang(){
        return lang;
    }

}
