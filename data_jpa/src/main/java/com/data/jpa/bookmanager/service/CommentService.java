package com.data.jpa.bookmanager.service;

import com.data.jpa.bookmanager.domain.Comment;
import com.data.jpa.bookmanager.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Transactional
    public void init() {
        for (int i = 0; i < 10; i++) {
            Comment comment = new Comment();
            comment.setComment("comment" + i);

            commentRepository.save(comment);
        }
    }

    @Transactional(readOnly = true)
    void updateComment() {
        List<Comment> comments = commentRepository.findAll();

        for (Comment comment : comments) {
            comment.setComment("update " + comment.getComment());

//            commentRepository.save(comment);
        }
    }
}
