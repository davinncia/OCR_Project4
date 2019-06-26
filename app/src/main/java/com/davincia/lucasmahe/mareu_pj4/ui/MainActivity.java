package com.davincia.lucasmahe.mareu_pj4.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.davincia.lucasmahe.mareu_pj4.R;
import com.davincia.lucasmahe.mareu_pj4.di.Injection;
import com.davincia.lucasmahe.mareu_pj4.model.Meeting;
import com.davincia.lucasmahe.mareu_pj4.service.MeetingApiService;

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

        //TODO: Why is injection necessary ??
        mApiService = Injection.getMeetingApiService();
        mMeetings = mApiService.getMeetings();

        initRecyclerView();

        Toast.makeText(this, String.valueOf(mAdapter.getItemCount()), Toast.LENGTH_SHORT).show();
    }

    private void initRecyclerView(){
        //Setting LayoutManager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Setting Adapter
        mAdapter = new MeetingRecyclerViewAdapter(mMeetings);
        mRecyclerView.setAdapter(mAdapter);
    }
}
