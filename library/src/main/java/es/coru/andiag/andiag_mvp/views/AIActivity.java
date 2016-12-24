package es.coru.andiag.andiag_mvp.views;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import es.coru.andiag.andiag_mvp.presenters.AIPresenter;


/**
 * Created by Canalejas on 11/12/2016.
 */

public abstract class AIActivity<P extends AIPresenter> extends AppCompatActivity {
    private final static String TAG = AIActivity.class.getSimpleName();

    private P mPresenter;

    protected void setPresenter(@NonNull P presenter) {
        mPresenter = presenter;
    }

    protected P getPresenter() {
        return mPresenter;
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (mPresenter == null) {
            Log.e(TAG, "Null Presenter: Initialize it on setPresenter method");
        }
        mPresenter.attach(getApplication(), this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onViewCreated();
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.mPresenter.detach();
        this.mPresenter = null;
    }

}
