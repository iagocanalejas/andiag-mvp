package com.andiag.shared.core.presenters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.andiag.shared.core.views.AIDelegatedView;

import java.lang.ref.WeakReference;

/**
 * Created by Canalejas on 17/12/2016.
 * All presenters must extends this class or implements {@link AIInterfacePresenter}
 */
public abstract class AIPresenter<C extends Context, V extends AIDelegatedView> implements AIInterfacePresenter<C, V> {
    private final static String TAG = AIPresenter.class.getSimpleName();

    private WeakReference<V> mView;
    private WeakReference<C> mContext;

    protected ViewState mViewState = ViewState.DETACHED;
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
     * Util to easy logInfo in presenters
     *
     * @param message logged
     */
    protected void logInfo(String message) {
        logInfo(TAG, message);
    }

    /**
     * Util to easy logInfo in presenters
     *
     * @param tag     log tag
     * @param message logged
     */
    protected void logInfo(String tag, String message) {
        if (mLoggingEnabled && mView != null) {
            Log.i(tag, mView.getClass().getSimpleName() + message);
        }
    }
    //endregion

    /**
     * {@link AIInterfacePresenter#attach}
     */
    @Override
    public final void attach(C context, @NonNull V view) {
        this.mView = new WeakReference<>(view);
        this.mContext = new WeakReference<>(context);
        this.mViewState = ViewState.ATTACHED;
        onViewAttached();
        logInfo("Attached");
    }

    /**
     * {@link AIInterfacePresenter#detach}
     */
    @Override
    public final void detach() {
        logInfo("Detached");
        this.mView = null;
        this.mContext = null;
        this.mViewState = ViewState.DETACHED;
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
     * {@link AIInterfacePresenter#getViewState()}
     */
    @Override
    public final ViewState getViewState() {
        return mViewState;
    }

    /**
     * {@link AIInterfacePresenter#isViewAttached}
     */
    @Override
    public final boolean isViewAttached() {
        return mViewState == ViewState.ATTACHED
                || mViewState == ViewState.CREATED;
    }

    /**
     * {@link AIInterfacePresenter#isViewCreated}
     */
    @Override
    public final boolean isViewCreated() {
        return mViewState == ViewState.CREATED;
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
        logInfo("View Created");
        this.mViewState = ViewState.CREATED;
    }

    /**
     * Call this method from view when it is destroyed.
     */
    public void onViewDestroyed() {
        logInfo("View Destroyed");
        this.mViewState = ViewState.DESTROYED;
    }

}
