package ru.dimmetr.smlr.service;

import java.util.Objects;

public class NotFound implements KeyMapperService.Get {

    private String key;

    public NotFound(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotFound notFound = (NotFound) o;
        return Objects.equals(key, notFound.key);
    }

    @Override
    public int hashCode() {

        return Objects.hash(key);
    }

    @Override
    public String toString() {
        return "NotFound{" +
                "key='" + key + '\'' +
                '}';
    }
}