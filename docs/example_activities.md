# Example for Activity
  - Create your presenter
  ```java
  public class MyPresenter extends AIPresenter<MyApplication, MyInterface> {

    public MyPresenter(){
        //Required default constructor
    }

    /**
     * Call from activity when view loading ends
     */
    @Override
    public void onViewCreated() {
        super.onViewCreated();
        /**
         * Once this method occurs {@link AIPresenter.isViewCreated} will return True.
         * You can now safely run your callbacks
         */
    }

    /*RUN VIEW CALLBACKS*/

  }
  ```
  - Use it in your Activity
  ```java
  @Presenter(presenter = MyPresenter.class)
  public class MainActivity extends AIActivity<MyPresenter> implements MyInterface {

    /*Activity Methods*/

    /*CALLBACKS FOR THE PRESENTER*/

  }
  ```
  
  **You can see a working example in the [demo-app](app/src/main/java/com/andiag/demo_app/simple/SimpleActivity.java)**
