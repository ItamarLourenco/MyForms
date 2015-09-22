package com.itamarlourenco.myforms.model.input;

import android.os.Build;

import com.itamarlourenco.myforms.BuildConfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by itamarlourenco on 21/09/15.
 */
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)
public class NumberTest {

    @Test
    public void testNumberIsValid() throws Exception {
        InputNumber number = new InputNumber();
        number.setValue(123);
        assertTrue("Validation number is not validate", number.isValidate());
    }

    @Test
    public void testNumberIsNotValid() throws Exception {
        InputNumber number = new InputNumber();
        number.setValue("myform123");
        assertFalse("Validation number is validate", number.isValidate());
    }

    @Test
    public void testGetNumber() throws Exception {
        InputNumber number = new InputNumber();
        number.setValue("myform123");
        assertNotNull("Method get number return NULL", number.getNumber());
        assertTrue("Method get number not work", number.getNumber() == 123L);
    }
}
