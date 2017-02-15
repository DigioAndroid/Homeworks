package com.digio.homeworks.main.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.digio.homeworks.R;
import com.digio.homeworks.main.view.adapter.NoticeViewHolder;
import com.digio.homeworks.main.view.interfaces.LessonsListView;
import com.digio.homeworks.main.view.model.Notice;
import com.digio.homeworks.main.view.presenter.LessonsListPresenter;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LessonsListFragment extends Fragment implements LessonsListView{

    @BindView(R.id.lessonsList) RecyclerView list;
    private FirebaseRecyclerAdapter lessonsListAdapter;
    private LessonsListPresenter lessonsListPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lessons_list, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLessonsListPresenter().onActivityCreated();

        // Initialize adapter and fill ViewHolder when required
        lessonsListAdapter = new FirebaseRecyclerAdapter<Notice, NoticeViewHolder>(
                Notice.class, R.layout.item_notice, NoticeViewHolder.class, lessonsListPresenter.getNoticeReference()) {
            @Override
            protected void populateViewHolder(NoticeViewHolder viewHolder, Notice notice, int position) {
                viewHolder.bindNotice(notice);
            }
        };

        // Set RecyclerView adapter and LayoutManager
        list.setAdapter(lessonsListAdapter);
        list.setHasFixedSize(false);
        list.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
    }

    /**
     * Get LessonsListPresenter instance creating it if needed
     * @return
     */
    public LessonsListPresenter getLessonsListPresenter() {
        if(lessonsListPresenter == null) {
            lessonsListPresenter = new LessonsListPresenter(this);
        }
        return lessonsListPresenter;
    }
}
