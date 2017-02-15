package com.andiag.core;

import com.andiag.core.utils.BasePresenter;
import com.andiag.core.utils.PresenterWithRepository;
import com.andiag.core.utils.PresenterWithSingletonRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

/**
 * Created by Canalejas on 15/02/2017.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 16)
public class RepositoryInjectionTest {

    @Test
    public void noInjectionTest() {
        BasePresenter presenter = new BasePresenter();

        assertNull(presenter.getRepository());
    }

    @Test
    public void simpleInjectionTest() {
        PresenterWithRepository presenter = new PresenterWithRepository();

        assertNotNull(presenter.getRepository());
    }

    @Test
    public void singletonInjectionTest() {
        PresenterWithSingletonRepository presenter = new PresenterWithSingletonRepository();

        assertNotNull(presenter.getRepository());
    }

}
