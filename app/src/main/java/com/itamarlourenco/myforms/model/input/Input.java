package com.itamarlourenco.myforms.model.input;

import android.text.TextUtils;

/**
 * Created by itamarlourenco on 21/09/15.
 */
public abstract class Input {
    private String name;
    private String value;
    private String mask;
    private int maxLength = 50;
    private boolean validate = false;
    private String regex;

    public String getName() {
        return name;
    }

    public String getMask() {
        return mask;
    }

    public String getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = String.valueOf(value);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxLenght(int maxLength){
        this.maxLength = maxLength;
    }

    public int getMaxLenght(){
        return this.maxLength;
    }

    public boolean isValidate(){
        if(getRegex() == null){
            return false;
        }

        String valueString = String.valueOf(getValue());
        if(TextUtils.isEmpty(valueString)){
            return false;
        }

        return valueString.matches(getRegex());
    }

    public Long getNumber() {
        String valueString = String.valueOf(getValue());
        if(!TextUtils.isEmpty(valueString)){
            String value = valueString.replaceAll("[^0-9]","");
            return Long.parseLong(value);
        }
        return 0L;
    }

    protected abstract String setMask();
    protected abstract String getRegex();
}
