package com.itamarlourenco.myforms.ui.navigationView.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.itamarlourenco.myforms.R;
import com.itamarlourenco.myforms.ui.navigationView.NavigationViewItens;
import com.itamarlourenco.myforms.utils.Logger;
import com.itamarlourenco.myforms.utils.api.custom.MaterialIconViewCustom;
import com.itamarlourenco.myforms.utils.ui.UiUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Created by itamarlourenco on 16/09/15.
 */
public class NavigationViewItemAdapter extends RecyclerView.Adapter<NavigationViewItemAdapter.ViewHolder>{
    private List<NavigationViewItens> mMenus = Arrays.asList(NavigationViewItens.values());
    private static int mShowItem = 1;
    private static int mHideItem = 2;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int type) {
        if(type == mShowItem){
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_navigation_view, viewGroup, false);
            return new CustomViewHolder(view);
        }

        return new ViewHolder(UiUtils.getInvisibleView(viewGroup.getContext()));
    }

    @Override
    public int getItemViewType(int position) {
        NavigationViewItens item = mMenus.get(position);
        if(item != null && item.show()){
            return mShowItem;
        }
        return mHideItem;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        NavigationViewItens item = mMenus.get(i);

        if(viewHolder instanceof CustomViewHolder){
            CustomViewHolder customViewHolder = (CustomViewHolder) viewHolder;

            if (item != null && item.show()) {
                customViewHolder.text.setText(Html.fromHtml(item.toString()));
                if (item.icon() != null) {
                    customViewHolder.icon.setIcon(item.icon());
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return (mMenus != null ? mMenus.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class CustomViewHolder extends ViewHolder implements View.OnClickListener{
        public MaterialIconViewCustom icon;
        public TextView text;

        public CustomViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.icon = (MaterialIconViewCustom) itemView.findViewById(R.id.icon);
            this.text = (TextView) itemView.findViewById(R.id.text);
        }

        @Override
        public void onClick(View v) {
            Logger.t(mMenus.get(getAdapterPosition()));
        }
    }
}