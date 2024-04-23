package com.intern.chatproject;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class TestFeature {

    public static void main(String[] args) throws ParseException {
        DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date d = new Date();
        String dstr = "1/1/"+(d.getYear()+1900);
        log.info(d.getDay()+"");
        log.info(dstr);
        Date dateObject = sourceFormat.parse(dstr);
        long dateTime = dateObject.getTime(); //0h today
        log.info(dateTime+"");
        log.info(new Date().getTime()+"");
    }
}
