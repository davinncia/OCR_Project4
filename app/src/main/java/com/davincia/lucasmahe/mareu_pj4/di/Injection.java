package com.davincia.lucasmahe.mareu_pj4.di;

import com.davincia.lucasmahe.mareu_pj4.service.DummyMeetingApiService;
import com.davincia.lucasmahe.mareu_pj4.service.MeetingApiService;

public class Injection {

    private static MeetingApiService service = new DummyMeetingApiService();

    public static MeetingApiService getMeetingApiService() { return service; }

    //Useful for tests, so we ensure context is clean
    public static MeetingApiService getNewInsanceApiService(){
        return new DummyMeetingApiService();
    }
}
