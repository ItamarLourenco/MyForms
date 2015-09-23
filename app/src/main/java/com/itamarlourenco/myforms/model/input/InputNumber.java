package com.itamarlourenco.myforms.model.input;

import android.content.Context;

/**
 * Created by itamarlourenco on 21/09/15.
 */
public class InputNumber extends Input {

    public InputNumber(Context context) {
        super(context);
    }

    @Override
    protected String regexToValidation() {
        return "\\d+";
    }
}
