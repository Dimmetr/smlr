package ru.dimmetr.smlr.service;

import java.util.Objects;

public class AddResponse {

    private String link;
    private String key;

    public AddResponse() {
        this("", "");
    }

    public AddResponse(String link, String key) {
        this.link = link;
        this.key = key;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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
        AddResponse that = (AddResponse) o;
        return Objects.equals(link, that.link) &&
                Objects.equals(key, that.key);
    }

    @Override
    public int hashCode() {

        return Objects.hash(link, key);
    }

    @Override
    public String toString() {
        return "AddResponse{" +
                "link='" + link + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}
