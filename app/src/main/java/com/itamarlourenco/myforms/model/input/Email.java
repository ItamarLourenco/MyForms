package com.itamarlourenco.myforms.model.input;

import android.content.Context;

/**
 * Created by itamarlourenco on 22/09/15.
 */
public class Email extends Varchar{
    public Email(Context context) {
        super(context);
    }

    @Override
    protected String regexToValidation() {
        return "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    }
}
