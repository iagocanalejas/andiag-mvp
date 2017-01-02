package com.andiag.commons.compat.authentication;

import android.Manifest;
import android.accounts.Account;
import android.os.Build;

import com.andiag.core.presenters.AIPresenter;
import com.andiag.core.views.AIDelegatedView;

import java.util.ArrayList;

/**
 * Created by Canalejas on 02/01/2017.
 */

public interface AIDelegatedAuthenticationVIew extends AIDelegatedView {
    void startAccountSelectorActivity(ArrayList<Account> appAccounts);

    void startAuthenticationActivity();

    /**
     * Ask user for {@link Manifest.permission#GET_ACCOUNTS} permission
     * This permission is only required for API < {@link Build.VERSION_CODES#M}
     * {@link AIPresenter#getView()} returns an Activity in this situation
     * <p>
     * <p>
     * if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.GET_ACCOUNTS)) {
     * // Ask for permission with rationale @see{https://developer.android.com/reference/android/accounts/AccountManager.html}
     * } else {
     * ActivityCompat.requestPermissions(getView(), new String[]{Manifest.permission.GET_ACCOUNTS}, PERMISSION_GET_ACCOUNTS);
     * }
     */
    void onAccountPermissionRequested();
}
