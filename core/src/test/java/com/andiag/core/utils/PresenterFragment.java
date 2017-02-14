package com.andiag.core.utils;

import com.andiag.core.annotations.Presenter;
import com.andiag.core.presenters.AIPresenter;
import com.andiag.core.views.AIFragment;

/**
 * Created by Canalejas on 11/02/2017.
 */
@Presenter(presenter = BasePresenter.class)
public class PresenterFragment extends AIFragment<BasePresenter> {
    public AIPresenter getPresenter() {
        return mPresenter;
    }
}
