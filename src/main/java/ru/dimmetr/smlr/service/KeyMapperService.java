package ru.dimmetr.smlr.service;

public interface KeyMapperService {

    interface Add {}

    interface Get {}

    Get getLink(String key);

    String add(String link);
}

