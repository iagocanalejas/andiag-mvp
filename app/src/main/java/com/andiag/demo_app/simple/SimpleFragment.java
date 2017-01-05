package com.andiag.demo_app.simple;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.andiag.core.presenters.Presenter;
import com.andiag.core.views.AIFragment;
import com.andiag.demo_app.R;
import com.andiag.demo_app.commons.CustomInterface;
import com.andiag.demo_app.commons.CustomPresenter;


/**
 * Created by Canalejas on 29/12/2016.
 */
@Presenter(presenter = CustomPresenter.class)
public class SimpleFragment extends AIFragment<CustomPresenter> implements CustomInterface {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_simple, container, false);
    }

    /**
     * Example of callback from the presenter.
     *
     * @param text showed in toast
     */
    @Override
    public void presenterCallback(String text) {
        Toast.makeText(mParentContext, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void viewAttached() {
        Toast.makeText(mParentContext, "Fragment Attached to Presenter", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void viewCreated() {
        Toast.makeText(mParentContext, "Fragment View Created", Toast.LENGTH_SHORT).show();
    }
}
