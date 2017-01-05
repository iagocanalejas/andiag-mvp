package com.andiag.core.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.andiag.core.presenters.AIPresenter;
import com.andiag.core.presenters.Presenter;

import java.lang.reflect.InvocationTargetException;


/**
 * Created by Canalejas on 11/12/2016.
 */
public abstract class AIActivity<P extends AIPresenter> extends AppCompatActivity implements AIDelegatedView {
    private final static String TAG = AIActivity.class.getSimpleName();

    protected P mPresenter;

    @Deprecated
    @Override
    public void onInitPresenter() {

    }

    private void createFromAnnotation() {
        if (mPresenter == null && getClass().getAnnotation(Presenter.class) != null) {
            Class<P> clazz = getClass().getAnnotation(Presenter.class).presenter();
            try {
                mPresenter = clazz.getConstructor(clazz).newInstance();
            } catch (InstantiationException e) {
                throw new IllegalStateException("No default constructor found");
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("No default constructor found");
            } catch (InvocationTargetException e) {
                throw new IllegalStateException("No default constructor found");
            } catch (NoSuchMethodException e) {
                throw new IllegalStateException("No default constructor found");
            }
        }
    }

    @Override
    public void detachView() {
        mPresenter.detach();
        mPresenter = null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void attachView() {
        mPresenter.attach(getApplication(), this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onInitPresenter();
        createFromAnnotation();
        attachView();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        onInitPresenter();
        createFromAnnotation();
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
