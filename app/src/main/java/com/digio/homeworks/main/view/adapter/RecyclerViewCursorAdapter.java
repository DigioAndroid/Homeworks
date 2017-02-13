package com.digio.homeworks.main.view.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;

public abstract class RecyclerViewCursorAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    private Context context;
    private Cursor cursor;
    private boolean dataValid;
    private int rowIdColumn;

    public RecyclerViewCursorAdapter(Context context, Cursor cursor) {
        this.context = context;
        this.cursor = cursor;
        dataValid = cursor != null;
        rowIdColumn = dataValid ? cursor.getColumnIndexOrThrow("_id") : -1;

        setHasStableIds(true);
    }

    @Override
    public void onBindViewHolder(VH viewHolder, int position) {
        if (!dataValid) {
            throw new IllegalStateException("This should only be called when the cursor is valid");
        }
        if (!cursor.moveToPosition(position)) {
            throw new IllegalStateException("Couldn't move cursor to position " + position);
        }
        onBindViewHolder(viewHolder, cursor);
    }

    public abstract void onBindViewHolder(VH viewHolder, Cursor cursor);

    public Cursor getCursor() {
        return cursor;
    }

    @Override
    public int getItemCount() {
        if (dataValid && cursor != null) {
            return cursor.getCount();
        }
        return 0;
    }

    @Override
    public long getItemId(int position) {
        if (dataValid && cursor != null && cursor.moveToPosition(position)) {
            return cursor.getLong(rowIdColumn);
        }
        return 0;
    }

    /**
     * Change the underlying cursor to a new cursor. If there is an existing cursor it will be
     * closed.
     */
    public void changeCursor(Cursor cursor) {
        Cursor old = swapCursor(cursor);
        if (old != null) {
            old.close();
        }
    }

    public Cursor swapCursor(Cursor newCursor) {
        if (newCursor == cursor) {
            return null;
        }
        Cursor oldCursor = cursor;
        cursor = newCursor;
        if (newCursor != null) {
            rowIdColumn = newCursor.getColumnIndexOrThrow("_id");
            dataValid = true;
            // notify the observers about the new cursor
            notifyDataSetChanged();
        } else {
            rowIdColumn = -1;
            dataValid = false;
            // notify the observers about the lack of a data set
            notifyItemRangeRemoved(0, getItemCount());
        }
        return oldCursor;
    }

    public CharSequence convertToString(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }
}
