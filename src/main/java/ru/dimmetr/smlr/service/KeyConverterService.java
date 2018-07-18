package ru.dimmetr.smlr.service;

public interface KeyConverterService {

    String idToKey(long id);
    long keyToId(String key);
}
