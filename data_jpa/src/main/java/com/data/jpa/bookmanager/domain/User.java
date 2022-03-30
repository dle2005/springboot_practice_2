package com.data.jpa.bookmanager.domain;

import com.data.jpa.bookmanager.domain.enumtype.Gender;
import com.data.jpa.bookmanager.domain.listener.Auditable;
import com.data.jpa.bookmanager.domain.listener.UserEntityListener;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder

@Setter
@Getter

@Entity
@EntityListeners(value = UserEntityListener.class)
//@Table(name = "user", indexes = { @Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class User extends BaseEntity implements Auditable {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

}
