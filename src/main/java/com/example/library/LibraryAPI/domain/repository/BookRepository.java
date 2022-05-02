package com.example.library.LibraryAPI.domain.repository;

import com.example.library.LibraryAPI.persistence.entity.*;
import org.springframework.stereotype.*;

import javax.swing.text.html.*;
import java.util.*;

@Repository
public interface BookRepository {
    List<Book> getAll();

    Optional<Book> getBook(int bookId);

    Book save(Book book);

    Optional<List<Book>> findByAuthorOrSurname(String author, String surname);
    //Optional<List<Book>> findByAuthorOrSurname(String author, String surname);

    void delete(int bookId);

    Optional<List<Book>> findByNameContaining(String username);


}
