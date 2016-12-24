package es.coru.andiag.andiag_mvp.presenters;

/**
 * Created by Iago on 17/12/2016.
 */

public interface AIInterfacePresenter<C, V> {

    V getView();

    C getContext();

    void attach(C context, V view);

    void detach();

    boolean isViewAttached();

    boolean hasContext();

}
