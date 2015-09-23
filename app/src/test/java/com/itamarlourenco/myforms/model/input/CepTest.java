package com.itamarlourenco.myforms.model.input;

import android.content.Context;
import android.os.Build;

import com.itamarlourenco.myforms.BuildConfig;
import com.itamarlourenco.myforms.MainActivity;
import com.itamarlourenco.myforms.application.BaseActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by itamarlourenco on 22/09/15.
 */
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)
public class CepTest {
    private MainActivity mActivity;

    @Before
    public void setup(){
        mActivity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void testValidationCep() throws Exception {
        Cep cep = new Cep(mActivity);
        cep.setValue("03451-000");
        assertTrue("This cep is not valid = " + cep.getValueWithMask(), cep.isValidate());
    }

    @Test
    public void testValidationNotCep() throws Exception {
        Cep cep = new Cep(mActivity);
        cep.setValue("03451-00");
        assertFalse("This cep is valid = " + cep.getValueWithMask(), cep.isValidate());
    }

    @Test
    public void testCheckMaskOfCep() throws Exception {
        Cep cep = new Cep(mActivity);
        cep.setValue("03451000");
        assertTrue("This cep MASK is NOT valid = " + cep.getValueWithMask(), cep.getValueWithMask().equals("03451-000"));
    }
}
