package com.andiag.demo_app;

import android.app.Application;
import android.widget.Toast;

import com.andiag.shared.core.presenters.AIPresenter;


/**
 * Created by Iago on 24/12/2016.
 */
public class CustomPresenter extends AIPresenter<Application, ActivityMain> {

    /**
     * Recommended singleton implementation for presenters
     */
    //region Singleton
    private static CustomPresenter instance = null;

    private CustomPresenter() {
    }

    public static CustomPresenter getInstance() {
        if (instance == null) {
            instance = new CustomPresenter();
        }
        return instance;
    }
    //endregion

    /**
     * Automatically called on presenter attach. VIEW MIGHT NOT BE CREATED JET
     */
    @Override
    public void onViewAttached() {
        Toast.makeText(getContext(), "Presenter On View Attached", Toast.LENGTH_SHORT).show();
    }

    /**
     * Call from activity when view loading ends
     */
    @Override
    public void onViewCreated() {
        super.onViewCreated();
        callback();
        /**
         * Once this method occurs {@link AIPresenter.isViewAttached} will return True.
         * Use it from your callbacks
         */
    }

    private void callback() {
        getView().presenterCallback("Activity callback");
    }

}
