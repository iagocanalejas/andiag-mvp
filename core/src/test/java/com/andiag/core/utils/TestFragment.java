package com.andiag.core.utils;

import com.andiag.core.annotations.Presenter;
import com.andiag.core.presenters.AIPresenter;
import com.andiag.core.views.AIFragment;

/**
 * Created by Canalejas on 11/02/2017.
 */
@Presenter(presenter = TestPresenter.class)
public class TestFragment extends AIFragment<TestPresenter> {
    public AIPresenter getPresenter() {
        return mPresenter;
    }
}
