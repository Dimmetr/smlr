package ru.dimmetr.smlr.service;

import java.util.Objects;

public class Link implements KeyMapperService.Get {

    private String link;

    public Link(String link) {
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
        Link link1 = (Link) o;
        return Objects.equals(link, link1.link);
    }

    @Override
    public int hashCode() {

        return Objects.hash(link);
    }

    @Override
    public String toString() {
        return "Link{" +
                "link='" + link + '\'' +
                '}';
    }
}
