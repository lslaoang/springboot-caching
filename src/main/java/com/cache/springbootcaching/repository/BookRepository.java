package com.cache.springbootcaching.repository;

import com.cache.springbootcaching.dto.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE Book u set u.title =?2 where u.id=?1")
    void updateBook(Long id, String title);
}
