package com.davincia.lucasmahe.mareu_pj4.ui;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.davincia.lucasmahe.mareu_pj4.R;
import com.davincia.lucasmahe.mareu_pj4.events.DeleteMeetingEvent;
import com.davincia.lucasmahe.mareu_pj4.model.Meeting;
import com.davincia.lucasmahe.mareu_pj4.utils.SortMeetings;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class MeetingRecyclerViewAdapter extends RecyclerView.Adapter<MeetingRecyclerViewAdapter.MeetingsViewHolder> {

    private List<Meeting> mMeetings;

    @NonNull
    @Override
    public MeetingsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        // CREATE VIEW HOLDER AND INFLATING ITS XML LAYOUT
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.meeting_item, parent, false);

        return new MeetingsViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull MeetingsViewHolder holder, final int i) {

        holder.imageView.setImageResource(R.drawable.ic_launcher_background);
        holder.titleTextView.setText(mMeetings.get(i).getName());
        holder.mailsTextView.setText(mMeetings.get(i).getMails());

        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Using our EventBus library to communicate. Publish
                EventBus.getDefault().post(new DeleteMeetingEvent(mMeetings.get(i)));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMeetings != null? mMeetings.size() : 0;
    }

    public void setData(List<Meeting> meetings, int order){
        SortMeetings sorter = new SortMeetings();
        switch (order){
            case MainActivity.NAME_ORDER:
                this.mMeetings = sorter.nameOrder(meetings);
            case MainActivity.DATE_ORDER:
                this.mMeetings = sorter.dateOrder(meetings);
            default:
                this.mMeetings = meetings;
        }
        notifyDataSetChanged();
    }

    public static class MeetingsViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView titleTextView;
        private TextView mailsTextView;
        private ImageButton deleteButton;

        public MeetingsViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView_item_meeting);
            titleTextView = itemView.findViewById(R.id.textView_item_main);
            mailsTextView = itemView.findViewById(R.id.textView_item_mails);
            deleteButton = itemView.findViewById(R.id.imageButton_item_delete);
        }

    }
}
