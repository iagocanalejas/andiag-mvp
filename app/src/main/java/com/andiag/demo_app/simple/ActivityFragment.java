package com.andiag.demo_app.simple;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.andiag.core.compat.views.AIActivity;
import com.andiag.demo_app.R;

/**
 * Created by Canalejas on 29/12/2016.
 */

public class ActivityFragment extends AIActivity<CustomPresenter> {

    @Override
    public void onInitPresenter() {
        mPresenter = CustomPresenter.getInstance();
        mPresenter.enableLogging();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        findViewById(R.id.button_launch_fragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, new FragmentMain())
                        .commit();
            }
        });

    }

    /**
     * Example of callback from the presenter.
     *
     * @param text showed in toast
     */
    public void presenterCallback(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    public void viewAttached() {
        Toast.makeText(this, "Activity Attached to Presenter", Toast.LENGTH_SHORT).show();
    }

    public void viewCreated() {
        Toast.makeText(this, "Activity View Created", Toast.LENGTH_SHORT).show();
    }
}
