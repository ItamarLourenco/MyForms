package com.itamarlourenco.myforms.model.input;

/**
 * Created by itamarlourenco on 22/09/15.
 */
public class Phone extends InputNumber {
    @Override
    public void setValue(Object value) {
        super.setValue(getNumber(value));
    }

    @Override
    protected String mask() {
        String value = getValue();
        if(value != null){
            if(value.length() == 10){
                return "(##) ####-####";
            }
        }
        return "(##) #####-####";
    }

    @Override
    protected String regexToValidation() {
        return "^(\\([0-9]{2}\\))\\s([9]{1})?([0-9]{4})-([0-9]{4})$";
    }
}
