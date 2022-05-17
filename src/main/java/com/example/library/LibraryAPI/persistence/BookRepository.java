package com.example.library.LibraryAPI.persistence;

import com.example.library.LibraryAPI.persistence.crud.*;
import com.example.library.LibraryAPI.persistence.entity.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;

import java.util.*;

@EnableAutoConfiguration
@Repository
public class BookRepository implements com.example.library.LibraryAPI.domain.repository.BookRepository {
    @Autowired
    private BookCrudRepository bookCrudRepository;
    @Autowired
    private BorrowCrudRepository borrowCrudRepository;


    @Override
    public List<Book> getAll() {
        List<Book> books = (List<Book>) bookCrudRepository.findAll();
        return books;
    }

    @Override
    public Optional<Book> getBook(int bookId) {
        return bookCrudRepository.findById(bookId);
    }

    @Override
    public Book save(Book book) {
        return bookCrudRepository.save(book);
    }


    @Override
    public Optional<List<Book>> findByNameContaining(String name) {
        List<Book> books = bookCrudRepository.findByNameContaining(name);
        return Optional.of(books);
    }


    @Override
    public Optional<List<Book>> findByAuthorOrSurname(String author, String surname) {
        List<Book> books = bookCrudRepository.findByAuthorOrSurname(author, surname);
        return Optional.of(books);
    }

    @Override
    public void delete(int bookId) {
        bookCrudRepository.deleteById(bookId);

    }


}
