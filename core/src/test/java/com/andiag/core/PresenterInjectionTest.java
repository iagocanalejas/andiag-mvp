package com.andiag.core;

import com.andiag.core.utils.TestActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class PresenterInjectionTest {

    ActivityController controller;

    @Before
    public void setUp() {
        controller = Robolectric.buildActivity(TestActivity.class);
    }

    @Test
    public void presenterInjectionTest() throws Exception {
        TestActivity activity = (TestActivity) controller.get();

        assertNull(activity.getPresenter());

        controller.create();

        assertNotNull(activity.getPresenter());
    }

}