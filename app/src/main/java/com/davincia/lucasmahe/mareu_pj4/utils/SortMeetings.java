package com.davincia.lucasmahe.mareu_pj4.utils;

import com.davincia.lucasmahe.mareu_pj4.model.Meeting;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortMeetings {


    public static List<Meeting> nameOrder(List<Meeting> meetings){

        Collections.sort(meetings, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting a, Meeting b) {
                return a.getName().compareTo(b.getName());
            }
        });

        return meetings;
    }


    public static List<Meeting> dateOrder(List<Meeting> meetings){

        Collections.sort(meetings, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting a, Meeting b) {
                return a.getTime().compareTo(b.getTime());
            }
        });
        return meetings;
    }
}
