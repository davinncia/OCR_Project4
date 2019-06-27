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
            new Meeting("Avancement projet4", "15H20", "Salle B", "phil@gmail.com - marc@hotmail.fr"),
            new Meeting("Budget café", "7H20", "Salle A", "phil@gmail.com - marc@hotmail.fr"),
            new Meeting("Encore une", "18H00", "Salle B", "phil@gmail.com - marc@hotmail.fr"),
            new Meeting("A quand les vacances?", "22H30", "Salle Z", "phil@gmail.com - marc@hotmail.fr"),
            new Meeting("Un peu de sérieux", "7H00", "Salle V", "phil@gmail.com - marc@hotmail.fr"),
            new Meeting("UI new app", "13H00", "Salle C", "phil@gmail.com - marc@hotmail.fr"),
            new Meeting("La Réunion", "15H20", "Salle C", "phil@gmail.com - marc@hotmail.fr"),
            new Meeting("Mayotte", "16H40", "Salle A", "phil@gmail.com - marc@hotmail.fr")
    );
}