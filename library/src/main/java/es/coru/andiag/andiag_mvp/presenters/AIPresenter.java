package es.coru.andiag.andiag_mvp.presenters;

import android.support.annotation.NonNull;

import java.lang.ref.WeakReference;

import es.coru.andiag.andiag_mvp.views.AIDelegatedView;

/**
 * Created by Canalejas on 17/12/2016.
 * All presenters must extends this class or implements {@link AIInterfacePresenter}
 */
public abstract class AIPresenter<C, V extends AIDelegatedView> implements AIInterfacePresenter<C, V> {
    private final static String TAG = AIPresenter.class.getSimpleName();

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
        this.mView = new WeakReference<>(view);
        this.mContext = new WeakReference<>(context);
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
     * Call this method from activity when view is created.
     * From now on you can call view methods
     */
    public void onViewCreated() {
        isViewCreated = true;
    }

    /**
     * Call this method from activity when view is destroyed.
     */
    public void onViewDestroyed() {
        isViewCreated = false;
    }

}
