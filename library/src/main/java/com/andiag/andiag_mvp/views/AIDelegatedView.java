package com.andiag.andiag_mvp.views;

/**
 * Created by Canalejas on 28/12/2016.
 */

public interface AIDelegatedView {

    /**
     * Save a presenter instance
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
