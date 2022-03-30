package com.data.jpa.bookmanager.domain;

import com.data.jpa.bookmanager.domain.listener.Auditable;
import com.data.jpa.bookmanager.domain.listener.AuditableListener;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
@Entity
@EntityListeners(value = AuditableListener.class)
public class Book implements Auditable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String author;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
