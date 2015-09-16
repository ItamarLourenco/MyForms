package com.example.itamarlourenco.myforms.utils;

import android.util.Log;
import android.widget.Toast;

import com.example.itamarlourenco.myforms.application.App;

/**
 * Created by itamarlourenco on 15/09/15.
 */
public class Logger {

    private static final String TAG = "MyForms - ";

    public static void d(Object message) {
        Log.d(TAG, String.valueOf(message));
    }

    public static void e(Object message) {
        Log.e(TAG, String.valueOf(message));
    }

    public static void i(Object message) {
        Log.i(TAG, String.valueOf(message));
    }

    public static void w(Object message) {
        Log.w(TAG, String.valueOf(message));
    }

    public static void v(Object message) {
        Log.v(TAG, String.valueOf(message));
    }

    public static void t(Object message) {
        t(message, false);
    }

    public static void t(Object message, boolean type) {
        try {
            String str;
            if (type) {
                str = message.getClass().getName() + " - " + String.valueOf(message);
            } else {
                str = String.valueOf(message);
            }

            Toast.makeText(App.getContext(), str, Toast.LENGTH_LONG).show();
            d(String.valueOf(message));
        } catch (RuntimeException e) {
            //Nothing
        }
    }
}
