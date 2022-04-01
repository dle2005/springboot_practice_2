package com.data.jpa.bookmanager.service;

import com.data.jpa.bookmanager.domain.Book;
import com.data.jpa.bookmanager.domain.Publisher;
import com.data.jpa.bookmanager.domain.dto.BookStatus;
import com.data.jpa.bookmanager.repository.AuthorRepository;
import com.data.jpa.bookmanager.repository.BookRepository;
import com.data.jpa.bookmanager.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceTest {

    @Autowired private BookService bookService;
    @Autowired private BookRepository bookRepository;
    @Autowired private AuthorRepository authorRepository;
    @Autowired private AuthorService authorService;
    @Autowired private PublisherRepository publisherRepository;

    @Test
    public void transactionTest() {
        try {
            bookService.putBookAndAuthor();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("books: " + bookRepository.findAll());
        System.out.println("authors: " + authorRepository.findAll());
    }

    @Test
    void isolationTest() {
        Book book = new Book();
        book.setName("JPA 강의");

        bookRepository.save(book);

        bookService.get(1L);

        System.out.println(bookRepository.findAll());
    }

    @Test
    void cascadeTest() {
        Book book = new Book();
        book.setName("book");

//        bookRepository.save(book);

        Publisher publisher = new Publisher();
        publisher.setName("publisher");
        publisher.addBook(book);

        publisherRepository.save(publisher);

//        book.setPublisher(publisher);
//        bookRepository.save(book);

//        publisher.addBook(book);
//        publisherRepository.save(publisher);

        System.out.println(bookRepository.findAll());
        System.out.println(publisherRepository.findAll());

        publisher.setName("publisher_changed");
        publisherRepository.save(publisher);

        System.out.println(publisherRepository.findAll());

        bookRepository.delete(book);

        System.out.println(bookRepository.findAll());
        System.out.println(publisherRepository.findAll());
    }

    @Test
    void converterTest() {
        Book book = new Book();
        book.setName("book");
        book.setStatus(new BookStatus(200));

        bookRepository.save(book);

        System.out.println(bookRepository.findRawRecord().values());
    }
}