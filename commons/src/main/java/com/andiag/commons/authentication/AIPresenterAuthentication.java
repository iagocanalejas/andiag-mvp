package com.andiag.commons.authentication;

import android.Manifest;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresPermission;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import com.andiag.core.presenters.AIPresenter;
import com.andiag.core.presenters.ViewState;
import com.google.android.gms.common.AccountPicker;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Canalejas on 02/01/2017.
 */
public abstract class AIPresenterAuthentication<C extends Context, V extends AppCompatActivity & AIDelegatedAuthenticationView> extends AIPresenter<C, V> {
    private static final String TAG = AIPresenterAuthentication.class.getSimpleName();

    /**
     * Name given to the account in the {@link android.content.SharedPreferences} file
     */
    private static final String SAVED_ACCOUNT = "AndIag:-AppAccount";

    protected Account mAccount;
    protected AccountManager mAccountManager;
    protected String mAccountType;
    protected String mAccountToken;
    protected SharedPreferences mPreferences;

    public final void attach(C context, @NonNull V view, @NonNull AccountManager accountManager) {
        attach(context, view, accountManager, null);
    }

    public final void attach(C context, @NonNull V view, @NonNull AccountManager accountManager, SharedPreferences preferences) {
        attach(context, view, accountManager, preferences, null);
    }

    public final void attach(C context, @NonNull V view, @NonNull AccountManager accountManager, SharedPreferences preferences, String accountType) {
        super.attach(context, view);
        mAccountManager = accountManager;
        mPreferences = preferences;
        mAccountType = accountType;
    }

    @Override
    public void onViewCreated() {
        super.onViewCreated();
        if (mPreferences == null) {
            throw new IllegalStateException("Preferences must be configured");
        }
        if (mAccountType == null) {
            throw new IllegalStateException("Account Type must be configured");
        }
    }

    //region Presenter Configuration

    /**
     * Set the type of account this presenter will take care off
     *
     * @param accountType given type
     */
    public final void setAccountType(String accountType) {
        if (mViewState.equals(ViewState.CREATED)) {
            throw new IllegalStateException("Can't perform this action while view is showing");
        }
        mAccountType = accountType;
    }

    /**
     * Set the type of token this presenter will take care off
     *
     * @param accountToken given token type
     */
    public final void setAccountToken(String accountToken) {
        if (mViewState.equals(ViewState.CREATED)) {
            throw new IllegalStateException("Can't perform this action while view is showing");
        }
        mAccountToken = accountToken;
    }

    /**
     * Preferences where presenter will save the configuration
     *
     * @param preferences given {@link SharedPreferences}
     */
    public final void setPreferences(SharedPreferences preferences) {
        if (mViewState.equals(ViewState.CREATED)) {
            throw new IllegalStateException("Can't perform this action while view is showing");
        }
        mPreferences = preferences;
    }
    //endregion

    /**
     * @return true if we have more than one account logged, false otherwise
     */
    public boolean isMultiAccount() {
        return getAccounts() != null && getAccounts().size() > 1;
    }

    /**
     * @return {@link ArrayList} of {@link Account} or null if permission is not granted
     */
    protected ArrayList<Account> getAccounts() {
        if (mAccountType == null) {
            throw new IllegalStateException("Account Type might not have been initialized");
        }
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.GET_ACCOUNTS) != PackageManager.PERMISSION_GRANTED
                && Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            getView().onAccountPermissionRequested();
            return null;
        }
        return new ArrayList<>(Arrays.asList(mAccountManager.getAccountsByType(mAccountType)));
    }

    /**
     * Find {@link Account} by given name
     *
     * @param accountName what to search
     * @return {@link Account} or null
     */
    private Account getAccountByName(String accountName) {
        for (Account account : getAccounts()) {
            if (account.name.equals(accountName)) {
                return account;
            }
        }
        return null;
    }

    /**
     * Marc account as current active
     *
     * @param accountName current account name
     */
    public void onAccountSelected(String accountName) {
        onAccountSelected(getAccountByName(accountName));
    }

    /**
     * Marc account as current active
     *
     * @param account current
     */
    public void onAccountSelected(Account account) {
        if (account != null) {
            mAccount = account;
            mPreferences.edit().putString(SAVED_ACCOUNT, mAccount.name).apply();
        }
    }

    /**
     * Launch a {@link AccountManager#newChooseAccountIntent}
     *
     * @param accounts where to select an {@link Account}
     * @return {@link Intent} to new activity picker
     */
    @SuppressWarnings("MissingPermission")
    @RequiresPermission(Manifest.permission.GET_ACCOUNTS)
    public Intent newAccountSelectorIntent(@NonNull ArrayList<Account> accounts) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return AccountManager.newChooseAccountIntent(mAccount, accounts,
                    new String[]{mAccountType}, null, null,
                    null, null);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            return AccountManager.newChooseAccountIntent(mAccount, accounts,
                    new String[]{mAccountType}, false, null, null,
                    null, null);
        } else {
            return AccountPicker.newChooseAccountIntent(mAccount, accounts,
                    new String[]{mAccountType}, false, null,
                    mAccountToken, null, null);
        }
    }

    /**
     * Try to load an {@link Account} from {@link AIPresenterAuthentication#mPreferences}
     *
     * @return true if loaded false otherwise
     */
    private boolean loadFromDisk() {
        if (mPreferences.contains(SAVED_ACCOUNT)) {
            String accountName = mPreferences.getString(SAVED_ACCOUNT, null);
            logInfo(TAG, accountName + " found on preferences");
            if (accountName != null) {
                mAccount = getAccountByName(accountName);
                if (mAccount != null) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Try to find account in preferences. If no account found use {@link AccountManager} or
     */
    public void onLoadDefaultAccount() {
        if (!loadFromDisk()) {
            ArrayList<Account> appAccounts = getAccounts();
            if (appAccounts.size() > 1) {
                logInfo(TAG, "Account Selector Intent Launched");
                getView().startAccountSelectorActivity(appAccounts);
            } else if (appAccounts.size() == 1) {
                logInfo(TAG, "Selected Unique Account");
                onAccountSelected(appAccounts.get(0));
            } else {
                logInfo(TAG, "No Account, Login Intent Launched");
                getView().startAuthenticationIntent();
            }
        }
    }

    /**
     * Handles permission request failure
     */
    public abstract void onGetAccountsPermissionRefused();

}
