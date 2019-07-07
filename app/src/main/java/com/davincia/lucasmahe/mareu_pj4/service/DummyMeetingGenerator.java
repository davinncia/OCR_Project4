package com.davincia.lucasmahe.mareu_pj4.service;

import com.davincia.lucasmahe.mareu_pj4.model.Meeting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DummyMeetingGenerator {

    static List<Meeting> generateMeetings() {
        return new ArrayList<>(DUMMY_MEETINGS);
    }

    public static List<Meeting> DUMMY_MEETINGS = Arrays.asList(
            new Meeting("Avancement projet4", "7", "Salle B", "phil@gmail.com - marc@hotmail.fr"),
            new Meeting("Budget café", "6", "Salle A", "phil@gmail.com - marc@hotmail.fr"),
            new Meeting("Encore une", "5", "Salle B", "phil@gmail.com - marc@hotmail.fr"),
            new Meeting("A quand les vacances?", "8", "Salle Z", "phil@gmail.com - marc@hotmail.fr"),
            new Meeting("Un peu de sérieux", "1", "Salle V", "phil@gmail.com - marc@hotmail.fr"),
            new Meeting("UI new app", "2", "Salle C", "phil@gmail.com - marc@hotmail.fr"),
            new Meeting("La Réunion", "4", "Salle C", "phil@gmail.com - marc@hotmail.fr"),
            new Meeting("Mayotte", "3", "Salle A", "phil@gmail.com - marc@hotmail.fr")
    );
}