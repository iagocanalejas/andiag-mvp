package com.andiag.core.views;

import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.View;

import com.andiag.core.presenters.AIPresenter;

/**
 * Created by Canalejas on 01/01/2017.
 */

@RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
public abstract class AIFragment<P extends AIPresenter> extends Fragment implements AIDelegatedView {
    private final static String TAG = AIFragment.class.getSimpleName();

    protected Context mParentContext;
    protected P mPresenter;

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