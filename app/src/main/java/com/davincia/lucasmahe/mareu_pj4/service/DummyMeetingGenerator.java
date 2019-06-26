package com.davincia.lucasmahe.mareu_pj4.service;

import com.davincia.lucasmahe.mareu_pj4.model.Meeting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DummyMeetingGenerator {

    private static List<Meeting> DUMMY_MEETINGS = Arrays.asList(
            new Meeting("Avancement projet4", "15H20", "Salle B", "phil@gmail.com"),
            new Meeting("Budget café", "7H20", "Salle A", "phil@gmail.com"),
            new Meeting("Encore une", "18H00", "Salle B", "phil@gmail.com")
    );

    static List<Meeting> generateMeetings() {
        return new ArrayList<>(DUMMY_MEETINGS);
    }
}