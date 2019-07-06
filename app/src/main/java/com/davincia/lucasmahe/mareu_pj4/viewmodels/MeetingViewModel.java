package com.davincia.lucasmahe.mareu_pj4.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.davincia.lucasmahe.mareu_pj4.model.Meeting;
import com.davincia.lucasmahe.mareu_pj4.repositories.MeetingRepository;

import java.util.List;

public class MeetingViewModel extends ViewModel {

    private MutableLiveData<List<Meeting>> mMeetings = new MutableLiveData<>();

    private MeetingRepository mMeetingRepository;

    public void init(){
        mMeetingRepository = MeetingRepository.getInstance();
    }

    public LiveData<List<Meeting>> getMeetings(){

        mMeetings.setValue(mMeetingRepository.getMeetings());
        return mMeetings;
    }

    public void addMeeting(){
        mMeetingRepository.addMeeting();
    }

    public void deleteMeeting(Meeting meeting){
        mMeetingRepository.deleteMeeting(meeting);
    }
}
