package com.andiag.core;

import com.andiag.core.utils.PresenterWithRepository;
import com.andiag.core.utils.PresenterWithSingletonRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by Canalejas on 15/02/2017.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 16)
public class RepositoryInjectionTest {

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
