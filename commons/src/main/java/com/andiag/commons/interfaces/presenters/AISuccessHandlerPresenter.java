package com.andiag.commons.interfaces.presenters;

import android.support.annotation.NonNull;

/**
 * Created by Canalejas on 31/12/2016.
 */

public interface AISuccessHandlerPresenter<T> {

    void onSuccess(@NonNull T data);

}
