package es.coru.andiag.andiag_mvp.views;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;

import es.coru.andiag.andiag_mvp.presenters.AIPresenter;


/**
 * Created by Canalejas on 11/12/2016.
 */

public abstract class AIFragment<P extends AIPresenter> extends Fragment {
    private final static String TAG = AIFragment.class.getSimpleName();

    private Context mParentContext;
    private P mPresenter;

    protected void setPresenter(@NonNull P presenter) {
        mPresenter = presenter;
    }

    protected P getPresenter() {
        return mPresenter;
    }

    public Context getContext() {
        return mParentContext;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mParentContext = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mPresenter == null) {
            Log.e(TAG, "Null Presenter: Initialize it on setPresenter method");
        }
        mPresenter.attach(mParentContext, this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.onViewCreated();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.mPresenter.detach();
        this.mPresenter = null;
        this.mParentContext = null;
    }

}
