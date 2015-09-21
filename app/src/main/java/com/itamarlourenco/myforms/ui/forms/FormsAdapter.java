package com.itamarlourenco.myforms.ui.forms;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.itamarlourenco.myforms.R;
import com.itamarlourenco.myforms.model.form.Form;

import java.util.List;

/**
 * Created by itamarlourenco on 18/09/15.
 */
public class FormsAdapter extends RecyclerView.Adapter<FormsAdapter.HolderView> {
    private List<Form> mForms;

    public FormsAdapter(List<Form> mForms) {
        this.mForms = mForms;
    }

    @Override
    public HolderView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.forms_cardview, parent, false);
        return new HolderView(view);
    }

    @Override
    public void onBindViewHolder(HolderView holder, int position) {
        Form form = mForms.get(position);
        if (form != null) {
            holder.name.setText(Html.fromHtml(form.getName()));
            holder.description.setText(Html.fromHtml(form.getDescription()));
            holder.tag.setText(Html.fromHtml(form.getTag()));
        }
    }

    @Override
    public int getItemCount() {
        return (mForms == null ? 0 : mForms.size());
    }

    public class HolderView extends RecyclerView.ViewHolder {
        protected TextView name;
        protected TextView description;
        protected TextView tag;

        public HolderView(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
            tag = (TextView) itemView.findViewById(R.id.tag);
        }
    }
}
