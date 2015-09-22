package com.itamarlourenco.myforms.model.input;

import android.os.Build;

import com.itamarlourenco.myforms.BuildConfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by itamarlourenco on 22/09/15.
 */
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)
public class CpfTest {

    @Test
    public void testValidationCpf() throws Exception {
        Cpf cpf = new Cpf();
        cpf.setValue("399.637.118-71");
        assertTrue("This cpf is not valided = " + cpf.getValueWithMask(), cpf.isValidate());
    }

    @Test
    public void testValidationNotCpd() throws Exception {
        Cpf cpf = new Cpf();
        cpf.setValue("123.456.789-99");
        assertFalse("This cpf is valided = " + cpf.getValueWithMask(), cpf.isValidate());
    }

    @Test
    public void testCheckMaskOfCpf() throws Exception {
        Cpf cpf = new Cpf();
        cpf.setValue("39963711871");
        assertTrue("This cpf MASK is NOT valided = " + cpf.getValueWithMask(), cpf.getValueWithMask().equals("399.637.118-71"));
    }
}
