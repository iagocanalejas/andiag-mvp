package es.coru.andiag.andiag_mvp.views;

/**
 * Created by Canalejas on 10/12/2016.
 */

public interface AIInterfaceView<P> {

    void setPresenter(P presenter);

    P getPresenter();

}
