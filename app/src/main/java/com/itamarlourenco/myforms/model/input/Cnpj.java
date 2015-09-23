package com.itamarlourenco.myforms.model.input;

import android.content.Context;

import com.itamarlourenco.myforms.model.input.validations.CnpjValidation;

/**
 * Created by itamarlourenco on 22/09/15.
 */
public class Cnpj extends Varchar {
    /**
     * Regex to CNPJ if necessary
     * "(^\\d{2}\\.\\d{3}\\.\\d{2}/\\d{4}-\\d{2})$
     */
    public Cnpj(Context context) {
        super(context);
    }

    @Override
    public void setValue(Object value) {
        super.setValue(clearString(value));
    }

    @Override
    protected String mask() {
        return "##.###.###/####-##";
    }

    @Override
    protected Boolean validation() {
        return CnpjValidation.isValid(getValue());
    }
}
