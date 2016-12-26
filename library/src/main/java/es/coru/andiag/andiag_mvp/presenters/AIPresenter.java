package es.coru.andiag.andiag_mvp.presenters;

import android.support.annotation.NonNull;

import java.lang.ref.WeakReference;

/**
 * Created by Canalejas on 17/12/2016.
 * All presenters must extends this class or implements {@link AIInterfacePresenter}
 */
public abstract class AIPresenter<C, V> implements AIInterfacePresenter<C, V> {

    private WeakReference<V> mView;
    private WeakReference<C> mContext;

    private boolean isViewAttached = false;
    private boolean isViewCreated = false;

    protected AIPresenter() {
    }

    /**
     * {@link AIInterfacePresenter#attach}
     */
    @Override
    public final void attach(C context, @NonNull V view) {
        this.isViewAttached = true;
        this.mView = new WeakReference<V>(view);
        this.mContext = new WeakReference<C>(context);
        onViewAttached();
    }

    /**
     * {@link AIInterfacePresenter#detach}
     */
    @Override
    public final void detach() {
        this.isViewAttached = false;
        this.mView = null;
        this.mContext = null;
        onViewDetached();
    }

    /**
     * {@link AIInterfacePresenter#getView}
     */
    @Override
    public final V getView() {
        return mView.get();
    }

    /**
     * {@link AIInterfacePresenter#getContext}
     */
    @Override
    public final C getContext() {
        return mContext.get();
    }

    /**
     * {@link AIInterfacePresenter#isViewAttached}
     */
    @Override
    public final boolean isViewAttached() {
        return isViewAttached;
    }

    /**
     * {@link AIInterfacePresenter#isViewCreated}
     */
    @Override
    public final boolean isViewCreated() {
        return isViewCreated;
    }

    /**
     * {@link AIInterfacePresenter#hasContext}
     */
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
     * Call this method from activity when view is created.
     * From now on you can call view methods
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
