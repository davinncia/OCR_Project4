package com.davincia.lucasmahe.mareu_pj4.ui;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProviders;

import com.davincia.lucasmahe.mareu_pj4.R;
import com.davincia.lucasmahe.mareu_pj4.model.Meeting;
import com.davincia.lucasmahe.mareu_pj4.repositories.MeetingRepository;
import com.davincia.lucasmahe.mareu_pj4.utils.TimeConverting;
import com.davincia.lucasmahe.mareu_pj4.viewmodels.MeetingViewModel;

public class AddMeetingDialogFragment extends DialogFragment {

    private MeetingViewModel mMeetingViewModel;
    private Meeting mMeeting;

    private EditText mNameEdit;
    private EditText mParticipantsEdit;
    private Spinner mRoomSpinner;
    private NumberPicker mMinutesPicker;
    private NumberPicker mHourPicker;
    private Button mValidateButton;

    public AddMeetingDialogFragment() {
    }

    public static AddMeetingDialogFragment getInstance(){
        AddMeetingDialogFragment fragment = new AddMeetingDialogFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_add_meeting, container);
    }

    @Override
    public void onStart() {
        super.onStart();

        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mNameEdit = view.findViewById(R.id.editText_name);
        mParticipantsEdit = view.findViewById(R.id.editText_participants);
        mRoomSpinner = view.findViewById(R.id.spinner_room);
        mMinutesPicker = view.findViewById(R.id.picker_minutes);
        mHourPicker = view.findViewById(R.id.picker_hours);
        mValidateButton = view.findViewById(R.id.button_validate);

        //Set pickers
        mMinutesPicker.setMinValue(0);
        mMinutesPicker.setMaxValue(50);
        mHourPicker.setMinValue(0);
        mHourPicker.setMaxValue(23);

        mMeetingViewModel = ViewModelProviders.of(this).get(MeetingViewModel.class);
        mMeetingViewModel.init();

        mValidateButton.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            String mName = mNameEdit.getText().toString().trim();
            String mRoom = String.valueOf(mRoomSpinner.getSelectedItem());
            String mDate = TimeConverting.getTimeFromDate(mHourPicker.getValue() + ":" + mMinutesPicker.getValue());
            String mParticipants = mParticipantsEdit.getText().toString().trim();

            if (!mName.equals("") && !mDate.equals("") && !mRoom.equals("") && !mParticipants.equals("")){

                mMeeting = new Meeting(mName, mDate, mRoom, mParticipants);
                mMeetingViewModel.addMeeting(mMeeting);

                dismiss();
            } else {
                Toast.makeText(getContext(), "Field missing", Toast.LENGTH_SHORT).show();
            }

        }
    };
}
