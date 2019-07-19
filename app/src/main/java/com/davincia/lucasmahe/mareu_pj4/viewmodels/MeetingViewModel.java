package com.davincia.lucasmahe.mareu_pj4.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.davincia.lucasmahe.mareu_pj4.model.Meeting;
import com.davincia.lucasmahe.mareu_pj4.repositories.MeetingRepository;
import com.davincia.lucasmahe.mareu_pj4.ui.MainActivity;
import com.davincia.lucasmahe.mareu_pj4.utils.SortMeetings;

import java.util.List;

public class MeetingViewModel extends ViewModel {


    private MutableLiveData<List<Meeting>> mMeetings = new MutableLiveData<>();

    private MeetingRepository mMeetingRepository;

    @NonNull
    private int sortingOrder = 0;

    public void init(){
        mMeetingRepository = MeetingRepository.getInstance();
    }

    public LiveData<List<Meeting>> getMeetings(){

        //Sort our meeting list
        switch (sortingOrder){
            case MainActivity.DATE_ORDER:
                mMeetings.setValue(SortMeetings.dateOrder(mMeetingRepository.getMeetings()));
                break;
            case MainActivity.NAME_ORDER:
                mMeetings.setValue(SortMeetings.nameOrder(mMeetingRepository.getMeetings()));
                break;
            default:
                mMeetings.setValue(mMeetingRepository.getMeetings());
        }

        //Format date ? Would add an unnecessary for loop...

        return mMeetings;
    }

    public void addMeeting(Meeting meeting){
        mMeetingRepository.addMeeting(meeting);
        getMeetings();
    }

    public void deleteMeeting(Meeting meeting){
        mMeetingRepository.deleteMeeting(meeting);
        getMeetings();

    }

    public void setSortingOrder(int sortingOrder) {
        this.sortingOrder = sortingOrder;
    }
}
