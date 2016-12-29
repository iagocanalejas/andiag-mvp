# Example for Activity
  - Create your presenter
  ```java
  public class CustomPresenter extends AIPresenter<MyApplication, MyInterface> {

    /**
     * Recommended singleton implementation for presenters
     */
    //region Singleton
    private static CustomPresenter instance = null;

    private CustomPresenter() {
    }

    public static CustomPresenter getInstance() {
        if (instance == null) {
            instance = new CustomPresenter();
        }
        return instance;
    }
    //endregion

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
         * You can now safetly run your callbacks
         */
    }

    /*RUN VIEW CALLBACKS*/

  }
  ```
  - Use it in your view (Activity)
  ```java
  public class MainActivity extends AIActivity<CustomPresenter> implements MyInterface {

    @Override
    protected void initPresenter() {
        mPresenter = CustomPresenter.getInstance();
        mPresenter.enableLogging(); // You can add this to see presenter logs
    }

    /*CALLBACKS FOR THE PRESENTER*/

  }
  ```
  
  **You can see a working example in the [demo-app](demo-app/src/main/java/com/andiag/demo_app/)**
