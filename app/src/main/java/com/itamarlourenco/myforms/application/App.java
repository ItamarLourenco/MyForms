package com.itamarlourenco.myforms.application;

import android.app.Application;
import android.content.Context;

import com.activeandroid.ActiveAndroid;

/**
 * Created by itamarlourenco on 15/09/15.
 */
public class App extends Application {
    private static App sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

        ActiveAndroid.initialize(this);
    }

    public static Context getContext() {
        return sInstance;
    }
}
