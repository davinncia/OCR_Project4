package com.davincia.lucasmahe.mareu_pj4;

import com.davincia.lucasmahe.mareu_pj4.di.Injection;
import com.davincia.lucasmahe.mareu_pj4.model.Meeting;
import com.davincia.lucasmahe.mareu_pj4.service.DummyMeetingGenerator;
import com.davincia.lucasmahe.mareu_pj4.service.MeetingApiService;
import com.davincia.lucasmahe.mareu_pj4.utils.SortMeetings;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;


@RunWith(JUnit4.class)
public class DummyMeetingApiServiceTest {

    private MeetingApiService mApiService;

    @Before
    public void setup() {
        mApiService = Injection.getNewInstanceApiService();
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
        Meeting newMeeting = new Meeting("Réunion", "12343493", "Salle B", "Phil, Jean");
        //WHEN
        mApiService.addMeeting(newMeeting);
        //THEN
        assertEquals(mApiService.getMeetings().size(), meetingsSize + 1);
    }

    @Test
    public void sortMeetingsByName(){
        //GIVEN
        Meeting m1 = new Meeting("AAAA", "17864287", "Salle B", "phil.com");
        Meeting m2 = new Meeting("BBBB", "27864287", "Salle A", "jacques.com");
        Meeting m3 = new Meeting("CCCC", "37864287", "Salle C", "amine.com");

        List<Meeting> meetings = new ArrayList<>();
        meetings.add(m1);
        meetings.add(m3);
        meetings.add(m2);
        //WHEN
        SortMeetings.nameOrder(meetings);
        //THEN
        assertSame(m1, meetings.get(0));
        assertSame(m2, meetings.get(1));
        assertSame(m3, meetings.get(2));
    }

    @Test
    public void sortMeetingsByDate(){
        //GIVEN
        Meeting m1 = new Meeting("AAAA", "17864287", "Salle B", "phil.com");
        Meeting m2 = new Meeting("BBBB", "27864287", "Salle A", "jacques.com");
        Meeting m3 = new Meeting("CCCC", "37864287", "Salle C", "amine.com");

        List<Meeting> meetings = new ArrayList<>();
        meetings.add(m3);
        meetings.add(m2);
        meetings.add(m1);
        //WHEN
        SortMeetings.dateOrder(meetings);
        //THEN
        assertSame(m1, meetings.get(0));
        assertSame(m2, meetings.get(1));
        assertSame(m3, meetings.get(2));
    }
}
