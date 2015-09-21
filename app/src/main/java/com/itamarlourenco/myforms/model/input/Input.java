package com.itamarlourenco.myforms.model.input;

/**
 * Created by itamarlourenco on 21/09/15.
 */
public abstract class Input {
    protected String name;
    protected int value;
    protected String mask;
    protected int maxLength = 50;
    protected boolean validate = false;
    protected String regex;

    public String getName() {
        return name;
    }

    public String getMask() {
        return mask;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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
        return getRegex().matches(String.valueOf(getValue()));
    }


    protected abstract String setMask();
    protected abstract String getRegex();
}
