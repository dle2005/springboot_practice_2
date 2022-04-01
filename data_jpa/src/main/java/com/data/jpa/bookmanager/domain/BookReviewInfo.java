package com.data.jpa.bookmanager.domain;

import com.data.jpa.bookmanager.domain.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter

@ToString

@Entity
public class BookReviewInfo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Exclude
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @ToString.Exclude
    private Book book;

    private float averageReviewScore;

    private int reviewCount;
}
