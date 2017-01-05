# Example for Fragments
  - Create your presenter
  ```java
  public class MyPresenter extends AIPresenter<MyActivity, MyInterface> {

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
  - Use it in your Fragment
  ```java
  @Presenter(presenter = MyPresenter.class)
  public class FragmentMain extends AIFragment<MyPresenter> implements MyInterface {

      /*Fragment methods*/

      /*CALLBACKS FOR THE PRESENTER*/
      
  }
  ```
  
  **You can see a working example in the [demo-app](app/src/main/java/com/andiag/demo_app/simple/SimpleFragment.java)**
