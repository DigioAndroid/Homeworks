package com.digio.homeworks.main.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.digio.homeworks.R;
import com.digio.homeworks.main.view.model.Notice;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NoticeViewHolder extends RecyclerView.ViewHolder {

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
    @BindView(R.id.pricePerHour)
    TextView pricePerHour;
    @BindView(R.id.distanceToLocation)
    TextView distanceInKm;

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
        pricePerHour.setText("Price per hour: " + notice.getPricePerHour() + "€/hour");
        distanceInKm.setText("Distance: " + notice.getDistanceInKm() + " Km");
    }

}
