package com.data.jpa.bookmanager.domain;

import com.data.jpa.bookmanager.domain.listener.Auditable;
import com.data.jpa.bookmanager.domain.listener.AuditableListener;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
@Builder
@EntityListeners(value = AuditableListener.class)
public class UserHistory implements Auditable {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;

    private String name;

    private String email;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
