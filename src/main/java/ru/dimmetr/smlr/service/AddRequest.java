package ru.dimmetr.smlr.service;

import ru.dimmetr.smlr.controllers.AddController;

import java.util.Objects;

public class AddRequest extends AddController {

    private String link;

    public AddRequest() {
        this("");
    }

    public AddRequest(String link) {
        this.link = link;
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
        AddRequest that = (AddRequest) o;
        return Objects.equals(link, that.link);
    }

    @Override
    public int hashCode() {

        return Objects.hash(link);
    }

    @Override
    public String toString() {
        return "AddRequest{" +
                "link='" + link + '\'' +
                '}';
    }
}