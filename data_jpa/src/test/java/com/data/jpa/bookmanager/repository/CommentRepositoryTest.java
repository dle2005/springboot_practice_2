package com.data.jpa.bookmanager.repository;

import com.data.jpa.bookmanager.domain.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
class CommentRepositoryTest {

    @Autowired private EntityManager entityManager;
    @Autowired private CommentRepository commentRepository;

    @Test
    @Transactional
    void entityContextTest() {
        Comment comment = new Comment();
        comment.setComment("comment");

        commentRepository.saveAndFlush(comment);

        entityManager.clear();

        System.out.println(comment);

        commentRepository.findAll().forEach(System.out::println);
    }
}