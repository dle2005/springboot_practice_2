package com.data.jpa.bookmanager.domain;

import com.data.jpa.bookmanager.domain.listener.Auditable;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder

@Setter
@Getter

@Entity
public class Book extends BaseEntity implements Auditable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String author;
}
