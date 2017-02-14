package com.andiag.core;

import com.andiag.core.presenters.ViewState;
import com.andiag.core.utils.PresenterActivity;
import com.andiag.core.utils.PresenterFragment;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.support.v4.SupportFragmentController;
import org.robolectric.util.ActivityController;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 19)
public class PresenterInjectionTest {

    ActivityController mActivityController;
    SupportFragmentController<PresenterFragment> mFragmentController;

    @Before
    public void setUp() {
        mActivityController = Robolectric.buildActivity(PresenterActivity.class);
        mFragmentController = SupportFragmentController.of(new PresenterFragment());
    }

    @Test
    public void injectPresenterOnActivityTest() throws Exception {
        PresenterActivity activity = (PresenterActivity) mActivityController.get();

        assertNull(activity.getPresenter());

        mActivityController.create();

        assertNotNull(activity.getPresenter());
        assertEquals(activity.getPresenter().getViewState(), ViewState.ATTACHED);
    }

    @Test
    public void injectPresenterOnFragmentTest() throws Exception {
        PresenterFragment fragment = mFragmentController.get();

        assertNull(fragment.getPresenter());

        mFragmentController.attach().create();

        assertNotNull(fragment.getPresenter());
        assertEquals(fragment.getPresenter().getViewState(), ViewState.ATTACHED);
    }

}