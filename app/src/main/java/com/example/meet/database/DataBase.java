package com.example.meet.database;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by Meet on 3/29/2017.
 */

public class DataBase extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
        .applicationId("")
        .clientKey("")
        .server("https://parseapi.back4app.com/")
        .build());
    }
}
