package com.andiag.core.presenters;

import android.support.annotation.NonNull;
import android.util.Log;

import com.andiag.core.views.AIDelegatedView;

import java.lang.ref.WeakReference;

/**
 * Created by Canalejas on 17/12/2016.
 * All presenters must extends this class or implements {@link AIInterfacePresenter}
 */
public abstract class AIPresenter<C, V extends AIDelegatedView> implements AIInterfacePresenter<C, V> {
    private final static String TAG = AIPresenter.class.getSimpleName();

    private WeakReference<V> mView;
    private WeakReference<C> mContext;

    private boolean mViewAttached = false;
    private boolean mViewCreated = false;
    private boolean mLoggingEnabled = false;

    protected AIPresenter() {
    }

    //region Logging

    /**
     * Enable logs
     */
    public void enableLogging() {
        mLoggingEnabled = true;
    }

    /**
     * Private util to log
     *
     * @param message logged
     */
    private void log(String message) {
        if (mLoggingEnabled) {
            Log.i(TAG, mView.getClass().getSimpleName() + message);
        }
    }

    //endregion

    /**
     * {@link AIInterfacePresenter#attach}
     */
    @Override
    public final void attach(C context, @NonNull V view) {
        this.mViewAttached = true;
        this.mView = new WeakReference<>(view);
        this.mContext = new WeakReference<>(context);
        onViewAttached();
        log("Attached");
    }

    /**
     * {@link AIInterfacePresenter#detach}
     */
    @Override
    public final void detach() {
        this.mViewAttached = false;
        this.mView = null;
        this.mContext = null;
        onViewDetached();
        log("Detached");
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
        return mViewAttached;
    }

    /**
     * {@link AIInterfacePresenter#isViewCreated}
     */
    @Override
    public final boolean isViewCreated() {
        return mViewCreated;
    }

    /**
     * {@link AIInterfacePresenter#hasContext}
     */
    @Override
    public final boolean hasContext() {
        return mContext != null;
    }

    /**
     * Called when presenter is attached to view.
     * Its recommended to start background processing here
     */
    protected void onViewAttached() {

    }

    /**
     * Called when view is detached
     */
    protected void onViewDetached() {

    }

    /**
     * Call this method from view when it is created.
     * From now on you can call view methods
     */
    public void onViewCreated() {
        log("View Created");
        mViewCreated = true;
    }

    /**
     * Call this method from view when it is destroyed.
     */
    public void onViewDestroyed() {
        log("View Destroyed");
        mViewCreated = false;
    }

}
