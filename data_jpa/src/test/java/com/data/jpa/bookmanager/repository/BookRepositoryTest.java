package com.data.jpa.bookmanager.repository;

import com.data.jpa.bookmanager.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookRepositoryTest {

    @Autowired private BookRepository bookRepository;

    @Test
    void queryTest() {
        Book book = new Book();
        book.setName("Book");
        bookRepository.save(book);

        System.out.println(bookRepository.findBookNameAndCategory());
    }

    @Test
    void nativeQueryTest() {
        Book book = new Book();
        book.setName("Book");
        bookRepository.save(book);

        System.out.println(bookRepository.findAll());
        System.out.println(bookRepository.findAllCustom());
    }

    @Test
    void nativeQueryTest2() {
        Book book = new Book();
        book.setName("Book");
        bookRepository.save(book);

        Book book1 = new Book();
        book1.setName("Book1");
        bookRepository.save(book1);

        bookRepository.updateCategories();

        bookRepository.findAllCustom().forEach(System.out::println);
    }

    @Test
    void showTableTest() {
        System.out.println(bookRepository.showTables());
    }
}