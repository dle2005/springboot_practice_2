package com.data.jpa.bookmanager.service;

import com.data.jpa.bookmanager.domain.Author;
import com.data.jpa.bookmanager.domain.Book;
import com.data.jpa.bookmanager.repository.AuthorRepository;
import com.data.jpa.bookmanager.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final AuthorService authorService;

    @Transactional(propagation = Propagation.REQUIRED)
    public void putBookAndAuthor() {
        Book book = new Book();
        book.setName("JPA 시작하기");

        bookRepository.save(book);

        try {
            authorService.putAuthor();
        } catch (RuntimeException e) {

        }

//        Author author = new Author();
//        author.setName("martin");
//
//        authorRepository.save(author);
//
        throw new RuntimeException("RuntimeException");
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void get(Long id) {
        System.out.println(bookRepository.findById(id));
        System.out.println(bookRepository.findAll());

        System.out.println(bookRepository.findById(id));
        System.out.println(bookRepository.findAll());
    }
}
