package com.andiag.core.presenters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.andiag.core.annotations.Repository;
import com.andiag.core.repositories.AIRepository;
import com.andiag.core.views.AIDelegatedView;

import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

/**
 * Created by Canalejas on 17/12/2016.
 * All presenters must extends this class or implements {@link AIBasePresenter}
 */
public abstract class AIPresenter<C extends Context, V extends AIDelegatedView> implements AIBasePresenter<C, V> {
    private final static String TAG = AIPresenter.class.getSimpleName();

    private WeakReference<V> mView;
    private WeakReference<C> mContext;
    protected AIRepository mRepository;

    protected ViewState mViewState = ViewState.DETACHED;
    private boolean mLoggingEnabled = false;

    protected AIPresenter() {
        Repository annotation = getClass().getAnnotation(Repository.class);
        if (annotation != null) {
            try {
                if (annotation.initiator().equals("")) {
                    mRepository = annotation.repository().getConstructor().newInstance();
                } else {
                    for (Method method : annotation.repository().getMethods()) {
                        if (method.getName().equals(annotation.initiator())) {
                            /**
                             * Param can be null cause this case is just for singletons, that means,
                             * method invoked should be static.
                             */
                            mRepository = (AIRepository) method.invoke(null);
                        }
                    }
                    if (mRepository == null) {
                        throw new IllegalStateException("Initiator method not found");
                    }
                }
            } catch (Exception e) {
                throw new IllegalStateException("Error injecting repository");
            }
        } else {
            Log.i(TAG, "Not injected repository");
        }
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
     * {@link AIBasePresenter#attach}
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
     * {@link AIBasePresenter#detach}
     */
    @Override
    public final void detach() {
        logInfo("Detached");
        this.mViewState = ViewState.DETACHED;
        onViewDetached();
    }

    /**
     * {@link AIBasePresenter#getView}
     */
    @Override
    public final V getView() {
        return mView.get();
    }

    /**
     * {@link AIBasePresenter#getContext}
     */
    @Override
    public final C getContext() {
        return mContext.get();
    }

    /**
     * {@link AIBasePresenter#getViewState()}
     */
    @Override
    public final ViewState getViewState() {
        return mViewState;
    }

    /**
     * {@link AIBasePresenter#isViewAttached}
     */
    @Override
    public final boolean isViewAttached() {
        return mViewState == ViewState.ATTACHED
                || mViewState == ViewState.CREATED;
    }

    /**
     * {@link AIBasePresenter#isViewCreated}
     */
    @Override
    public final boolean isViewCreated() {
        return mViewState == ViewState.CREATED;
    }

    /**
     * {@link AIBasePresenter#hasContext}
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
