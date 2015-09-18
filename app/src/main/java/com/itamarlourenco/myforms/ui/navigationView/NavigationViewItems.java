package com.itamarlourenco.myforms.ui.navigationView;

import com.itamarlourenco.myforms.R;
import com.itamarlourenco.myforms.application.App;

import net.steamcrafted.materialiconlib.MaterialDrawableBuilder;

/**
 * Created by itamarlourenco on 16/09/15.3
 * Class NavigationViewItems for create menu.
 */
public enum NavigationViewItems {
    FORMS {
        @Override
        public String toString() {
            return App.getContext().getString(R.string.titleForms);
        }

        @Override
        public MaterialDrawableBuilder.IconValue icon() {
            return MaterialDrawableBuilder.IconValue.LIBRARY_BOOKS;
        }

        @Override
        public boolean show() {
            return true;
        }
    },
    REGISTER {
        public String toString() {
            return App.getContext().getString(R.string.titleRegister);
        }

        @Override
        public MaterialDrawableBuilder.IconValue icon() {
            return MaterialDrawableBuilder.IconValue.ACCOUNT_CHECK;
        }

        @Override
        public boolean show() {
            return true;
        }
    };

    public abstract MaterialDrawableBuilder.IconValue icon();
    public abstract boolean show();
}
