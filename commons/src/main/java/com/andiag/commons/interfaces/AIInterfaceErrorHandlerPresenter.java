package com.andiag.commons.interfaces;

import android.content.Context;
import android.support.annotation.StringRes;

/**
 * Created by Canalejas on 16/12/2016.
 */

public interface AIInterfaceErrorHandlerPresenter {

    Context getContext();

    void onLoadError(String message);

    void onLoadError(@StringRes int resId);

}
