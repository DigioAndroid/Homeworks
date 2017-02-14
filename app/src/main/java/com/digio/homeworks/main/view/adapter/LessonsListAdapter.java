package com.digio.homeworks.main.view.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.digio.homeworks.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LessonsListAdapter extends RecyclerViewCursorAdapter<LessonsListAdapter.ViewHolder> {

    // Instance Variables
    private Context context;

    // Constructor
    public LessonsListAdapter(Context context) {
        super(context, null);
        this.context = context;
    }

    /**
     * Create ViewHolder
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // Create LayoutInflater
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate layout
        View view = inflater.inflate(R.layout.item_notice, parent, false);

        // Bind with Butterknife
        ButterKnife.bind(this, view);

        // Create ViewHolder passing view and listener
        final ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    /**
     * Update List using previously created ViewHolder
     * @param holder
     * @param cursor
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, Cursor cursor) {
        //TODO: Implement
    }

    // Custom ViewHolder defined
    static class ViewHolder extends RecyclerView.ViewHolder {

        // Instance variables
        @BindView(R.id.lyNoticeItem)
        RelativeLayout lyNoticeItem;
        @BindView(R.id.noticeTitle)
        TextView title;
        @BindView(R.id.teacherIcon)
        ImageView icon;
        @BindView(R.id.teacherName)
        TextView name;
        @BindView(R.id.teacherLocation)
        TextView location;
        @BindView(R.id.rateScore)
        TextView rate;
        @BindView(R.id.rateImage)
        ImageView rateImage;

        // Constructor
        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }

}
