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
            new Meeting("Avancement projet4", "1562926394390", "Salle B", "phil@gmail.com - marc@hotmail.fr"),
            new Meeting("Budget café", "1562926374390", "Salle A", "phil@gmail.com - marc@hotmail.fr"),
            new Meeting("Encore une", "1562926364390", "Salle B", "phil@gmail.com - marc@hotmail.fr"),
            new Meeting("A quand les vacances?", "1562926384390", "Salle C", "phil@gmail.com - marc@hotmail.fr"),
            new Meeting("Un peu de sérieux", "1562926334390", "Salle C", "phil@gmail.com - marc@hotmail.fr"),
            new Meeting("UI new app", "1562926324390", "Salle B", "phil@gmail.com - marc@hotmail.fr"),
            new Meeting("La Réunion", "1562926354390", "Salle A", "phil@gmail.com - marc@hotmail.fr"),
            new Meeting("Mayotte", "1562926344390", "Salle A", "phil@gmail.com - marc@hotmail.fr")
    );
}