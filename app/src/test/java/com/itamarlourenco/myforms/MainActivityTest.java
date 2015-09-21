package com.itamarlourenco.myforms;

import android.os.Build;
import android.text.TextUtils;

import com.itamarlourenco.myforms.application.BaseActivity;
import com.itamarlourenco.myforms.ui.forms.adapter.FormsFragment;
import com.itamarlourenco.myforms.ui.navigationView.NavigationViewItems;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by itamarlourenco on 18/09/15.
 */
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)
public class MainActivityTest {
    private MainActivity mActivity;
    private BaseActivity mBaseActivity;

    @Before
    public void setup(){
        mActivity = Robolectric.setupActivity(MainActivity.class);
        mBaseActivity = Robolectric.setupActivity(BaseActivity.class);
    }

    @Test
    public void testCheckToolbar() throws Exception {
        assertNotNull("Toolbar not found", mActivity.getSupportActionBar());
    }

    @Test
    public void testCheckTitleToolbar() throws Exception {
        assertTrue("Title of Toolbar is null " + mActivity.getSupportActionBar().getTitle(), !TextUtils.isEmpty(mActivity.getSupportActionBar().getTitle()));
    }

    @Test
    public void testNavigationViewCustom() throws Exception {
        assertNotNull("Toolbar not found", mBaseActivity.getNavigationViewCustom());
    }

    @Test
    public void testCheckTotalNavigationViewCustomItems() throws Exception {
        List<NavigationViewItems> mMenus = Arrays.asList(NavigationViewItems.values());
        assertEquals(mBaseActivity.getNavigationViewCustom().getMenuRecyclerView().getAdapter().getItemCount(), mMenus.size());
    }

    @Test
    public void testCheckIfFirstFragmentIsFormsFragments() throws Exception {
        assertTrue("First fragment FormsFragment", mActivity.mCurrentFragment instanceof FormsFragment);
    }
}

