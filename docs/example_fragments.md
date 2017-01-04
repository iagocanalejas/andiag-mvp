# Example for Fragments
  - Create your presenter
  ```java
  public class CustomPresenter extends AIPresenter<MyActivity, MyInterface> {

    /**
     * Recommended singleton implementation for presenters
     */
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
         * You can now safetly run your callbacks
         */
    }

    /*RUN VIEW CALLBACKS*/

  }
  ```
  - Use it in your Fragment
  ```java
  public class FragmentMain extends AIFragment<CustomPresenter> {

      @Override
      public void onInitPresenter() {
          mPresenter = CustomFragmentPresenter.getInstance();
          mPresenter.enableLogging(); // You can add this to see presenter logs
      }

      @Nullable
      @Override
      public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
          return inflater.inflate(R.layout.fragment_main, container, false);
      }

      /*CALLBACKS FOR THE PRESENTER*/
      
  }
  ```
  
  **You can see a working example in the [demo-app](demo-app/src/main/java/com/andiag/demo_app/)**
