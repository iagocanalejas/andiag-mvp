package com.andiag.demo_app.simple;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.andiag.core.compat.views.AIFragment;
import com.andiag.demo_app.R;


/**
 * Created by Canalejas on 29/12/2016.
 */

public class FragmentMain extends AIFragment<CustomFragmentPresenter> {

    @Override
    public void onInitPresenter() {
        mPresenter = CustomFragmentPresenter.getInstance();
        mPresenter.enableLogging();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    /**
     * Example of callback from the presenter.
     *
     * @param text showed in toast
     */
    public void presenterCallback(String text) {
        Toast.makeText(mParentContext, text, Toast.LENGTH_SHORT).show();
    }

    public void viewAttached() {
        Toast.makeText(mParentContext, "Fragment Attached to Presenter", Toast.LENGTH_SHORT).show();
    }

    public void viewCreated() {
        Toast.makeText(mParentContext, "Fragment View Created", Toast.LENGTH_SHORT).show();
    }
}
