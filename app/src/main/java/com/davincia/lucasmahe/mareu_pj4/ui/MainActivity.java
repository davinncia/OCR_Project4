package com.davincia.lucasmahe.mareu_pj4.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.davincia.lucasmahe.mareu_pj4.R;
import com.davincia.lucasmahe.mareu_pj4.di.Injection;
import com.davincia.lucasmahe.mareu_pj4.events.DeleteMeetingEvent;
import com.davincia.lucasmahe.mareu_pj4.model.Meeting;
import com.davincia.lucasmahe.mareu_pj4.service.MeetingApiService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MeetingApiService mApiService;
    private List<Meeting> mMeetings;

    private RecyclerView mRecyclerView;
    private MeetingRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerView_meeting);

        //TODO: Why is injection necessary ?
        mApiService = Injection.getMeetingApiService();
        mMeetings = mApiService.getMeetings();

        initRecyclerView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Register to eventbus to handle item clicks
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    private void initRecyclerView(){
        //Setting LayoutManager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Setting Adapter
        mAdapter = new MeetingRecyclerViewAdapter(mMeetings);
        mRecyclerView.setAdapter(mAdapter);
    }

    ///////////////////////////
    //////////CLICKS///////////
    ///////////////////////////
    @Subscribe
    public void onDeleteMeeting(DeleteMeetingEvent event){
        mApiService.deleteMeeting(event.meeting);
        mAdapter.notifyDataSetChanged();
    }

}
