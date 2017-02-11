[![API](https://img.shields.io/badge/API-9%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=9)
[![](https://jitpack.io/v/iagocanalejas/andiag-mvp.svg)](https://jitpack.io/#iagocanalejas/andiag-mvp)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-andiag--mvp-brightgreen.svg?style=flat)]()

AndIag MVP Library
=========
Library to help developers build full MVP apps.

# **[CHANGELOG](CHANGELOG.MD)**

# Usage
  - Create your presenters extending [AIPresenter](core/src/main/java/com/andiag/core/presenters/AIPresenter.java) or implementing [AIInterfacePresenter](core/src/main/java/com/andiag/core/presenters/AIInterfacePresenter.java)
      - C -> Your view context (Application or Context for Activities, Activities or Context for Fragmentes)
      - V -> Your view interface should implement [AIDelegatedView](shared-core/src/main/java/com/andiag/shared/core/views/AIDelegatedView.java)
  - For Activities
      - Extend [AIActivity](core/src/main/java/com/andiag/core/views/AIActivity.java)
      - Use annotation ``` @Presenter(presenter = MyPresenter.class) ```
      - Presenters can comunicate with view between ```onResume()``` and ```onPause()```.
  - For Fragments
      - Extend [AIFragment](core/src/main/java/com/andiag/core/views/AIFragment.java)
      - Use annotation ``` @Presenter(presenter = MyPresenter.class) ```
      - Presenters can comunicate with view between ```onViewCreated(...)``` and ```onDestroyView(...)```.

# Configuration
  - Add this lines your root-folder gradle:
    ```ruby
    allprojects {
      repositories {
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

  - We have also implemented a common library that contains [extensions](docs/COMMONS.md):
    ```ruby
    dependencies {
      compile 'com.github.iagocanalejas:andiag-mvp:commons:<VERSION>'
    }
    ```
    
    Documentation for [commons](docs/COMMONS.md) is available [here](docs/COMMONS.md)

# Basic example
   - Create your repository
      ```java
      public class MyRepository extends AIRepository {

      }
      ```
   - Create your presenter
      ```java
      @Repository(repository = MyRepository.class) // Not required annotation
      @Repository(repository = MySingletonRepository.class, initiator = "getInstance") // Use this for singletons
      public class MyPresenter extends AIPresenter<MyActivity, MyInterface> {

        public MyPresenter(){
            //Required default constructor
        }

        /*CALLS TO VIEW*/

        /*CALLS FROM VIEW*/

      }
      ```
  - Use it in your Fragment
      ```java
      @Presenter(presenter = MyPresenter.class)
      public class FragmentMain extends AIFragment<MyPresenter> implements MyInterface {

          /*Fragment methods*/

          /*CALLBACKS FOR THE PRESENTER*/

      }
      ```

  **You can see a working example in the [demo-app](app/src/main/java/com/andiag/demo_app/simple/SimpleFragment.java)**


# Code Examples
  - [Example for Activities](docs/example_activities.md)
  - [Example for Fragments](docs/example_fragments.md)
  
# Recomendations
  - Use a different Presenter for each purpose
  - Move all your Activity/Fragment logic to the presenter

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
