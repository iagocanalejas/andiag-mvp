package com.andiag.commons.interfaces.presenters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

/**
 * Created by Canalejas on 16/12/2016.
 */

public interface AIInterfaceErrorHandlerPresenter {

    Context getContext();

    void onLoadError(@Nullable String message);

    void onLoadError(@StringRes int resId);

}
