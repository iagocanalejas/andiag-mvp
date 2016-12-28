package es.coru.andiag.andiag_mvp.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import es.coru.andiag.andiag_mvp.presenters.AIPresenter;


/**
 * Created by Canalejas on 11/12/2016.
 */
public abstract class AIActivity<P extends AIPresenter> extends AppCompatActivity implements AIDelegatedView {
    private final static String TAG = AIActivity.class.getSimpleName();

    protected P mPresenter;

    @Override
    public void detachView() {
        mPresenter.detach();
        mPresenter = null;
    }

    @Override
    public void attachView() {
        mPresenter.attach(getApplication(), this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onInitPresenter();
        attachView();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        onInitPresenter();
        attachView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onViewCreated();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.onViewDestroyed();
    }

    @Override
    protected void onStop() {
        super.onStop();
        detachView();
    }
}
