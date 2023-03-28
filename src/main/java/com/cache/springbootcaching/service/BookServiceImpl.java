package com.cache.springbootcaching.service;

import com.cache.springbootcaching.dto.Book;
import com.cache.springbootcaching.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class.getName());
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void saveBook(Book book) {
        LOGGER.info("Book with ID: {} saved!", book.getId());
        bookRepository.save(book);
    }

    @Override
    public Book get(Long id) {
        LOGGER.info("Book with ID: {} fetched", id);
        return  bookRepository.getReferenceById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        LOGGER.info("Finding all books in the record.");
        return  bookRepository.findAll();
    }

}
