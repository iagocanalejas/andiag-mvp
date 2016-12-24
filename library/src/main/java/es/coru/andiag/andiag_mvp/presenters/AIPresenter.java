package es.coru.andiag.andiag_mvp.presenters;

import android.support.annotation.NonNull;

/**
 * Created by Iago on 17/12/2016.
 */

public abstract class AIPresenter<C, V> implements AIInterfacePresenter<C, V> {

    private V mView;
    private C mContext;
    private boolean isViewCreated = false;

    protected AIPresenter() {
    }

    @Override
    public final void attach(C context, @NonNull V view) {
        this.mView = view;
        this.mContext = context;
        onViewAttached();
    }

    @Override
    public final void detach() {
        this.mView = null;
        this.mContext = null;
        onViewDetached();
    }

    @Override
    public final V getView() {
        return mView;
    }

    @Override
    public final C getContext() {
        return mContext;
    }

    @Override
    public final boolean isViewAttached() {
        return isViewCreated;
    }

    @Override
    public final boolean hasContext() {
        return mContext != null;
    }

    /**
     * Called when view is detached
     */
    public void onViewDetached() {
        isViewCreated = false;
    }

    /**
     * Call this method from activity when view is created
     */
    public void onViewCreated() {
        isViewCreated = true;
    }

    /**
     * Called when presenter is attached to view.
     * Its recommended to start background processing here
     */
    public abstract void onViewAttached();

}
