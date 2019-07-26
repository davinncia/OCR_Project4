package com.davincia.lucasmahe.mareu_pj4.service;

import com.davincia.lucasmahe.mareu_pj4.model.Meeting;

import java.util.List;
import java.util.Random;

import static com.davincia.lucasmahe.mareu_pj4.service.DummyMeetingGenerator.DUMMY_MEETINGS;
import static com.davincia.lucasmahe.mareu_pj4.service.DummyMeetingGenerator.generateMeetings;

public class DummyMeetingApiService implements MeetingApiService {

    private List<Meeting> meetings = generateMeetings();

    @Override
    public List<Meeting> getMeetings() {
        return meetings;
    }

    @Override
    public void deleteMeeting(Meeting meeting) {
        meetings.remove(meeting);
    }

    @Override
    public void addMeeting(Meeting meeting) {
        //Meeting newMeeting = DUMMY_MEETINGS.get(new Random().nextInt(DUMMY_MEETINGS.size()));
        meetings.add(meeting);
    }
}