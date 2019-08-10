package com.davincia.lucasmahe.mareu_pj4.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.davincia.lucasmahe.mareu_pj4.model.Meeting;
import com.davincia.lucasmahe.mareu_pj4.repositories.MeetingRepository;
import com.davincia.lucasmahe.mareu_pj4.utils.SortMeetings;

import java.util.List;

public class MeetingViewModel extends ViewModel {


    private MutableLiveData<List<Meeting>> mMeetings = new MutableLiveData<>();

    private MeetingRepository mMeetingRepository;

    public MeetingViewModel(){
        mMeetingRepository = MeetingRepository.getInstance();
        mMeetings.setValue(mMeetingRepository.getMeetings());

    }

    public LiveData<List<Meeting>> getMeetings(){

        return mMeetings;
    }

    public void addMeeting(Meeting meeting){
        mMeetingRepository.addMeeting(meeting);
        mMeetings.setValue(mMeetingRepository.getMeetings());
    }

    public void deleteMeeting(Meeting meeting){
        mMeetingRepository.deleteMeeting(meeting);
        mMeetings.setValue(mMeetingRepository.getMeetings());
    }

    public void setSortingOrder(SortMeetings.SortMethods sortingOrder) {

        switch (sortingOrder){
            case DATE_ORDER:
                mMeetings.setValue(SortMeetings.dateOrder(mMeetingRepository.getMeetings()));
                break;
            case NAME_ORDER:
                mMeetings.setValue(SortMeetings.nameOrder(mMeetingRepository.getMeetings()));
                break;

        }
    }

}
