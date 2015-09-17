package com.itamarlourenco.myforms.ui.navigationView;

import com.itamarlourenco.myforms.R;
import com.itamarlourenco.myforms.application.App;

/**
 * Created by itamarlourenco on 16/09/15.
 */
public enum NavigationViewItens {
    FORMS {
        @Override
        public String toString() {
            return App.getContext().getString(R.string.titleForms);
        }
    },
    REGISTER {
        public String toString() {
            return App.getContext().getString(R.string.titleRegister);
        }
    }
}
