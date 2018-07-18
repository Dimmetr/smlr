package ru.dimmetr.smlr.model;

import javax.persistence.*;

@Entity
@Table(name = "links")
public class Link {

    private String text;
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Link(String text) {
        this(text, 0);
    }

    public Link(String text, long id) {
        this.text = text;
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
