package com.andiag.demo_app.butterknife;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.andiag.demo_app.R;

/**
 * Created by Canalejas on 04/01/2017.
 */

public class BActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, new ButterFragment())
                .commit();

        findViewById(R.id.button_launch_fragment).setVisibility(View.GONE);

    }

}
