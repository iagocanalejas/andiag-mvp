package com.andiag.demo_app.commons;

import android.app.Application;
import android.os.Handler;

import com.andiag.shared.core.presenters.AIPresenter;


/**
 * Created by Iago on 24/12/2016.
 */
public class CustomPresenter extends AIPresenter<Application, CustomInterface> {

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
        getView().viewAttached();
    }

    /**
     * Once this method occurs {@link AIPresenter#isViewAttached} will return True.
     * Use it from your callbacks
     */
    @Override
    public void onViewCreated() {
        super.onViewCreated();
        getView().viewCreated();
        delayedCallback();
    }


    private void delayedCallback() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                getView().presenterCallback("Delayed Callback");
            }

        }, 2000);
    }

}
