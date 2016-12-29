package com.andiag.libraryutils.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andiag.andiag_mvp.presenters.AIPresenter;
import com.andiag.andiag_mvp.views.AIFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by Canalejas on 24/12/2016.
 */
public abstract class AIButterFragment<P extends AIPresenter> extends AIFragment<P> {
    private static final String EXTRA_LAYOUT = "extra_layout";

    Unbinder unbinder;
    protected int mFragmentLayout;

    public AIButterFragment() {
        /**
         * Avoid the use of this constructor. Use {@link AIButterFragment.getInstance} instead
         */
    }

    /**
     * Implement this to set layout res value in fragment
     */
    protected abstract void onInitLayout();

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(EXTRA_LAYOUT, mFragmentLayout);
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
        if (savedInstanceState != null && savedInstanceState.containsKey(EXTRA_LAYOUT)) {
            mFragmentLayout = savedInstanceState.getInt(EXTRA_LAYOUT);
        }
        // TODO check mFragmentLayout != null
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
