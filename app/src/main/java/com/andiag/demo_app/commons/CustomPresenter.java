package com.andiag.demo_app.commons;

import android.app.Application;
import android.os.Handler;

import com.andiag.core.presenters.AIPresenter;


/**
 * Created by Iago on 24/12/2016.
 */
public class CustomPresenter extends AIPresenter<Application, CustomInterface> {


    public CustomPresenter() {
        /**
         * Required default constructor
         */
    }

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
