package com.example.meet.database;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.meet.database.data.TweetContract;

/**
 * Created by Meet on 3/27/2017.
 */

public class TweetAdapter extends CursorAdapter {

    public TweetAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView name = (TextView) view.findViewById(R.id.text_name);
        name.setText(cursor.getString(cursor.getColumnIndexOrThrow(TweetContract.TweetEntry.COLUMN_NAME)));

        TextView username = (TextView) view.findViewById(R.id.text_username);
        username.setText(cursor.getString(cursor.getColumnIndexOrThrow(TweetContract.TweetEntry.COLUMN_USERNAME)));

        TextView content = (TextView) view.findViewById(R.id.text_content);
        content.setText(cursor.getString(cursor.getColumnIndexOrThrow(TweetContract.TweetEntry.COLUMN_POST)));

        ImageView image = (ImageView) view.findViewById(R.id.image);
        image.setImageResource(cursor.getInt(cursor.getColumnIndexOrThrow(TweetContract.TweetEntry.COLUMN_IMAGE_ID)));

    }
}
