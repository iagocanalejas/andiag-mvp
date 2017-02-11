package com.andiag.core.repositories;

/**
 * Created by Canalejas on 11/02/2017.
 */

public interface AICrudRepository<K, V> extends AIRepository {

    V create(V object);

    V read(K key);

    V update(V object);

    V update(K key, V object);

    boolean delete(K key);

}
