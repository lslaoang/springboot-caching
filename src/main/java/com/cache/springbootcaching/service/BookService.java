package com.cache.springbootcaching.service;

import com.cache.springbootcaching.dto.Book;

import java.util.List;


public interface BookService {

    void saveBook(Book book);
    Book getBook(Long id);
    List<Book> getAllBooks();
    Book updateBook(Book book);
    String deleteBook(Long id);
}
