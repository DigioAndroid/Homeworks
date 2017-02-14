package com.digio.homeworks.main.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.digio.homeworks.R;
import com.digio.homeworks.main.view.adapter.LessonsListAdapter;
import com.digio.homeworks.main.view.interfaces.LessonsListView;
import com.digio.homeworks.main.view.presenter.LessonsListPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LessonsListFragment extends Fragment implements LessonsListView{

    @BindView(R.id.lessonsList) RecyclerView list;
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
    }

    /**
     * Set RecyclerView adapter and layout
     * @param adapter
     */
    public void setListConfiguration(LessonsListAdapter adapter) {
        list.setAdapter(adapter);
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
