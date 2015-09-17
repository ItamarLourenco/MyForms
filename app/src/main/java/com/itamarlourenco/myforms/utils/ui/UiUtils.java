package com.itamarlourenco.myforms.utils.ui;

import android.content.Context;
import android.view.View;

/**
 * Created by itamarlourenco on 17/09/15.
 */
public class UiUtils {

    /**
     * Method return View with nothing
     * for no add row on listView
     */
    public static View getInvisibleView(Context context){
        return new View(context);
    }
}
