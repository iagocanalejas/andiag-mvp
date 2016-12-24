package es.coru.andiag.andiag_mvp_demo;

import android.app.Application;
import android.widget.Toast;

import es.coru.andiag.andiag_mvp.presenters.AIPresenter;


/**
 * Created by Iago on 24/12/2016.
 */
public class CustomPresenter extends AIPresenter<Application, MainActivity> {

    private static CustomPresenter instance = null;

    private CustomPresenter() {
    }

    public static CustomPresenter getInstance() {
        if (instance == null) {
            instance = new CustomPresenter();
        }
        return instance;
    }

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
