package com.itamarlourenco.myforms.application;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;

import com.itamarlourenco.myforms.R;
import com.itamarlourenco.myforms.ui.navigationView.NavigationViewCustom;

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

    /**
     * Create toolbar
     */
    protected void handleToolbar() {
        handleToolbar(getString(R.string.app_name));
    }

    protected void handleToolbar(String title) {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) {
            if (!TextUtils.isEmpty(title)) {
                mToolbar.setTitle(title);
            }
            setSupportActionBar(mToolbar);
        }
    }

    /**
     * Set title for toolbar
     * @param title
     */
    public static void setTitle(String title) {
        if (mToolbar != null && !TextUtils.isEmpty(title)) {
            mToolbar.setTitle(title);
        }
    }

    /**
     * Create navigation view
     */
    public void handleNavigationView() {
        mNavigationViewCustom = (NavigationViewCustom) findViewById(R.id.navigationView);
        if (mNavigationViewCustom != null) {
            RecyclerView menuRecyclerView = (RecyclerView) mNavigationViewCustom.findViewById(R.id.menuNavigationView);
            if(menuRecyclerView != null){
                mNavigationViewCustom.setRecycleView(menuRecyclerView);
                mNavigationViewCustom.createMenuListView(getApplicationContext());
            }
        }
    }

    /**
     * Get Navigation view custom
     */
    public NavigationViewCustom getNavigationViewCustom(){
        return mNavigationViewCustom;
    }
}
