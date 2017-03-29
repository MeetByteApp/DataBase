package com.example.meet.database.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.meet.database.data.TweetContract;

import static android.R.attr.version;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by Meet on 3/24/2017.
 */

public class TweetDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Tweets.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TweetContract.TweetEntry.TABLE_NAME + " (" +
                    TweetContract.TweetEntry._ID + " INTEGER PRIMARY KEY," +
                    TweetContract.TweetEntry.COLUMN_NAME + " TEXT," +
                    TweetContract.TweetEntry.COLUMN_USERNAME + " TEXT," +
                    TweetContract.TweetEntry.COLUMN_POST + " TEXT," +
                    TweetContract.TweetEntry.COLUMN_IMAGE_ID + " INTEGER)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TweetContract.TweetEntry.TABLE_NAME;

    public TweetDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
