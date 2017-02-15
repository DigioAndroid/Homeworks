package com.digio.homeworks.main.view.presenter;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import com.digio.homeworks.main.view.fragment.LessonsListFragment;
import com.digio.homeworks.main.view.interfaces.LessonsListView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LessonsListPresenter {

    private LessonsListView lessonsListView;
    private DatabaseReference noticeReference;

    public LessonsListPresenter(LessonsListView lessonsListView) {
        this.lessonsListView = lessonsListView;
    }

    public void onActivityCreated() {
        noticeReference = FirebaseDatabase.getInstance().getReference("notice");
    }

    /**
     * Get notice database reference
     * @return
     */
    public DatabaseReference getNoticeReference() {
        return noticeReference;
    }
}
