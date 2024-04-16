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
}