package com.davincia.lucasmahe.mareu_pj4.utils;


import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import org.hamcrest.Matcher;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewAssertion;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

//This class comes from Project 2
public class RecyclerViewUtils {

    public static class ItemCount implements ViewAssertion {
        private final int expectedCount;

        public ItemCount(int expectedCount) {
            this.expectedCount = expectedCount;
        }

        @Override
        public void check(View view, NoMatchingViewException noViewFoundException) {
            if (noViewFoundException != null) {
                throw noViewFoundException;
            }

            RecyclerView recyclerView = (RecyclerView) view;
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            assertThat(adapter.getItemCount(), is(expectedCount));
        }
    }

    public static ViewAction clickChildView(final int id) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return null;
            }

            @Override
            public String getDescription() {
                return "Click on a child view with specified id.";
            }

            @Override
            public void perform(androidx.test.espresso.UiController uiController, View view) {
                View v = view.findViewById(id);
                v.performClick();
            }
        };
    }
}

