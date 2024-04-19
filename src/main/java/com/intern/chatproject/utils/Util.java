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
        return "sale";
    }
    public static final String HOST_NAME = "smtp.gmail.com";
    public static final int SSL_PORT = 465;
    public static final int TSL_PORT = 587;
    public static final String APP_EMAIL = "akun2kkq1@gmail.com";
    public static final String APP_PASSWORD = "6460 6091";
}