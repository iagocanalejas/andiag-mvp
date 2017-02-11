package com.andiag.core.annotations;

import com.andiag.core.presenters.AIPresenter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Iago on 05/01/2017.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) //on class level
public @interface Presenter {

    Class<? extends AIPresenter> presenter();

}
