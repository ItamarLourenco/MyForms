package com.example.itamarlourenco.myforms.ui.NavigationView.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.itamarlourenco.myforms.R;
import com.example.itamarlourenco.myforms.ui.NavigationView.NavigationViewItens;
import com.example.itamarlourenco.myforms.utils.Logger;

import java.util.Arrays;
import java.util.List;

/**
 * Created by itamarlourenco on 16/09/15.
 */
public class NavigationViewItensAdapter extends BaseAdapter {
    private Context mContext;
    private List<NavigationViewItens> mMenus = Arrays.asList(NavigationViewItens.values());

    public NavigationViewItensAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        if(mMenus != null){
            return mMenus.size();
        }
        return 0;
    }

    @Override
    public NavigationViewItens getItem(int position) {
        try{
            return mMenus.get(position);
        }catch(IndexOutOfBoundsException e){
            Logger.e(e);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        NavigationViewItens item = getItem(position);
        if(rowView != null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.adapter_navigation_view, parent, false);
        }
        return null;
    }
}
