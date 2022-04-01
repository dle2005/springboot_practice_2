package com.data.jpa.bookmanager.domain;

import com.data.jpa.bookmanager.domain.base.BaseEntity;
import com.data.jpa.bookmanager.domain.listener.Auditable;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor

@Setter
@Getter

@Entity
public class Book extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String category;

    private Long authorId;

    @OneToOne(mappedBy = "book", fetch = FetchType.LAZY)
    private BookReviewInfo bookReviewInfo;

    @OneToMany
    @JoinColumn(name = "book_id")
    private List<Review> reviews = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Publisher publisher;

    @ManyToMany
    private List<Author> authors = new ArrayList<>();

    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    public void addAuthor(Author... authors) {
        Collections.addAll(this.authors, authors);
    }
}
