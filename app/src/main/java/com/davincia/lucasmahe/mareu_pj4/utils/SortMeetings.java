package com.davincia.lucasmahe.mareu_pj4.utils;

import android.util.Log;

import com.davincia.lucasmahe.mareu_pj4.model.Meeting;

import java.util.Collections;
import java.util.List;

public class SortMeetings {

    private List<Meeting> mMeetings;

    //TODO: complete these
    public List<Meeting> nameOrder(List<Meeting> meetings){

        Log.d("debuglog", "nameOrder ");
        mMeetings = meetings;
        return mMeetings;
    }


    public List<Meeting> dateOrder(List<Meeting> meetings){

        mMeetings = meetings;
        Collections.shuffle(mMeetings);
        return mMeetings;
    }
}
