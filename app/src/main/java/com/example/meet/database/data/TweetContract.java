package com.example.meet.database.data;

import android.provider.BaseColumns;

/**
 * Created by Meet on 3/24/2017.
 */
public final class TweetContract {

    private TweetContract() {}

    public static class TweetEntry implements BaseColumns {

        public static final String TABLE_NAME = "tweets";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_POST = "post";
        public static final String COLUMN_IMAGE_ID = "imageId";

    }

}

