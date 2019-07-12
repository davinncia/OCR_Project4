package com.davincia.lucasmahe.mareu_pj4.model;

public class Meeting {

    private String name;
    private String time;
    private String place;
    private String mails;

    public Meeting(String name, String time, String place, String mails) {
        this.name = name;
        this.time = time;
        this.place = place;
        this.mails = mails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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
