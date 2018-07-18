package ru.dimmetr.smlr.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "links")
public class Link {

    private String text;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "links_sequence")
    @SequenceGenerator(name = "links_sequence", sequenceName = "links_seq")
    private long id;

    public Link() {
        this("", 0);
    }

    public Link(String text) {
        this(text, 0);
    }

    public Link(String text, long id) {
        this.text = text;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Link link = (Link) o;
        return id == link.id &&
                Objects.equals(text, link.text);
    }

    @Override
    public int hashCode() {

        return Objects.hash(text, id);
    }

    @Override
    public String toString() {
        return "Link.java{" +
                "text='" + text + '\'' +
                ", id=" + id +
                '}';
    }
}
