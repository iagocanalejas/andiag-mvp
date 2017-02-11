package com.andiag.core.annotations;

import com.andiag.core.repositories.AIRepository;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Canalejas on 11/02/2017.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) //on class level
public @interface Repository {

    Class<? extends AIRepository> repository();

    String initiator() default "";

}
