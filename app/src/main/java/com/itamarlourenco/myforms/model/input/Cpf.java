package com.itamarlourenco.myforms.model.input;

import com.itamarlourenco.myforms.model.input.validations.CpfValidation;

/**
 * Created by itamarlourenco on 21/09/15.
 */
public class Cpf extends Text {
    /**
     * Regex to CPF if necessary
     * "(^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2})|(^\\d{3}\\d{3}\\d{3}\\d{2})$"
     */

    @Override
    public void setValue(Object value) {
        super.setValue(String.valueOf(value).replaceAll("[^0-9]",""));
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
