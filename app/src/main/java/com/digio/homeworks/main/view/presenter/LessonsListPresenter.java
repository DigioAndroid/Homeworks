package com.digio.homeworks.main.view.presenter;

import com.digio.homeworks.main.view.adapter.NoticeViewHolder;
import com.digio.homeworks.main.view.model.Notice;
import com.digio.homeworks.profile.view.model.Profile;
import com.digio.homeworks.profile.view.model.Rate;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import static java.lang.Double.NaN;

public class LessonsListPresenter {

    private LessonsListPresenter.View lessonsListView;
    private DatabaseReference noticeReference;
    private DatabaseReference profileReference;
    private DatabaseReference rateReference;

    public LessonsListPresenter(LessonsListPresenter.View lessonsListView) {
        this.lessonsListView = lessonsListView;
    }

    public void setDatabaseReferences() {
        noticeReference = FirebaseDatabase.getInstance().getReference("notice");
        profileReference = FirebaseDatabase.getInstance().getReference("profile");
        rateReference = FirebaseDatabase.getInstance().getReference("rate");
    }

    /**
     * Get notice database reference
     * @return
     */
    public DatabaseReference getNoticeReference() {
        return noticeReference;
    }

    /**
     * Get notice database reference
     * @return
     */
    public DatabaseReference getProfileReference() {
        return profileReference;
    }

    /**
     * Get rate database reference
     * @return
     */
    public DatabaseReference getRateReference() {
        return rateReference;
    }

    /**
     * Get teacher information stored in database
     * @param holder
     * @param notice
     */
    public void setNoticeInfo(final NoticeViewHolder holder, final Notice notice) {
        // Get teacher email and select the corresponding profile from database
        String email = notice.getTeacherEmail();
        Query query = getProfileReference().orderByChild("email").equalTo(email);

        // Read query results
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get profile from snapshot
                DataSnapshot snapshot = dataSnapshot.getChildren().iterator().next();
                Profile profile = snapshot.getValue(Profile.class);

                // Once profile is received, get rate information
                setNoticeRateInfo(holder, notice, profile);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    /**
     * Get teacher rates stored in database
     * @param holder
     * @param notice
     * @param profile
     */
    public void setNoticeRateInfo(final NoticeViewHolder holder, final Notice notice, final Profile profile) {
        // Get teacher email and select the corresponding rates from database
        String email = notice.getTeacherEmail();
        Query query = getRateReference().orderByChild("teacherEmail").equalTo(email);

        // Read query results
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // If the teacher has not rates
                if(dataSnapshot.getChildrenCount() == 0) {
                    holder.bindNotice(notice, profile, 0);
                    return;
                }

                // Calculate teacher's rate score
                double rateScore = 0;
                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Rate rate = snapshot.getValue(Rate.class);
                    rateScore += (double)rate.getRate();
                }
                rateScore /= dataSnapshot.getChildrenCount();

                // Fill ViewHolder with notice, profile and rate information
                holder.bindNotice(notice, profile, rateScore);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public interface View {

    }
}
