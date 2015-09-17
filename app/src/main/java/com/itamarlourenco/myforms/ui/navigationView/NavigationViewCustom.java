package com.itamarlourenco.myforms.ui.navigationView;

import android.content.Context;
import android.support.design.widget.NavigationView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.itamarlourenco.myforms.ui.navigationView.adapter.NavigationViewItemAdapter;

/**
 * Created by itamarlourenco on 16/09/15.
 */
public class NavigationViewCustom extends NavigationView {
    private RecyclerView mMenuRecyclerView;

    public NavigationViewCustom(Context context) {
        super(context);
    }

    public NavigationViewCustom(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NavigationViewCustom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public RecyclerView getMenuRecyclerView() {
        return mMenuRecyclerView;
    }

    public void setRecycleView(RecyclerView recycleView) {
        this.mMenuRecyclerView = recycleView;
    }

    public void createMenuListView(Context context) {
        if(mMenuRecyclerView != null){
            this.mMenuRecyclerView.setHasFixedSize(true);
            LinearLayoutManager mLayoutManager = new LinearLayoutManager(context);
            this.mMenuRecyclerView.setLayoutManager(mLayoutManager);
            this.mMenuRecyclerView.setAdapter(new NavigationViewItemAdapter(context));
        }
    }
}
