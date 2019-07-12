package com.davincia.lucasmahe.mareu_pj4;

import androidx.test.rule.ActivityTestRule;

import com.davincia.lucasmahe.mareu_pj4.di.Injection;
import com.davincia.lucasmahe.mareu_pj4.service.MeetingApiService;
import com.davincia.lucasmahe.mareu_pj4.ui.MainActivity;
import com.davincia.lucasmahe.mareu_pj4.utils.RecyclerViewUtils;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.filters.LargeTest;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static com.davincia.lucasmahe.mareu_pj4.utils.RecyclerViewUtils.clickChildView;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MeetingsListInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    private int currentMeetingsSize = -1;
    private MeetingApiService mApiService;

    @Before
    public void setup(){
        //TODO: Not sure with that...
        mApiService = Injection.getMeetingApiService();
        mActivityRule.getActivity();
        currentMeetingsSize = mApiService.getMeetings().size();
    }

    @Test
    public void checkIfRecyclerViewItemCount(){
        onView(withId(R.id.recyclerView_meeting)).check((ViewAssertion) new RecyclerViewUtils.ItemCount(currentMeetingsSize));
    }

    @Test
    public void checkIfDeletingMeetingIsWorking(){
        onView(withId(R.id.recyclerView_meeting))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, clickChildView(R.id.imageButton_item_delete)));
        onView(withId(R.id.recyclerView_meeting)).check((ViewAssertion) new RecyclerViewUtils.ItemCount(currentMeetingsSize - 1));
    }

    //Check add meeting
}
