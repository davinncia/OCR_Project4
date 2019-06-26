package com.davincia.lucasmahe.mareu_pj4.events;

import com.davincia.lucasmahe.mareu_pj4.model.Meeting;

/**
 * Event fired when a user clicks on delete
 */
public class DeleteMeetingEvent {

    /**
     * Meeting to delete
     */
    public Meeting meeting;

    /**
     * Constructor
     * @param meeting
     */
    public DeleteMeetingEvent(Meeting meeting) {
        this.meeting = meeting;
    }
}
