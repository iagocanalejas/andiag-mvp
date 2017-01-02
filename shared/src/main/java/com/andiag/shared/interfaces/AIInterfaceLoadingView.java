package com.andiag.shared.interfaces;

import android.support.annotation.StringRes;

/**
 * Created by Canalejas on 11/12/2016.
 */
@Deprecated
public interface AIInterfaceLoadingView {

    boolean isLoading();

    void showLoading();

    void hideLoading();

    void errorLoading(String message);

    void errorLoading(@StringRes int resId);
}
