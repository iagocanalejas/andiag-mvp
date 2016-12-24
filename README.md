AndIag MVP Library
=========
EARLY VERSION. ALL HELP ARE GREATEFULL. 

Library to help developers build full MVP apps.

# Usage
  - Create your presenters as ``` AIPresenter<C, V> ```:
      - C -> Your view context (Application or Context for Activities, Activities or Context for Fragmentes)
      - V -> Your view interface
  - For Activities
      - Extend ``` AIActivity<YOUR_PRESENTER> ```
      - Call ``` setPresenter(YOUR_PRESENTER_INSTANCE); ``` in your onCreate method
      - ``` getPresenter().onViewCreated(); ``` is called in your onResume method
  - For Fragments
      - Extend ``` AIFragment<YOUR_PRESENTER> ```
      - Call ``` setPresenter(YOUR_PRESENTER_INSTANCE); ``` in your onAttach method
      - ``` getPresenter().onViewCreated(); ``` is called in your onViewCreated method

# Usage Example for Activities
  1. Configure your gradle:
    
    Add this lines your root-folder gradle
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
      compile 'com.github.iagocanalejas:andiag-mvp:<VERSION>'
    }
    ```
  2. Create your first presenter
  ```java
  public class CustomPresenter extends AIPresenter<Application, MainActivity> {

    private static CustomPresenter instance = null;

    private CustomPresenter() {
    }

    public static CustomPresenter getInstance() {
        if (instance == null) {
            instance = new CustomPresenter();
        }
        return instance;
    }

    /**
     * Automatically called on presenter attach. VIEW MIGHT NOT BE CREATED JET
     */
    @Override
    public void onViewAttached() {
        Toast.makeText(getContext(), "Presenter On View Attached", Toast.LENGTH_SHORT).show();
    }

    /**
     * Call from activity when view loading ends
     */
    @Override
    public void onViewCreated() {
        super.onViewCreated();
        /**
         * Once this method occurs {@link AIPresenter.isViewAttached} will return True.
         * Use it from your callbacks
         */
    }

    /*VIEW CALLBACKS*/

  }
  ```
  3. Use it in your view (Activity)
  ```java
  public class MainActivity extends AIActivity<CustomPresenter> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        /*INITIALICE PRESENTER*/
        setPresenter(CustomPresenter.getInstance());
 
    }

    /*CALLBACKS FOR THE PRESENTER*/

  }
  ```
  
# Recomendations
  - Use Presenters as Singletones
  - Use AIPresenter< _ , CustomInterface> if you whant a more generic presenter

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
