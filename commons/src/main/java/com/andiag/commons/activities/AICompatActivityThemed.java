package com.andiag.commons.activities;

import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Canalejas on 01/01/2017.
 */

public abstract class AICompatActivityThemed extends AppCompatActivity {
    private static final String TAG = AICompatActivityThemed.class.getSimpleName();

    private static final String PREF_THEME_KEY = "theme_list";

    public static int getTheme(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(PREF_THEME_KEY, -1);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
