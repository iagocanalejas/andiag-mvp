package es.coru.andiag.andiag_mvp.views;

import android.support.v7.app.AppCompatActivity;

import es.coru.andiag.andiag_mvp.presenters.AIPresenter;


/**
 * Created by Canalejas on 11/12/2016.
 */

public abstract class AIActivity<P extends AIPresenter> extends AppCompatActivity {
    private final static String TAG = AIActivity.class.getSimpleName();

    protected P mPresenter;

    protected abstract void initPresenter();

    @Override
    protected void onResume() {
        super.onResume();
        initPresenter();
        mPresenter.attach(getApplication(), this);
        mPresenter.onViewCreated();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.detach();
        mPresenter = null;
    }

}
