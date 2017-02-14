package com.andiag.core.presenters;


import com.andiag.core.views.AIDelegatedView;

/**
 * Created by Canalejas on 17/12/2016.
 */
public interface AIBasePresenter<C, V extends AIDelegatedView> {

    /**
     * @return presenter's view or null
     */
    V getView();

    /**
     * @return presenter's context or null
     */
    C getContext();

    /**
     * @return presenter view state
     */
    ViewState getViewState();

    /**
     * Add context and view to the presenter
     *
     * @param context new context {@link android.app.Application} {@link android.app.Activity} ...
     * @param view    new view {@link android.app.Activity} {@link android.app.Fragment} ...
     */
    void attach(C context, V view);

    /**
     * Remove view and context if exist from presenter
     */
    void detach();

    /**
     * @return true if view is attached to presenter, false otherwise
     */
    boolean isViewAttached();

    /**
     * @return true if view is showing, false otherwise
     */
    boolean isViewCreated();

    /**
     * @return true if context exist false otherwise
     */
    boolean hasContext();

}
