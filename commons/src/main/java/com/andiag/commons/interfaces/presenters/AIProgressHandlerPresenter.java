package com.andiag.commons.interfaces.presenters;

import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

/**
 * Created by Canalejas on 14/12/2016.
 */

public interface AIProgressHandlerPresenter<T>
        extends AIErrorHandlerPresenter,
        AISuccessHandlerPresenter<T> {

    void onProgressChange(@Nullable String message);

    void onProgressChange(@StringRes int resId);

}
