package com.itamarlourenco.myforms.model.input;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.EditText;

import com.itamarlourenco.myforms.model.input.exceptions.MaskException;
import com.itamarlourenco.myforms.model.input.validations.Mask;

/**
 * Created by itamarlourenco on 21/09/15.
 */
public abstract class Input extends EditText {
    private String name;
    private String value;

    public Input(Context context) {
        super(context);
    }

    public String getName() {
        return name;
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

    public String getValueWithMask() throws MaskException {
        if(mask() != null){
            return new Mask(mask(), getValue()).getValueWithMask();
        }
        throw new MaskException("This method is not have mask");
    }

    public boolean isValidateWithoutMask() throws MaskException {
        return isValidate(false);
    }

    public boolean isValidate() throws MaskException {
        return isValidate(true);
    }

    public boolean isValidate(boolean withMask) throws MaskException {
        if(validation() != null){
            return validation();
        }

        if(regexToValidation() == null){
            return true;
        }

        String valueString;
        if(withMask){
            try{
                valueString = String.valueOf(getValueWithMask());
            }catch (MaskException e){
                valueString = String.valueOf(getValue());
            }
        }else{
            valueString = String.valueOf(getValue());
        }

        if(TextUtils.isEmpty(valueString)){
            return false;
        }

        return valueString.matches(regexToValidation());
    }

    public Long getNumber() {
        String valueString = String.valueOf(getValue());
        if(!TextUtils.isEmpty(valueString)){
            String value = valueString.replaceAll("[^0-9]","");
            return Long.parseLong(value);
        }
        return 0L;
    }

    public Long getNumber(Object value) {
        String valueString = String.valueOf(value);
        if(!TextUtils.isEmpty(valueString)){
            String v = valueString.replaceAll("[^0-9]","");
            return Long.parseLong(v);
        }
        return 0L;
    }

    public String getString(){
        String valueString = String.valueOf(getValue());
        if(!TextUtils.isEmpty(valueString)){
            String value = valueString.replaceAll("[0-9]", "");
            return value;
        }
        return null;
    }

    public String clearString(Object value){
        String v = String.valueOf(value);
        return v.replaceAll("[.]", "").replaceAll("[-]", "")
                .replaceAll("[/]", "").replaceAll("[(]", "")
                .replaceAll("[)]", "");
    }



    protected String mask(){
        return null;
    }
    protected int maxLength(){
        return Integer.MAX_VALUE;
    }
    protected String regexToValidation(){
        return null;
    }
    protected Boolean validation(){ return null; }
}
