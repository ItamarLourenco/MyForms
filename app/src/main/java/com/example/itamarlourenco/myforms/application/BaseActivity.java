package com.example.itamarlourenco.myforms.application;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.ListView;

import com.example.itamarlourenco.myforms.R;
import com.example.itamarlourenco.myforms.ui.NavigationView.NavigationViewCustom;

/**
 * Created by itamarlourenco on 15/09/15.
 */
public class BaseActivity extends AppCompatActivity {
    protected static Toolbar mToolbar;
    protected static NavigationViewCustom mNavigationViewCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void handleToolbar(){
        handleToolbar(getString(R.string.app_name));
    }

    protected void handleToolbar(String title){
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) {
            if (!TextUtils.isEmpty(title)) {
                mToolbar.setTitle(title);
            }
            setSupportActionBar(mToolbar);
        }
    }

    public static void setTitle(String title){
        if(mToolbar != null && !TextUtils.isEmpty(title)){
            mToolbar.setTitle(title);
        }
    }

    public void handleNavigationView(){
        mNavigationViewCustom = (NavigationViewCustom) findViewById(R.id.navigationView);
        if(mNavigationViewCustom != null){
            ListView menuListView = (ListView) findViewById(R.id.menuNavigationView);
            mNavigationViewCustom.setListView(menuListView);
            mNavigationViewCustom.createMenuListView(getApplicationContext());
        }
    }
}
