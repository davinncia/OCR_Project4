package com.davincia.lucasmahe.mareu_pj4.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.davincia.lucasmahe.mareu_pj4.R;
import com.davincia.lucasmahe.mareu_pj4.di.Injection;
import com.davincia.lucasmahe.mareu_pj4.model.Meeting;
import com.davincia.lucasmahe.mareu_pj4.service.MeetingApiService;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MeetingApiService mApiService;
    private List<Meeting> mMeetings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);

        //TODO: Why is injection necessary ??
        mApiService = Injection.getMeetingApiService();
        mMeetings = mApiService.getMeetings();

        String message = Arrays.toString(mMeetings.toArray());
        textView.setText(message);
    }
}
