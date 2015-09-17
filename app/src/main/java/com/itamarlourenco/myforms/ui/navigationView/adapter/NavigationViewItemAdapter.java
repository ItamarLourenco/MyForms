package com.itamarlourenco.myforms.ui.navigationView.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.itamarlourenco.myforms.R;
import com.itamarlourenco.myforms.ui.navigationView.NavigationViewItens;
import com.itamarlourenco.myforms.utils.Logger;
import com.itamarlourenco.myforms.utils.api.custom.MaterialIconViewCustom;

import java.util.Arrays;
import java.util.List;

/**
 * Created by itamarlourenco on 16/09/15.
 */
public class NavigationViewItemAdapter extends RecyclerView.Adapter<NavigationViewItemAdapter.CustomViewHolder>{

    private List<NavigationViewItens> mMenus = Arrays.asList(NavigationViewItens.values());
    private int lastPosition = -1;
    private Context mContext;

    public NavigationViewItemAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_navigation_view, viewGroup, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        NavigationViewItens item = mMenus.get(i);
        if (customViewHolder != null && item != null) {
            if (!item.show()) {
                return;
            }

            customViewHolder.text.setText(Html.fromHtml(item.toString()));
            if (item.icon() != null) {
                customViewHolder.icon.setIcon(item.icon());
            }

            setAnimation(customViewHolder.text, i);
        }
    }

    @Override
    public int getItemCount() {
        return (mMenus != null ? mMenus.size() : 0);
    }

    private void setAnimation(View viewToAnimate, int position) {
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(mContext, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
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