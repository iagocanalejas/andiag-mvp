package com.andiag.commons.compat.authentication;

import android.Manifest;
import android.accounts.Account;
import android.os.Build;

import com.andiag.shared.core.views.AIDelegatedView;

import java.util.ArrayList;

/**
 * Created by Canalejas on 02/01/2017.
 */

public interface AIDelegatedAuthenticationView extends AIDelegatedView {

    /**
     * Launch a default account chooser
     *
     * @param appAccounts list of account matching {@link AIPresenterAuthentication#mAccountType}
     */
    void startAccountSelectorActivity(ArrayList<Account> appAccounts);

    /**
     * Launch an Authentication intent
     * Example: @see <a href="https://github.com/andretietz/retroauth/tree/master/retroauth-android"></a>
     */
    void startAuthenticationIntent();

    /**
     * Ask user for {@link Manifest.permission#GET_ACCOUNTS} permission
     * This permission is only required for API < {@link Build.VERSION_CODES#M}
     *
     * @see <a href="https://developer.android.com/training/permissions/requesting.html"></a>
     */
    void onAccountPermissionRequested();
}
