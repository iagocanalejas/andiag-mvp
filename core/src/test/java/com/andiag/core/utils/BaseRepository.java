package com.andiag.core.utils;

import com.andiag.core.repositories.AIRepository;

/**
 * Created by Canalejas on 15/02/2017.
 */

public class BaseRepository implements AIRepository {

    public static BaseRepository newInstance() {
        return new BaseRepository();
    }

}
