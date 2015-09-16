package com.example.itamarlourenco.myforms.ui.NavigationView;

import android.content.Context;
import android.support.design.widget.NavigationView;
import android.util.AttributeSet;
import android.widget.ListView;

import com.example.itamarlourenco.myforms.ui.NavigationView.adapter.NavigationViewItensAdapter;

/**
 * Created by itamarlourenco on 16/09/15.
 */
public class NavigationViewCustom extends NavigationView {
    private ListView mMenuListView;

    public NavigationViewCustom(Context context) {
        super(context);
    }

    public NavigationViewCustom(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NavigationViewCustom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ListView getListView() {
        return mMenuListView;
    }

    public void setListView(ListView menuListView){
        mMenuListView = menuListView;
    }

    public void createMenuListView(Context context) {
        mMenuListView.setAdapter(new NavigationViewItensAdapter(context));
    }
}
