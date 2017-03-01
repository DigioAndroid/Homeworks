package com.digio.homeworks.main.view.adapter;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.digio.homeworks.R;
import com.digio.homeworks.main.view.model.Notice;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NoticeViewHolder extends RecyclerView.ViewHolder {

    // Instance variables
    @BindView(R.id.lyNoticeItem) RelativeLayout lyNoticeItem;
    @BindView(R.id.noticeTitle) TextView title;
    @BindView(R.id.teacherAvatar) ImageView icon;
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

        Resources res = lyNoticeItem.getContext().getResources();
        pricePerHour.setText(res.getString(R.string.price_per_hour, notice.getPricePerHour()));
        distanceInKm.setText(res.getString(R.string.distance_in_km, notice.getDistanceInKm()));
    }

    /**
     * Get Notice clicked and passed it
     * @param v
     */
    @OnClick(R.id.lyNoticeItem)
    public void onClick(View v) {
        // TODO: Implement
    }

}
