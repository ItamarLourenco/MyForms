package com.itamarlourenco.myforms.ui.forms.adapter;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itamarlourenco.myforms.R;
import com.itamarlourenco.myforms.model.form.FormWrapper;
import com.itamarlourenco.myforms.model.input.InputNumber;
import com.itamarlourenco.myforms.ui.forms.FormsAdapter;
import com.itamarlourenco.myforms.utils.Logger;
import com.itamarlourenco.myforms.utils.api.custom.MaterialIconViewCustom;

import net.steamcrafted.materialiconlib.MaterialDrawableBuilder;

public class FormsFragment extends Fragment {
    private FormWrapper mFormWrapper = new FormWrapper();
    private RecyclerView mFormCardList = null;
    private FloatingActionButton mFloatingActionButton = null;

    public static FormsFragment newInstance() {
        return new FormsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forms, container, false);
        mFormCardList = (RecyclerView) view.findViewById(R.id.formCardList);
        mFloatingActionButton = (FloatingActionButton) view.findViewById(R.id.floatingActionButton);
        handleFormCardList();
        handleFloatingActionButton();
        return view;
    }

    private void handleFormCardList() {
        if(mFormCardList != null){
            mFormCardList.setHasFixedSize(true);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            mFormCardList.setLayoutManager(linearLayoutManager);
            mFormCardList.setAdapter(new FormsAdapter(mFormWrapper.getList()));
        }
    }

    private void handleFloatingActionButton() {
        if(mFloatingActionButton != null){
            MaterialIconViewCustom iconFloatingActionButton = new MaterialIconViewCustom(getActivity());
            iconFloatingActionButton.setIcon(MaterialDrawableBuilder.IconValue.PENCIL);
            iconFloatingActionButton.setColor(Color.WHITE);
            mFloatingActionButton.setImageDrawable(iconFloatingActionButton.getDrawable());
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        InputNumber number = new InputNumber();
        number.setValue(100);
        Logger.t(number.isValidate());

        super.onActivityCreated(savedInstanceState);
    }
}
