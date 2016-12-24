package es.coru.andiag.andiag_mvp.views;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import es.coru.andiag.andiag_mvp.presenters.AIPresenter;


/**
 * Created by Canalejas on 11/12/2016.
 */

public abstract class AIFragment<P extends AIPresenter> extends Fragment {
    private final static String TAG = AIFragment.class.getSimpleName();

    protected Context mParentContext;
    protected P mPresenter;

    protected abstract void initPresenter();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mParentContext = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPresenter();
        mPresenter.attach(mParentContext, this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mPresenter == null) {
            initPresenter();
        }
        if (!mPresenter.isViewAttached()) {
            mPresenter.attach(mParentContext, this);
        }
        mPresenter.onViewCreated();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mPresenter == null || !mPresenter.isViewAttached()) {
            if (mPresenter == null) {
                initPresenter();
            }
            if (!mPresenter.isViewAttached()) {
                mPresenter.attach(mParentContext, this);
            }
            mPresenter.onViewCreated();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.detach();
        mPresenter = null;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mParentContext = null;
    }

}
