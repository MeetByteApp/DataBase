package com.example.meet.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.meet.database.data.TweetContract;
import com.example.meet.database.data.TweetDbHelper;

import java.util.ArrayList;
import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Cursor cursor;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.rootview);
        TweetDbHelper mDbHelper = new TweetDbHelper(getApplicationContext());

        db = mDbHelper.getWritableDatabase();

        DownloadTask task = new DownloadTask();
        task.execute();

        String[] projection = {
                TweetContract.TweetEntry._ID,
                TweetContract.TweetEntry.COLUMN_NAME,
                TweetContract.TweetEntry.COLUMN_USERNAME,
                TweetContract.TweetEntry.COLUMN_POST,
                TweetContract.TweetEntry.COLUMN_IMAGE_ID
        };

        cursor = db.query(
                TweetContract.TweetEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );


        new Handler().post(new Runnable() {
            @Override
            public void run() {

                TweetAdapter adapter = new TweetAdapter(getApplicationContext(), cursor, 0);
                listView.setAdapter(adapter);
            }
        });
    }

    public class DownloadTask extends AsyncTask<String, Void, String> {


        @Override
        protected String doInBackground(String... params) {

            //db.execSQL("DELETE FROM " + TweetContract.TweetEntry.TABLE_NAME);

            ContentValues contentValues2 = new ContentValues();
            contentValues2.put(TweetContract.TweetEntry.COLUMN_NAME, "Meet Thakkar");
            contentValues2.put(TweetContract.TweetEntry.COLUMN_USERNAME, "@that_akwared_guy");
            contentValues2.put(TweetContract.TweetEntry.COLUMN_POST, "Hi, Wassup this is my firts ever Tweet.");
            contentValues2.put(TweetContract.TweetEntry.COLUMN_IMAGE_ID, R.drawable.ic_action_name);

            db.insert(TweetContract.TweetEntry.TABLE_NAME, null, contentValues2);

            return null;
        }
    }
}
