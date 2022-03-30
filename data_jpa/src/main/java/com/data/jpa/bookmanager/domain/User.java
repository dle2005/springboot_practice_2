package com.data.jpa.bookmanager.domain;

import com.data.jpa.bookmanager.domain.enumtype.Gender;
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
//@Table(name = "user", indexes = { @Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class User implements Auditable {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

//    @PrePersist // persist(insert) method 호출 전
//    public void prePersist() {
//        System.out.println(">>> prePersist");
//        this.createdAt = LocalDateTime.now();
//        this.updatedAt = LocalDateTime.now();
//    }
//
//    @PostPersist // persist method 호출 후
//    public void postPersist() {
//        System.out.println(">>> postPersist");
//    }
//
//    @PreUpdate // merge method 호출 전
//    public void preUpdate() {
//        System.out.println(">>> preUpdate");
//        this.updatedAt = LocalDateTime.now();
//    }
//
//    @PostUpdate // merge method 호출 후
//    public void postUpdate() {
//        System.out.println(">>> postUpdate");
//    }
//
//    @PreRemove // delete method 호출 전
//    public void preRemove() {
//        System.out.println(">>> preRemove");
//    }
//
//    @PostRemove // delete method 호출 후
//    public void postRemove() {
//        System.out.println(">>> postRemove");
//    }
//
//    @PostLoad // select 일어난 후
//    public void postLoad() {
//        System.out.println(">>> postLoad");
//    }

}
