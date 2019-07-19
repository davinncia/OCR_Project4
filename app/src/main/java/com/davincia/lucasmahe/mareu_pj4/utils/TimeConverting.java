package com.davincia.lucasmahe.mareu_pj4.utils;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeConverting {

    public static String getTimeFromDate(String dateString){

        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date date = new Date();

        try {
            date = format.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return String.valueOf(date.getTime());
    }
}
