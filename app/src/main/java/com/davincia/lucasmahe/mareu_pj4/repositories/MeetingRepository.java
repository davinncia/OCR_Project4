package com.davincia.lucasmahe.mareu_pj4.repositories;

import com.davincia.lucasmahe.mareu_pj4.di.Injection;
import com.davincia.lucasmahe.mareu_pj4.model.Meeting;
import com.davincia.lucasmahe.mareu_pj4.service.MeetingApiService;

import java.util.List;

public class MeetingRepository {

    private static MeetingRepository instance;
    private MeetingApiService apiService;

    private MeetingRepository(){
        //No constructor allowed
    }

    public static MeetingRepository getInstance(){
        if (instance == null){
            instance = new MeetingRepository();
        }
        return instance;
    }

    public List<Meeting> getMeetings(){

        if (apiService == null){
            apiService = Injection.getMeetingApiService();
        }
        return apiService.getMeetings();
    }

    public void deleteMeeting(Meeting meeting){
        if (apiService == null){
            apiService = Injection.getMeetingApiService();
        }
        apiService.deleteMeeting(meeting);
    }


    public void addMeeting(Meeting meeting){
        if (apiService == null){
            apiService = Injection.getMeetingApiService();
        }
        apiService.addMeeting(meeting);
    }
}
