package com.data.jpa.bookmanager.domain;

import com.data.jpa.bookmanager.domain.base.BaseEntity;
import com.data.jpa.bookmanager.domain.converter.BookStatusConverter;
import com.data.jpa.bookmanager.domain.dto.BookStatus;
import com.data.jpa.bookmanager.domain.listener.Auditable;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor

@Setter
@Getter

@ToString

@Where(clause = "deleted = false")

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
    @ToString.Exclude
    private List<Review> reviews = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Publisher publisher;

    @ManyToMany
    @ToString.Exclude
    private List<Author> authors = new ArrayList<>();

    private boolean deleted;

    @Convert(converter = BookStatusConverter.class)
    private BookStatus status;

    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    public void addAuthor(Author... authors) {
        Collections.addAll(this.authors, authors);
    }
}
