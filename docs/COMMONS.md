[![](https://jitpack.io/v/iagocanalejas/andiag-mvp.svg)](https://jitpack.io/#iagocanalejas/andiag-mvp)

AndIag MVP Commons Library
=========
Group of common things we use to implement in all our apps using MVP.

# Configuration    
  Add this lines your root-folder gradle **You don't need to include ```com.github.iagocanalejas:andiag-mvp:core``` if using this**
  ```ruby
  allprojects {
    repositories {
      ...
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
  
  If you already have a compatible version of [Butterknife](https://github.com/JakeWharton/butterknife) in your gradle file you can add this library like:
  ```ruby
  dependencies {
    compile ('com.github.iagocanalejas:andiag-mvp:commons:<VERSION>'){
        exclude group: 'com.jakewharton'
    }
  }
  ```
  **Current Butterknife Version: 8.4.0**
  
# Included Fragment Utils
  - [AIButterFragment](commons/src/main/java/com/andiag/commons/fragments/AIButterFragment.java)
  
    Frees you from the load of handle **Butterknife** binders on fragments.
    
    ```java
    @Override
    protected void initLayout(){
      mFragmentLayout = R.layout.<YOUR_FRAGMENT_LAYOUT>
    }
    ```
    
# Included interfaces
  - [AIInterfaceErrorHandlerPresenter](commons/src/main/java/com/andiag/commons/interfaces/AIInterfaceErrorHandlerPresenter.java) When data load error-handlers are needed
  
  - [AIInterfaceLoaderHandlerPresenter](commons/src/main/java/com/andiag/commons/interfaces/AIInterfaceLoaderHandlerPresenter.java) When you want also to handle data load success
  
  - [AIInterfaceLoadingView](commons/src/main/java/com/andiag/commons/interfaces/AIInterfaceLoadingView.java) Basic loading view
  
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

    
