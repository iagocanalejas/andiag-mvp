package com.andiag.commons.compat.authentication;

import android.Manifest;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;

import com.andiag.core.compat.views.AIActivity;

import java.util.ArrayList;

/**
 * Created by Canalejas on 02/01/2017.
 */
@RequiresApi(api = Build.VERSION_CODES.ICE_CREAM_SANDWICH)
public abstract class AIActivityAuthentication<P extends AIPresenterAuthentication> extends AIActivity<P> implements AIDelegatedAuthenticationView {
    private static final String TAG = AIActivityAuthentication.class.getSimpleName();

    /**
     * Code for the {@link Manifest.permission#GET_ACCOUNTS} permission
     */
    private static final int PERMISSION_GET_ACCOUNTS = 122444;

    /**
     * Code {@link AccountManager#newChooseAccountIntent} will return
     */
    private static final int REQUEST_SELECT_ACCOUNT = 250212;

    @SuppressWarnings("unchecked")
    @Override
    public void attachView() {
        mPresenter.attach(getApplication(), this, AccountManager.get(getBaseContext()));
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.onLoadDefaultAccount();
    }

    /**
     * {@link AIDelegatedAuthenticationView#startAccountSelectorActivity}
     */
    @Override
    public void startAccountSelectorActivity(ArrayList<Account> accounts) {
        startActivityForResult(mPresenter.newAccountSelectorIntent(accounts), REQUEST_SELECT_ACCOUNT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_SELECT_ACCOUNT:
                if (resultCode == AppCompatActivity.RESULT_OK) {
                    mPresenter.onAccountSelected(data.getStringExtra(AccountManager.KEY_ACCOUNT_NAME));
                }
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_GET_ACCOUNTS:
                if (grantResults.length <= 0 || grantResults[0] != PackageManager.PERMISSION_GRANTED
                        && Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                    mPresenter.onGetAccountsPermissionRefused();
                    return;
                }
                mPresenter.onLoadDefaultAccount();
                break;
        }
    }

    /**
     * {@link AIDelegatedAuthenticationView#startAuthenticationIntent}
     */
    @Override
    public abstract void startAuthenticationIntent();

    /**
     * {@link AIDelegatedAuthenticationView#onAccountPermissionRequested}
     */
    @Override
    public abstract void onAccountPermissionRequested();

}
