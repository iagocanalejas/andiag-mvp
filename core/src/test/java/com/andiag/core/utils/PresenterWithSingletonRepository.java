package com.andiag.core.utils;

import com.andiag.core.annotations.Repository;
import com.andiag.core.presenters.AIPresenter;
import com.andiag.core.repositories.AIRepository;

/**
 * Created by Canalejas on 15/02/2017.
 */
@Repository(repository = BaseRepository.class, initiator = "newInstance")
public class PresenterWithSingletonRepository extends AIPresenter {

    public AIRepository getRepository() {
        return mRepository;
    }

}
