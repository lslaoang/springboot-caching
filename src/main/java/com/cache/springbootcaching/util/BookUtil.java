package com.cache.springbootcaching.util;

import com.cache.springbootcaching.dto.Book;
import com.cache.springbootcaching.model.BookModel;

public class BookUtil {
    public static Book toBookDto(BookModel bookModel){
        Book book = new Book();
        book.setId(book.getId());
        book.setTitle(book.getTitle());
        return book;
    }

    public static BookModel toBookModel(Book book){
        BookModel bookModel = new BookModel();
        bookModel.setId(book.getId());
        bookModel.setTitle(book.getTitle());
        return bookModel;
    }
}
