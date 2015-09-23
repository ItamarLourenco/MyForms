package com.itamarlourenco.myforms.model.input;

import android.os.Build;

import com.itamarlourenco.myforms.BuildConfig;
import com.itamarlourenco.myforms.MainActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by itamarlourenco on 21/09/15.
 */
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)
public class PhoneTest {

    private MainActivity mActivity;

    @Before
    public void setup(){
        mActivity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void testPhoneIsValid() throws Exception {
        Phone phone = new Phone(mActivity);
        phone.setValue("21975009414");
        assertTrue("Validation phone is not validate = " + phone.getValueWithMask(), phone.isValidate());
    }

    @Test
    public void testValidationNotPhone() throws Exception {
        Phone phone = new Phone(mActivity);
        phone.setValue("219750094");
        assertFalse("Validation phone is validate = " + phone.getValueWithMask(), phone.isValidate());
    }

    @Test
    public void testCheckMaskOfPhone() throws Exception {
        Phone phone = new Phone(mActivity);
        phone.setValue("21975009414");
        assertTrue("This phone MASK is NOT valided = " + phone.getValueWithMask(), phone.getValueWithMask().equals("(21) 97500-9414"));

        Phone phone2 = new Phone(mActivity);
        phone2.setValue("2175009414");
        assertTrue("This phone MASK is NOT valided = " + phone2.getValueWithMask(), phone2.getValueWithMask().equals("(21) 7500-9414"));
    }
}
