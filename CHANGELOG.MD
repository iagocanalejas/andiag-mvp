# NEXT
    - Core
        - Implemented @Repository annotation with AIRepository and AICrudRepository interfaces to inject in the presenter.

# 0.3
    - Core
        - Changes in Presenter Interfaces Hierachy
        - Null AIPresenter in AIActivity and AIFragment now throws IllegalStateException
        - Changed boolean state controll to a ViewState enum in AIPresenter
        - Implemented @Presenter annotation to inject presenter

    - Common
        - AIInterfaceLoadingView will probably be removed
        - Null mFragmentLayout in AIButterFragment now throws IllegalStateException
        - Implemented an Activity and Presenter to handle Authentication
        - Implemented @FragmentLayout annotation to inject fragment layout

    - Working in the example App
