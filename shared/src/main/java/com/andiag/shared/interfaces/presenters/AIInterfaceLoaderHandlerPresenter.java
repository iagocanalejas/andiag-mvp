package com.andiag.shared.interfaces.presenters;

import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

/**
 * Created by Canalejas on 14/12/2016.
 */

public interface AIInterfaceLoaderHandlerPresenter<T>
        extends AIInterfaceErrorHandlerPresenter,
        AIInterfaceSuccessHandlerPresenter<T> {

    void onLoadProgressChange(@Nullable String message);

    void onLoadProgressChange(@StringRes int resId);

}
