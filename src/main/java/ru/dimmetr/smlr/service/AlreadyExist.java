package ru.dimmetr.smlr.service;

import java.util.Objects;

public class AlreadyExist implements KeyMapperService.Add {

    private String key;

    public AlreadyExist(String key) {
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
        AlreadyExist that = (AlreadyExist) o;
        return Objects.equals(key, that.key);
    }

    @Override
    public int hashCode() {

        return Objects.hash(key);
    }

    @Override
    public String toString() {
        return "AlreadyExist{" +
                "key='" + key + '\'' +
                '}';
    }
}