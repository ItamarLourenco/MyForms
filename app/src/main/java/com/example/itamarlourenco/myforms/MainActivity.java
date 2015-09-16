package com.example.itamarlourenco.myforms;

import android.os.Bundle;

import com.example.itamarlourenco.myforms.application.BaseActivity;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handleToolbar();
    }

}
