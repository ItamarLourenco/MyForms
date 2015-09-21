package com.itamarlourenco.myforms.model.input;

/**
 * Created by itamarlourenco on 21/09/15.
 */
public class Cpf extends InputNumber {


    @Override
    protected String setMask() {
        return "###.###.###-##";
    }
}
