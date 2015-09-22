package com.itamarlourenco.myforms.model.input;

/**
 * Created by itamarlourenco on 21/09/15.
 */
public class InputNumber extends Input {

    @Override
    protected String regexToValidation() {
        return "\\d+";
    }
}
