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

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * Created by Canalejas on 15/02/2017.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 16)
public class ViewStateTest {

    ActivityController mActivityController;
    SupportFragmentController<PresenterFragment> mFragmentController;

    @Before
    public void setUp() {
        mActivityController = Robolectric.buildActivity(PresenterActivity.class);
        mFragmentController = SupportFragmentController.of(new PresenterFragment());
    }

    @Test
    public void activityStateFlowTest() throws Exception {
        PresenterActivity activity = (PresenterActivity) mActivityController.get();

        mActivityController.create();
        assertEquals(activity.getPresenter().getViewState(), ViewState.ATTACHED);
        assertNotNull(activity.getPresenter().getView());
        assertEquals(activity.getPresenter().getView(), activity);

        // TODO can't make Robolectric running with AppCompatActivity
//        mActivityController.start().resume();
//        assertEquals(activity.getPresenter().getViewState(), ViewState.CREATED);
//        assertNotNull(activity.getPresenter().getContext());
//        assertEquals(activity.getPresenter().getView(), activity);

    }

}
