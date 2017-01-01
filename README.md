[![API](https://img.shields.io/badge/API-9%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=9)
[![](https://jitpack.io/v/iagocanalejas/andiag-mvp.svg)](https://jitpack.io/#iagocanalejas/andiag-mvp)

AndIag MVP Library
=========
Library to help developers build full MVP apps.

# Usage
  - Create your presenters extending [AIPresenter](core/src/main/java/com/andiag/core/presenters/AIPresenter.java) or implementing [AIInterfacePresenter](core/src/main/java/com/andiag/core/presenters/AIInterfacePresenter.java)
      - C -> Your view context (Application or Context for Activities, Activities or Context for Fragmentes)
      - V -> Your view interface should implement [AIDelegatedView](core/src/main/java/com/andiag/core/views/AIDelegatedView.java)
  - For Activities
      - Extend [AIActivity](core/src/main/java/com/andiag/core/views/AIActivity.java) or [AICompatActivity](core/src/main/java/com/andiag/core/views/AICompatActivity.java)
      - Override method ``` onInitPresenter() ```
      - ``` AIPresenter.onViewCreated(); ``` is automatically called in your onResume method
      - Presenters will be attached between ```onResume()``` and ```onPause()``` but you can instantiate it before if presenter is implemented as singleton.
  - For Fragments
      - Extend [AIFragment](core/src/main/java/com/andiag/core/views/AIFragment.java) or [AICompatFragment](core/src/main/java/com/andiag/core/views/AICompatFragment.java)
      - Override method ``` onInitPresenter() ```
      - ``` AIPresenter.onViewCreated(); ``` is automatically called in your onViewCreated method
      - Presenters will be attached between ```onViewCreated(...)``` and ```onDestroyView(...)``` but you can instantiate it before if presenter is implemented as singleton.

# Configuration
  - Add this lines your root-folder gradle:
    ```ruby
    allprojects {
      repositories {
        ...
        maven { url 'https://jitpack.io' }
      }
    }
    ```
    And this to your module-folder gradle:
    ```ruby
    dependencies {
      compile 'com.github.iagocanalejas:andiag-mvp:core:<VERSION>'
    }
    ```

  - We have also implemented a common library that contains [extensions](docs/COMMONS.md), if you want to use it just replace your andiag-mvp dependency with:
    ```ruby
    dependencies {
      compile 'com.github.iagocanalejas:andiag-mvp:commons:<VERSION>'
    }
    ```

    If you already have a compatible version of [Butterknife](https://github.com/JakeWharton/butterknife) in your gradle file you can add an exclude configuration like:
    ```ruby
    dependencies {
      compile (compile 'com.github.iagocanalejas:andiag-mvp:commons:<VERSION>'){
          exclude group: 'com.jakewharton'
      }
    }
    ```
    **Current Butterknife Version in Library: 8.4.0**
    
    Documentation for [commons](docs/COMMONS.md) is available [here](docs/COMMONS.md)

# Code Examples
  - [Example for Activities](docs/example_activities.md)
  - [Example for Fragments](docs/example_fragments.md)
  
# Recomendations
  - Use Presenters as Singletons

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
