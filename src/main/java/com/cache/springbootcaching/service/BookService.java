package com.cache.springbootcaching.service;

import com.cache.springbootcaching.dto.Book;


public interface BookService {

    public void saveBook(Book book);
    public Book get(Long id);
}
