package com.andiag.commons.interfaces.presenters;

import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

/**
 * Created by Canalejas on 16/12/2016.
 */

public interface AIErrorHandlerPresenter {

    void onError(@Nullable String message);

    void onError(@StringRes int resId);

}
