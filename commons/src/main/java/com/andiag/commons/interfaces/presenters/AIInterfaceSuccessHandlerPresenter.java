package com.andiag.commons.interfaces.presenters;

import android.content.Context;
import android.support.annotation.Nullable;

/**
 * Created by Canalejas on 31/12/2016.
 */

public interface AIInterfaceSuccessHandlerPresenter<T> {

    Context getContext();

    void onLoadSuccess(@Nullable T data);

}
