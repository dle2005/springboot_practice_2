package com.data.jpa.bookmanager.repository;

import com.data.jpa.bookmanager.domain.Comment;
import com.data.jpa.bookmanager.domain.Review;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class ReviewRepositoryTest {

    @Autowired private EntityManager entityManager;
    @Autowired private CommentRepository commentRepository;
    @Autowired private ReviewRepository reviewRepository;

    @BeforeEach
    void init() {
        Comment comment = new Comment();
        comment.setComment("comment");

        commentRepository.save(comment);

        Comment comment1 = new Comment();
        comment1.setComment("comment1");

        commentRepository.save(comment1);

        Review review = new Review();
        review.addComment(comment);
        reviewRepository.save(review);

        Review review1 = new Review();
        review1.addComment(comment1);
        reviewRepository.save(review1);

        entityManager.flush();
        entityManager.clear();
    }

    @Test
    @Transactional
    void nPlusOne() {
        List<Review> reviews = reviewRepository.findAll();

        System.out.println("findAll()");

        System.out.println(reviews.get(0).getComments());

        System.out.println("get(0).getComments()");

        System.out.println(reviews.get(1).getComments());

        System.out.println("get(1).getComments()");
    }

    @Test
    @Transactional
    void joinFetchTest() {
        List<Review> reviews = reviewRepository.findAllByFetchJoin();

        System.out.println("findAll()");

        System.out.println(reviews.get(0).getComments());

        System.out.println("get(0).getComments()");

        System.out.println(reviews.get(1).getComments());

        System.out.println("get(1).getComments()");
    }

    @Test
    @Transactional
    void entityGraph() {
        List<Review> reviews = reviewRepository.findAllByEntityGraph();

        System.out.println("findAll()");

        System.out.println(reviews.get(0).getComments());

        System.out.println("get(0).getComments()");

        System.out.println(reviews.get(1).getComments());

        System.out.println("get(1).getComments()");
    }
}