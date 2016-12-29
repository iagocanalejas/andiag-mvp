package com.andiag.demo_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.andiag.andiag_mvp.views.AIActivity;


public class ActivityMain extends AIActivity<CustomPresenter> {

    @Override
    public void onInitPresenter() {
        mPresenter = CustomPresenter.getInstance();
        mPresenter.enableLogging();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.fragment_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivityMain.this, ActivityFragment.class));
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

}
