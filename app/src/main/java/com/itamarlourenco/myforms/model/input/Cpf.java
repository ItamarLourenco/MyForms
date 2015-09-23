package com.itamarlourenco.myforms.model.input;

import android.content.Context;

import com.itamarlourenco.myforms.model.input.validations.CpfValidation;

/**
 * Created by itamarlourenco on 21/09/15.
 */
public class Cpf extends Varchar {
    /**
     * Regex to CPF if necessary
     * "(^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2})|(^\\d{3}\\d{3}\\d{3}\\d{2})$"
     */
    public Cpf(Context context) {
        super(context);
    }

    @Override
    public void setValue(Object value) {
        super.setValue(clearString(value));
    }

    @Override
    protected String mask() {
        return "###.###.###-##";
    }

    @Override
    protected Boolean validation() {
        return CpfValidation.isValid(getValue());
    }
}
