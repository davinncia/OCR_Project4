package com.davincia.lucasmahe.mareu_pj4.model;

import java.util.List;

public class Meeting {

    private String name;
    private String hour;
    private String place;
    private String mails;

    public Meeting(String name, String hour, String place, String mails) {
        this.name = name;
        this.hour = hour;
        this.place = place;
        this.mails = mails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getMails() {
        return mails;
    }

    public void setMails(String mails) {
        this.mails = mails;
    }
}
