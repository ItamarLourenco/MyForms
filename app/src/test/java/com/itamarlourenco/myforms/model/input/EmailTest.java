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
 * Created by itamarlourenco on 22/09/15.
 */
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)
public class EmailTest {
    private MainActivity mActivity;

    @Before
    public void setup(){
        mActivity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void testValidationEmail() throws Exception {
        Email email = new Email(mActivity);
        email.setValue("itamar.developer@gmail.com");
        assertTrue("This email is not valid = " + email.getValue(), email.isValidate());
    }

    @Test
    public void testValidationNotEmail() throws Exception {
        Email email = new Email(mActivity);
        email.setValue("itamar.developer$gmail.com");
        assertFalse("This email is valid = " + email.getValue(), email.isValidate());
    }
}
