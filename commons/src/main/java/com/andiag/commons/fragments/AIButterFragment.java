package com.andiag.commons.fragments;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andiag.core.presenters.AIPresenter;
import com.andiag.core.views.AIFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by Canalejas on 24/12/2016.
 */
public abstract class AIButterFragment<P extends AIPresenter> extends AIFragment<P> {

    @LayoutRes
    protected Integer mFragmentLayout;

    Unbinder unbinder;

    public AIButterFragment() {
    }

    /**
     * {@link AIButterFragment#mFragmentLayout} should be initialize here
     */
    protected final void onInitLayout() {
        FragmentLayout annotation = getClass().getAnnotation(FragmentLayout.class);
        if (annotation != null && annotation.res() != 0) {
            mFragmentLayout = annotation.res();
        } else {
            throw new IllegalStateException("Not annotated Fragment. Try using @FragmentLayout annotation");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onInitLayout();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        if (mFragmentLayout == null) {
            throw new IllegalStateException("Fragment Layout should have a valid value");
        }

        View fragmentView = inflater.inflate(mFragmentLayout, container, false);
        unbinder = ButterKnife.bind(this, fragmentView);

        return fragmentView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        unbinder = null;
    }
}
