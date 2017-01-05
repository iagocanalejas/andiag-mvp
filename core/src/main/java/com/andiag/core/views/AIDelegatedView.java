package com.andiag.core.views;

/**
 * Created by Canalejas on 28/12/2016.
 */

public interface AIDelegatedView {

    /**
     * Initialize a presenter instance
     */
    void onInitPresenter();

    /**
     * Call this method when your view is created
     */
    void attachView();

    /**
     * Call this method when your view is destroyed
     */
    void detachView();

}
