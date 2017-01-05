package com.andiag.core.views;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.andiag.core.presenters.AIPresenter;
import com.andiag.core.presenters.Presenter;

import java.lang.reflect.InvocationTargetException;


/**
 * Created by Canalejas on 11/12/2016.
 */

public abstract class AIFragment<P extends AIPresenter> extends Fragment implements AIDelegatedView {
    private final static String TAG = AIFragment.class.getSimpleName();

    protected Context mParentContext;
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
            } catch (java.lang.InstantiationException e) {
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

    @SuppressWarnings("unchecked")
    @Override
    public void attachView() {
        mPresenter.attach(mParentContext, this);
    }

    @Override
    public void detachView() {
        mPresenter.detach();
        mPresenter = null;
        mParentContext = null;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mParentContext = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onInitPresenter();
        createFromAnnotation();
        attachView();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.onViewCreated();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.onViewDestroyed();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        detachView();
    }

}
