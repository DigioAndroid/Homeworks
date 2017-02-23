package com.digio.homeworks.main.view.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.digio.homeworks.R;
import com.digio.homeworks.main.view.activity.MainActivity;
import com.digio.homeworks.main.view.model.Notice;
import com.digio.homeworks.profile.view.activity.ProfileActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NoticeViewHolder extends RecyclerView.ViewHolder {

    // Instance variables
    @BindView(R.id.lyNoticeItem) RelativeLayout lyNoticeItem;
    @BindView(R.id.noticeTitle) TextView title;
    @BindView(R.id.teacherIcon) ImageView icon;
    @BindView(R.id.teacherName) TextView name;
    @BindView(R.id.teacherLocation) TextView location;
    @BindView(R.id.rateScore) TextView rate;
    @BindView(R.id.pricePerHour) TextView pricePerHour;
    @BindView(R.id.distanceToLocation) TextView distanceInKm;

    // Constructor
    public NoticeViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    public void bindNotice(Notice notice) {
        title.setText(notice.getTitle());
        icon.setImageResource(notice.getIconID());
        name.setText(notice.getTeacherName());
        location.setText(notice.getTeacherLocation());
        rate.setText(notice.getTeacherCurrentRate() + " / " + notice.getTeacherTotalRates());
        pricePerHour.setText("Precio por hora: " + notice.getPricePerHour() + "€/hora");
        distanceInKm.setText("Distancia: " + notice.getDistanceInKm() + " Km");
    }

    /**
     * Get Notice clicked and passed it
     * @param v
     */
    @OnClick(R.id.lyNoticeItem)
    public void onClick(View v) {
        RecyclerView list = (RecyclerView)v.getParent();
        Intent intent = new Intent(list.getContext(), ProfileActivity.class);
        Bundle bundle = new Bundle();
        //bundle.putString("NOTICE_ID", );
    }

}
