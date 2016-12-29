package com.andiag.libraryutils.interfaces;

import android.support.annotation.StringRes;

/**
 * Created by Canalejas on 14/12/2016.
 */

public interface AIInterfaceLoaderHandlerPresenter<T> extends AIInterfaceErrorHandlerPresenter {

    void onLoadSuccess(T data);

    void onLoadProgressChange(String message);

    void onLoadProgressChange(@StringRes int resId);

}
