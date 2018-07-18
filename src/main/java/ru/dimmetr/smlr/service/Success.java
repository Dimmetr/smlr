package ru.dimmetr.smlr.service;

import java.util.Objects;

public class Success implements KeyMapperService.Add {

    private String key;
    private String link;

    public Success(String key, String link) {
        this.key = key;
        this.link = link;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Success success = (Success) o;
        return Objects.equals(key, success.key) &&
                Objects.equals(link, success.link);
    }

    @Override
    public int hashCode() {

        return Objects.hash(key, link);
    }

    @Override
    public String toString() {
        return "Success{" +
                "key='" + key + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}