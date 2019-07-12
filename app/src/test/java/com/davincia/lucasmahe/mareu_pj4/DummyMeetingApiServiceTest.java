package com.davincia.lucasmahe.mareu_pj4;

import com.davincia.lucasmahe.mareu_pj4.di.Injection;
import com.davincia.lucasmahe.mareu_pj4.model.Meeting;
import com.davincia.lucasmahe.mareu_pj4.service.DummyMeetingGenerator;
import com.davincia.lucasmahe.mareu_pj4.service.MeetingApiService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


@RunWith(JUnit4.class)
public class DummyMeetingApiServiceTest {

    private MeetingApiService mApiService;

    @Before
    public void setup() {
        mApiService = Injection.getNewInsanceApiService();
    }

    @Test
    public void getDummyMeetingsWithSuccess(){
        //GIVEN
        List<Meeting> meetingsExpected = DummyMeetingGenerator.DUMMY_MEETINGS;
        //WHEN
        List<Meeting> meetingsActual = mApiService.getMeetings();
        //THEN
        assertEquals(meetingsExpected.size(), meetingsActual.size());
        assertEquals(meetingsExpected.get(1), meetingsActual.get(1));
    }

    @Test
    public void deleteMeetingWithSuccess(){
        //GIVEN
        Meeting meetingToDelete = mApiService.getMeetings().get(1);
        //WHEN
        mApiService.deleteMeeting(meetingToDelete);
        //THEN
        assertFalse(mApiService.getMeetings().contains(meetingToDelete));
    }

    @Test
    public void addNewMeetingWithSuccess(){
        //GIVEN
        int meetingsSize = mApiService.getMeetings().size();
        //WHEN
        mApiService.addMeeting();
        //THEN
        assertTrue(mApiService.getMeetings().size() == meetingsSize + 1);
    }

    @Test
    public void sortMeetingsByName(){

    }

    @Test
    public void sortMeetingsByDate(){

    }
}
