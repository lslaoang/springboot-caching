package com.cache.springbootcaching.service;

import com.cache.springbootcaching.dto.Book;

import java.util.List;


public interface BookService {

    public void saveBook(Book book);
    public Book getBook(Long id);
    public List<Book> getAllBooks();
    public void updateBook(Book book);
    public String deleteBook(Long id);
}
