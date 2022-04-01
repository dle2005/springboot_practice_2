package com.data.jpa.bookmanager.repository;

import com.data.jpa.bookmanager.domain.Book;
import com.data.jpa.bookmanager.domain.dto.BookNameAndCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "select b from Book b " +
            "where b.name = :name and b.createdAt >= :createdAt and b.updatedAt >= :updatedAt")
    List<Book> findByNameRecently(
            @Param("name") String name,
            @Param("createdAt") LocalDateTime createdAt,
            @Param("updatedAt") LocalDateTime updatedAt
    );

//    @Query(value = "select b.name as name, b.category as cateogry from Book b")
//    List<BookNameAndCategory> findBookNameAndCategory();

    @Query(value = "select new com.data.jpa.bookmanager.domain.dto.BookNameAndCategory(b.name, b.category)" +
            " from Book b")
    List<BookNameAndCategory> findBookNameAndCategory();

    @Query(value = "select * from book", nativeQuery = true)
    List<Book> findAllCustom();

    @Modifying
    @Transactional
    @Query(value = "update book set category = 'category'", nativeQuery = true)
    int updateCategories();

    @Query(value = "show tables", nativeQuery = true)
    List<String> showTables();

    @Query(value = "select * from book order by id desc limit 1", nativeQuery = true)
    Map<String, Object> findRawRecord();
}
