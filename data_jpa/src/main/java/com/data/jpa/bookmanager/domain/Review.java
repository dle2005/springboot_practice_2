package com.data.jpa.bookmanager.domain;


import com.data.jpa.bookmanager.domain.base.BaseEntity;
import lombok.Setter;

import javax.persistence.*;

@Setter

@Entity
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private float score;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;
}
