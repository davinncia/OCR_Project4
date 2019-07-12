package com.davincia.lucasmahe.mareu_pj4.utils;

import android.util.Log;

import com.davincia.lucasmahe.mareu_pj4.model.Meeting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortMeetings {

    private List<Meeting> mMeetings;


    public List<Meeting> nameOrder(List<Meeting> meetings){
        Log.d("debuglog", "nameOrder");

        mMeetings = meetings;

        Collections.sort(mMeetings, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting a, Meeting b) {
                return a.getName().compareTo(b.getName());
            }
        });

        return mMeetings;
    }


    public List<Meeting> dateOrder(List<Meeting> meetings){
        Log.d("debuglog", "dateOrder");

        mMeetings = meetings;

        Collections.sort(mMeetings, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting a, Meeting b) {
                return a.getTime().compareTo(b.getTime());
            }
        });
        return mMeetings;
    }
}
