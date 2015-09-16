package com.example.itamarlourenco.myforms.ui;

import com.example.itamarlourenco.myforms.R;
import com.example.itamarlourenco.myforms.application.App;

/**
 * Created by itamarlourenco on 16/09/15.
 */
public enum NavigationView {
    FORMS{
        @Override
        public String toString() {
            return App.getContext().getString(R.string.titleForms);
        }
    }
}
