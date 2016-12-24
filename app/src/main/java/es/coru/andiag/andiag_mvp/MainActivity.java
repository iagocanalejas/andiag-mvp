package es.coru.andiag.andiag_mvp;

import android.os.Bundle;
import android.widget.Toast;

import es.coru.andiag.andiag_mvp.views.AIActivity;

public class MainActivity extends AIActivity<CustomPresenter> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setPresenter(CustomPresenter.getInstance());
        getPresenter().onViewCreated();
    }

    /**
     * Example of callback from the presenter.
     *
     * @param text showed in toast
     */
    public void presenterCallback(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

}
