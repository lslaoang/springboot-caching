package com.cache.springbootcaching.bootstrap;

import com.cache.springbootcaching.dto.Book;
import com.cache.springbootcaching.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitValue implements CommandLineRunner {

    private final BookService bookService;

    public InitValue(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        Book b1 = new Book();
        b1.setId(1L);
        b1.setTitle("History");

        Book b2 = new Book();
        b2.setId(2L);
        b2.setTitle("Science");

        Book b3 = new Book();
        b3.setId(3L);
        b3.setTitle("Arts");

        bookService.saveBook(b1);
        bookService.saveBook(b2);
        bookService.saveBook(b3);
    }
}
