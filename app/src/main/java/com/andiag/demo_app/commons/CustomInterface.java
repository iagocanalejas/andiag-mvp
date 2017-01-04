package com.andiag.demo_app.commons;

import com.andiag.shared.core.views.AIDelegatedView;

/**
 * Created by Canalejas on 04/01/2017.
 */

public interface CustomInterface extends AIDelegatedView {

    void presenterCallback(String text);

    void viewAttached();

    void viewCreated();

}
