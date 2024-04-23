package com.intern.chatproject.utils;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
    // dd/mm/yyyy
    public static String dateTime2DateString(Long dateTime){
        Date d = new Date(dateTime);
        return d.getDate()+"/"+(d.getMonth()+1)+"/"+(d.getYear()+1900);
    }
    private static final DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");

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
    public static final Integer SSL_PORT = 465;
    public static final Integer TSL_PORT = 587;
    public static final String APP_EMAIL = "akun2kkq1@gmail.com";
    public static final String APP_PASSWORD = "6460 6091";


    public static Long getStartDateToday(){
        Date d = new Date();
        String dstr = d.getDate()+"/"+(d.getMonth()+1)+"/"+(d.getYear()+1900);
        Date dateObject = null;
        try {
            dateObject = sourceFormat.parse(dstr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assert dateObject != null;
        return dateObject.getTime();
    }
    public static Long getStartDateThisWeek(){
        Date d = new Date();
        String dstr = (d.getDate()-(d.getDay()-1)*Constrants.oneDayMilis)+"/"+(d.getMonth()+1)+"/"+(d.getYear()+1900);
        Date dateObject = null;
        try {
            dateObject = sourceFormat.parse(dstr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assert dateObject != null;
        return dateObject.getTime();
    }
    public static Long getStartDateThisMonth(){
        Date d = new Date();
        String dstr = "1/"+(d.getMonth()+1)+"/"+(d.getYear()+1900);
        Date dateObject = null;
        try {
            dateObject = sourceFormat.parse(dstr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assert dateObject != null;
        return dateObject.getTime();
    }
    public static Long getStartDateThisYear(){
        Date d = new Date();
        String dstr = "1/1/"+(d.getYear()+1900);
        Date dateObject = null;
        try {
            dateObject = sourceFormat.parse(dstr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assert dateObject != null;
        return dateObject.getTime();
    }
    public static Long getStartOf(Integer month, Integer year){
        String dstr = "1/"+ (month) +"/"+year;
        Date dateObject = null;
        try {
            dateObject = sourceFormat.parse(dstr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assert dateObject != null;
        return dateObject.getTime();
    }
    public static Long getStartOf(Integer date, Integer month, Integer year){
        String dstr = date+"/"+ (month) +"/"+year;
        Date dateObject = null;
        try {
            dateObject = sourceFormat.parse(dstr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assert dateObject != null;
        return dateObject.getTime();
    }
}