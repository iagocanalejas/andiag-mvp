package com.andiag.demo_app;

import android.widget.Toast;

import com.andiag.andiag_mvp.presenters.AIPresenter;


/**
 * Created by Iago on 24/12/2016.
 */
public class CustomFragmentPresenter extends AIPresenter<ActivityMain, FragmentMain> {

    /**
     * Recommended singleton implementation for presenters
     */
    //region Singleton
    private static CustomFragmentPresenter instance = null;

    private CustomFragmentPresenter() {
    }

    public static CustomFragmentPresenter getInstance() {
        if (instance == null) {
            instance = new CustomFragmentPresenter();
        }
        return instance;
    }
    //endregion

    /**
     * Automatically called on presenter attach. VIEW MIGHT NOT BE CREATED JET
     */
    @Override
    public void onViewAttached() {
        Toast.makeText(getContext(), "Presenter On Fragment View Attached", Toast.LENGTH_SHORT).show();
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
        getView().presenterCallback("Fragment callback");
    }

}
