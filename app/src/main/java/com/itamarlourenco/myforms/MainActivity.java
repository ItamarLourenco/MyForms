package com.itamarlourenco.myforms;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.itamarlourenco.myforms.application.BaseActivity;
import com.itamarlourenco.myforms.ui.forms.adapter.FormsFragment;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handleToolbar();
        handleNavigationView();

        loadForms();
    }

    private void loadForms() {
        setCurrentFragment(FormsFragment.newInstance(), null);
    }

    private void setCurrentFragment(Fragment fragment, String tag){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, fragment, tag);
        fragmentTransaction.commit();
    }
}
