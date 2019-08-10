package com.davincia.lucasmahe.mareu_pj4.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.davincia.lucasmahe.mareu_pj4.R;
import com.davincia.lucasmahe.mareu_pj4.events.DeleteMeetingEvent;
import com.davincia.lucasmahe.mareu_pj4.model.Meeting;
import com.davincia.lucasmahe.mareu_pj4.utils.SortMeetings;
import com.davincia.lucasmahe.mareu_pj4.viewmodels.MeetingViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MeetingViewModel mMeetingViewModel;

    private RecyclerView mRecyclerView;
    private MeetingRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerView_meeting);
        FloatingActionButton mFab = findViewById(R.id.fab_add_meeting);

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fm = getSupportFragmentManager();
                AddMeetingDialogFragment addMeetingDialogFragment = AddMeetingDialogFragment.getInstance();
                addMeetingDialogFragment.show(fm, null);
            }
        });

        mAdapter = new MeetingRecyclerViewAdapter();
        initRecyclerView();

        mMeetingViewModel = ViewModelProviders.of(this).get(MeetingViewModel.class);

        mMeetingViewModel.getMeetings().observe(this, new Observer<List<Meeting>>() {
            @Override
            public void onChanged(List<Meeting> meetings) {
                mAdapter.setData(meetings);
            }
        });
    }


    private void initRecyclerView(){
        //Setting LayoutManager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //Setting Adapter
        mRecyclerView.setAdapter(mAdapter);
    }

    ///////////////////////////
    //EVENT BUS REGISTRATION///
    ///////////////////////////
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
                mMeetingViewModel.setSortingOrder(SortMeetings.SortMethods.NAME_ORDER);
                return true;
            case R.id.menu_sort_by_date:
                mMeetingViewModel.setSortingOrder(SortMeetings.SortMethods.DATE_ORDER);
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
        mMeetingViewModel.deleteMeeting(event.meeting);
    }
}
