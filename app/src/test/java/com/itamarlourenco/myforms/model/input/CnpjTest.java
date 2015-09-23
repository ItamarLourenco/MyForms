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
public class CnpjTest {
    private MainActivity mActivity;

    @Before
    public void setup(){
        mActivity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void testValidationCnpj() throws Exception {
        Cnpj cnpj = new Cnpj(mActivity);
        cnpj.setValue("66.424.722/0001-81");
        assertTrue("This cnpj is not valided = " + cnpj.getValueWithMask(), cnpj.isValidate());
    }

    @Test
    public void testValidationNotCnpj() throws Exception {
        Cnpj cnpj = new Cnpj(mActivity);
        cnpj.setValue("66.424.722/0001-80");
        assertFalse("This cnpj is valided = " + cnpj.getValueWithMask(), cnpj.isValidate());
    }

    @Test
    public void testCheckMaskOfCnpj() throws Exception {
        Cnpj cnpj = new Cnpj(mActivity);
        cnpj.setValue("66424722000180");
        assertTrue("This cnpj MASK is NOT valided = " + cnpj.getValueWithMask(), cnpj.getValueWithMask().equals("66.424.722/0001-80"));
    }
}
