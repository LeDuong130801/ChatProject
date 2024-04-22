package com.intern.chatproject.utils;


import java.util.Date;

public class Util {
    // dd/mm/yyyy
    public static String dateTime2DateString(Long dateTime){
        Date d = new Date(dateTime);
        return d.getDate()+"/"+(d.getMonth()+1)+"/"+(d.getYear()+1900);
    }
    public static String auth(){
        return "admin";
    }
    public static String employeeSaleId(){
        return "6dc6e559-54fe-4f27-9b7a-d34a828cc6e1";
    }
    public static String websiteId(){
        return "0b540eb8-967d-4e71-99bb-4a8731c554a7";
    }
    public static final String HOST_NAME = "smtp.gmail.com";
    public static final int SSL_PORT = 465;
    public static final int TSL_PORT = 587;
    public static final String APP_EMAIL = "akun2kkq1@gmail.com";
    public static final String APP_PASSWORD = "6460 6091";
}