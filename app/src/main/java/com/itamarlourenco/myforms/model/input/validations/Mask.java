package com.itamarlourenco.myforms.model.input.validations;

/**
 * Created by itamarlourenco on 22/09/15.
 */
public class Mask {
    private String mask;
    private String value;
    private boolean isUpdating;
    private String old = "";

    public Mask(String mask, String value) {
        this.mask = mask;
        this.value = value;
    }

    public static String unmask(String s) {
        return s.replaceAll("[.]", "").replaceAll("[-]", "")
                .replaceAll("[/]", "").replaceAll("[(]", "")
                .replaceAll("[)]", "");
    }

    public String getValueWithMask(){
        String str = Mask.unmask(value.toString());
        String mascara = "";
        if (isUpdating) {
            old = str;
            isUpdating = false;
            return null;
        }

        int i = 0;
        for (char m : mask.toCharArray()) {
            if (m != '#' && str.length() > old.length()) {
                mascara += m;
                continue;
            }
            try {
                mascara += str.charAt(i);
            } catch (Exception e) {
                break;
            }
            i++;
        }
        isUpdating = true;

        return mascara;
    }
}
