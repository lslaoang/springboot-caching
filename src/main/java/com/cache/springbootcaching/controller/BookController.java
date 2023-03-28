package com.cache.springbootcaching.controller;

import com.cache.springbootcaching.dto.Book;
import com.cache.springbootcaching.model.BookModel;
import com.cache.springbootcaching.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

import static com.cache.springbootcaching.util.BookUtil.toBookModel;

@Controller
@RequestMapping("/api/v1")
public class BookController {

    private final Logger LOGGER = LoggerFactory.getLogger(BookController.class.getName());

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/books/{id}")
    @Cacheable(cacheNames = "book", key = "#id")
    public ResponseEntity<?> getBook(@PathVariable Long id){
        Book book = bookService.get(id);
        BookModel bookModel = toBookModel(book);
        LOGGER.info("Book information. ID: {}, TITLE: {}.",book.getId(), book.getTitle() );
        return new ResponseEntity<>( bookModel, HttpStatus.ACCEPTED);

    }

    @GetMapping(value = "/books")
    @Cacheable(cacheNames = "books")
    public ResponseEntity<?> getBook(){
        List<Book> books = bookService.getAllBooks();
        List<BookModel> bookModels = new ArrayList<>();

        for(Book book : books){
            bookModels.add(toBookModel(book));
        }

        LOGGER.info("Listing all the books in the repository.");
        return new ResponseEntity<>( bookModels, HttpStatus.ACCEPTED);

    }
}
