package com.davincia.lucasmahe.mareu_pj4.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.davincia.lucasmahe.mareu_pj4.R;
import com.davincia.lucasmahe.mareu_pj4.events.DeleteMeetingEvent;
import com.davincia.lucasmahe.mareu_pj4.model.Meeting;
import com.davincia.lucasmahe.mareu_pj4.viewmodels.MeetingViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int DATE_ORDER = 1;
    public static final int NAME_ORDER = 2;

    //this should be stored in preferences
    private List<Meeting> mMeetings;
    private int sortingOrder = 0;

    private MeetingViewModel mMeetingViewModel;

    private RecyclerView mRecyclerView;
    private MeetingRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mRecyclerView = findViewById(R.id.recyclerView_meeting);
        FloatingActionButton mFab = findViewById(R.id.fab_add_meeting);

        mFab.setOnClickListener(fabListener);

        mAdapter = new MeetingRecyclerViewAdapter();

        mMeetingViewModel = ViewModelProviders.of(this).get(MeetingViewModel.class);
        mMeetingViewModel.init();
        //TODO: still not called automatically...
        mMeetingViewModel.getMeetings().observe(this, new Observer<List<Meeting>>() {
            @Override
            public void onChanged(List<Meeting> meetings) {
                Log.d("debuglog", "onChanged");
                //This list is used later for sorting
                mMeetings = meetings;
                mAdapter.setData(meetings, sortingOrder);
            }
        });
        mMeetingViewModel.init();

        initRecyclerView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Register to eventBus to handle item clicks
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
        mRecyclerView.setAdapter(mAdapter);
    }

    ///////////////////////////
    ///////////MENU////////////
    ///////////////////////////
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_sort_by_name:
                mAdapter.setData(mMeetingViewModel.getMeetings().getValue(), NAME_ORDER);
                return true;
            case R.id.menu_sort_by_date:
                mAdapter.setData(mMeetingViewModel.getMeetings().getValue(), DATE_ORDER);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    ///////////////////////////
    //////////CLICKS///////////
    ///////////////////////////
    @Subscribe
    public void onDeleteMeeting(DeleteMeetingEvent event){
        //TODO: would be better to delete via a unique identifier
        mMeetingViewModel.deleteMeeting(event.meeting);
        //TODO: This should ne done automatically trouble with the observer of viewModel
        mMeetingViewModel.getMeetings();
    }

    View.OnClickListener fabListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mMeetingViewModel.addMeeting();
            mMeetingViewModel.getMeetings();
            //mAdapter.setData(mMeetings, sortingOrder);
        }
    };
}
