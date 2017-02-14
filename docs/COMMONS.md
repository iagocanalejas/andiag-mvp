[![API](https://img.shields.io/badge/API-9%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=9)
[![](https://jitpack.io/v/iagocanalejas/andiag-mvp.svg)](https://jitpack.io/#iagocanalejas/andiag-mvp)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-andiag--mvp-brightgreen.svg?style=flat)]()

AndIag MVP Commons Library
=========
Group of common things we use to implement in all our apps using MVP.

# Configuration    
  Add this lines your root-folder gradle **You don't need to include ```com.github.iagocanalejas:andiag-mvp:core``` if using this**
  ```ruby
  allprojects {
    repositories {
      maven { url 'https://jitpack.io' }
    }
  }
  ```
  And this to your module-folder gradle
  ```ruby
  dependencies {
    compile 'com.github.iagocanalejas:andiag-mvp:commons:<VERSION>'
  }
  ```

# Butterknife Fragment
  - [AIButterFragment](commons/src/main/java/com/andiag/commons/fragments/AIButterFragment.java)

    Frees you from the load of handle **Butterknife** binders on fragments.

    ```java
    @FragmentLayout(res = R.layout.my_fragment_layout)
    public class MyFragment extends AIButterFragment<MyPresenter> implements MyInterface {
        //Your Fragment methods
    }
    ```

    **You can see a working example in the [demo-app](app/src/main/java/com/andiag/demo_app/butterknife/ButterFragment.java)**

# Authentication
  Recommend to use this helpers with [RetroAuth](https://github.com/andretietz/retroauth/tree/master/retroauth-android) library.

  - Add the **GET_ACCOUNTS** permission to your manifest:
  ```xml
  <uses-permission android:name="android.permission.GET_ACCOUNTS"/>
  ```

  - Implement an Activity that extends [AIAuthenticationActivity](commons/src/main/java/com/andiag/commons/authentication/AIActivityAuthentication.java)
  ```java
    @Presenter(presenter = PresenterAuthentication.class)
    public class ActivityAuthentication extends AIActivityAuthentication<PresenterAuthentication> {

        private final static String ACCOUNT_TYPE = "AndIag"; //Your account type (normally your app name)
        private SharedPreferences preferencesFile;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            mPresenter.setAccountType(ACCOUNT_TYPE);
            mPresenter.setPreferences(preferencesFile);
        }

        @Override
        public void startAuthenticationIntent() {
            /**
             * Call your authentication method and save the account in the {@link android.accounts.AccountManager}
             * If using retroauth just call the login intent provided and use mPresenter.onAccountSelected(account) in onActivityResult
             * then set the account as default as follow. For mock i will just create an account here.
             */
            Account account = new Account("accountName", ACCOUNT_TYPE);
            mPresenter.onAccountSelected(account);
        }

        @Override
        public void onAccountPermissionRequested() {
            /**
             * Use {@link AIActivityAuthentication#PERMISSION_GET_ACCOUNTS} as int callback for your permission request
             * @see {https://developer.android.com/training/permissions/requesting.html}
             */
        }

    }
  ```

  - Implement a Presenter that extends [AIAuthenticationPresenter](commons/src/main/java/com/andiag/commons/authentication/AIPresenterAuthentication.java)
  ```java
    public class PresenterAuthentication extends AIPresenterAuthentication<Application, ActivityAuthentication>{

      /**
      * This presenter can handle a single-account or multi-account app use getAccount to retrieve the actual
      * selected Account.
      */

      @Override
      public void onGetAccountsPermissionRefused() {
        /**
        * Handle your permission refused event
        */
      }

    }
  ```
    
# Included interfaces
  - [AIErrorHandlerPresenter](commons/src/main/java/com/andiag/commons/interfaces/AIInterfaceErrorHandlerPresenter.java) When error-handlers are needed for data load
  ```java
      public interface AIInterfaceErrorHandlerPresenter {

          void onError(@Nullable String message);

          void onError(@StringRes int resId);

      }
  ```

  - [AISuccessHandlerPresenter](commons/src/main/java/com/andiag/commons/interfaces/AIInterfaceSuccessHandlerPresenter.java) Basic success view
    ```java
          public interface AIInterfaceSuccessHandlerPresenter<T> {

              void onSuccess(@Nullable T data);

          }
    ```

  - [AIProgressHandlerPresenter](commons/src/main/java/com/andiag/commons/interfaces/AIInterfaceLoaderHandlerPresenter.java) When you want also to handle data load success
  ```java
        public interface AIInterfaceLoaderHandlerPresenter<T> extends AIInterfaceErrorHandlerPresenter, AIInterfaceSuccessHandlerPresenter<T> {

            void onProgressChange(@Nullable String message);

            void onProgressChange(@StringRes int resId);

        }
  ```
  
# Libraries included
  - [AndIag-MVP](https://github.com/iagocanalejas/andiag-mvp)
  - [Butterknife](https://github.com/JakeWharton/butterknife)

# Pull Requests
I welcome and encourage all pull requests. Here are some basic rules to follow to ensure timely addition of your request:
  1. Match coding style (braces, spacing, etc.) This is best achieved using CMD+Option+L (on Mac) or Ctrl+Alt+L on Windows to reformat code with Android Studio defaults.
  2. If its a feature, bugfix, or anything please only change code to what you specify.
  3. Please keep PR titles easy to read and descriptive of changes, this will make them easier to merge.
  4. Pull requests _must_ be made against `develop` branch. Any other branch (unless specified by the maintainers) will get rejected.
  5. Have fun!

# Applications
  - [WeLegends](https://github.com/AndIag/WeLegends)
  
# Maintained By
[IagoCanalejas](https://github.com/iagocanalejas) ([@iagocanalejas](https://twitter.com/Iagocanalejas))

[Andy](https://github.com/andy135) ([@ANDYear21](https://twitter.com/ANDYear21))
    
LICENSE
============
  Copyright 2016 AndIag

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.

    
