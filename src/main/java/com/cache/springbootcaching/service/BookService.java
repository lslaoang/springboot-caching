package com.cache.springbootcaching.service;

import com.cache.springbootcaching.dto.Book;

import java.util.List;


public interface BookService {

    public void saveBook(Book book);
    public Book get(Long id);
    public List<Book> getAllBooks();
}
