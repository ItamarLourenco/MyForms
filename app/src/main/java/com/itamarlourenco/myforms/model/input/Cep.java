package com.itamarlourenco.myforms.model.input;

import android.content.Context;

import com.itamarlourenco.myforms.model.input.validations.CpfValidation;

/**
 * Created by itamarlourenco on 22/09/15.
 */
public class Cep extends Varchar{
    public Cep(Context context) {
        super(context);
    }

    @Override
    public void setValue(Object value) {
        super.setValue(clearString(value));
    }

    @Override
    protected String mask() {
        return "#####-###";
    }

    @Override
    protected String regexToValidation() {
        return "\\d{5}-\\d{3}";
    }
}
