package com.digio.homeworks.main.view.presenter;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import com.digio.homeworks.main.view.adapter.LessonsListAdapter;
import com.digio.homeworks.main.view.fragment.LessonsListFragment;
import com.digio.homeworks.main.view.interfaces.LessonsListView;

public class LessonsListPresenter implements LoaderManager.LoaderCallbacks<Cursor>{

    private LessonsListView lessonsListView;
    private LessonsListAdapter adapter;
    Bundle providerBundle;

    public LessonsListPresenter(LessonsListView lessonsListView) {
        this.lessonsListView = lessonsListView;
    }

    public void onActivityCreated() {
        // Create LessonsListAdapter for RecyclerView
        adapter = new LessonsListAdapter(((LessonsListFragment)lessonsListView).getContext());

        // Initialize CursorLoader's bundle
        providerBundle = new Bundle();

        // Create CursorLoader using LoaderManager
        ((LessonsListFragment)lessonsListView).getLoaderManager().initLoader(1, providerBundle, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        adapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        adapter.swapCursor(null);
    }
}
