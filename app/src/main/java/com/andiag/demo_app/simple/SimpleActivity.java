package com.andiag.demo_app.simple;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.andiag.core.compat.views.AIActivity;
import com.andiag.demo_app.R;
import com.andiag.demo_app.commons.CustomInterface;
import com.andiag.demo_app.commons.CustomPresenter;

/**
 * Created by Canalejas on 29/12/2016.
 */

public class SimpleActivity extends AIActivity<CustomPresenter> implements CustomInterface {

    @Override
    public void onInitPresenter() {
        /**
         * It's recommended to use a different presenter for each view
         */
        mPresenter = CustomPresenter.getInstance();
        mPresenter.enableLogging();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        findViewById(R.id.button_launch_fragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, new SimpleFragment())
                        .commit();
            }
        });

    }

    /**
     * Example of callback from the presenter.
     *
     * @param text showed in toast
     */
    @Override
    public void presenterCallback(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void viewAttached() {
        Toast.makeText(this, "Activity Attached to Presenter", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void viewCreated() {
        Toast.makeText(this, "Activity View Created", Toast.LENGTH_SHORT).show();
    }
}
