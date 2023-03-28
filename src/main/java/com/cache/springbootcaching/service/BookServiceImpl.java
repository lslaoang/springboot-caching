package com.cache.springbootcaching.service;

import com.cache.springbootcaching.dto.Book;
import com.cache.springbootcaching.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    @Cacheable(cacheNames = "books", key = "#id")
    public Book getBook(Long id) {
        LOGGER.info("Book with ID: {} fetched", id);
        Optional<Book> book = bookRepository.findById(id);
        return book.orElseGet(Book::new);
    }

    @Override
    public List<Book> getAllBooks() {
        LOGGER.info("Finding all books in the record.");
        return  bookRepository.findAll();
    }

    @Override
    @CachePut(cacheNames = "books", key = "#book.id")
    public Book updateBook(Book book) {
        LOGGER.info("Updating book with id {}.", book.getId());
        bookRepository.updateBook(book.getId(), book.getTitle());
        return book;
    }

    @Override
    @CacheEvict(cacheNames = "books", key = "#id")
    public String deleteBook(Long id) {
        LOGGER.warn("Deleting book with id: {}", id);
        bookRepository.deleteById(id);
        return "Book deleted.";
    }

}
