package com.andiag.core.utils;

import android.app.Application;

import com.andiag.core.presenters.AIPresenter;
import com.andiag.core.repositories.AIRepository;

/**
 * Created by Canalejas on 11/02/2017.
 */
public class BasePresenter extends AIPresenter<Application, PresenterActivity> {

    public AIRepository getRepository() {
        return mRepository;
    }

}
