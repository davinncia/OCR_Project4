package com.davincia.lucasmahe.mareu_pj4;

import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import com.davincia.lucasmahe.mareu_pj4.di.Injection;
import com.davincia.lucasmahe.mareu_pj4.service.MeetingApiService;
import com.davincia.lucasmahe.mareu_pj4.ui.MainActivity;
import com.davincia.lucasmahe.mareu_pj4.utils.NumberPickerUtils;
import com.davincia.lucasmahe.mareu_pj4.utils.RecyclerViewUtils;
import com.davincia.lucasmahe.mareu_pj4.viewmodels.MeetingViewModel;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static com.davincia.lucasmahe.mareu_pj4.utils.RecyclerViewUtils.clickChildView;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MeetingsListInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    private int currentMeetingsSize = -1;
    private MeetingApiService mApiService;
    private MeetingViewModel mViewModel;

    @Before
    public void setup(){
        mApiService = Injection.getMeetingApiService();
        mActivityRule.getActivity();
        currentMeetingsSize = mApiService.getMeetings().size();
    }

    @Test
    public void checkRecyclerViewItemCount(){
        onView(withId(R.id.recyclerView_meeting)).check((ViewAssertion) new RecyclerViewUtils.ItemCount(currentMeetingsSize));
    }

    @Test
    public void checkIfDeletingMeetingIsWorking(){
        onView(withId(R.id.recyclerView_meeting))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, clickChildView(R.id.imageButton_item_delete)));
        onView(withId(R.id.recyclerView_meeting)).check((ViewAssertion) new RecyclerViewUtils.ItemCount(currentMeetingsSize - 1));
    }

    @Test
    public void checkIfAddingMeetingIsWorking(){

        //Adding a meeting in our AddMeetingFragment
        onView(withId(R.id.fab_add_meeting)).perform(click());
        onView(withId(R.id.editText_name)).perform(typeText("Meet"));
        onView(withId(R.id.picker_hours)).perform(NumberPickerUtils.setPickerValue(10));
        onView(withId(R.id.picker_minutes)).perform(NumberPickerUtils.setPickerValue(30));
        onView(withId(R.id.editText_participants)).perform(typeText("Phil, Georges"));
        onView(withId(R.id.button_validate)).perform(click());

        //Check Meetings recyclerView counts one more
        onView(withId(R.id.recyclerView_meeting)).check((ViewAssertion) new RecyclerViewUtils.ItemCount(currentMeetingsSize + 1));
    }
}
