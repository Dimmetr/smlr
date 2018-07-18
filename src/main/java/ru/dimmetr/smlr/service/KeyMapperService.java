package ru.dimmetr.smlr.service;

public interface KeyMapperService {

    interface Add {}

    interface Get {}

    Add add(String key, String link);

    Get getLink(String key);
}

