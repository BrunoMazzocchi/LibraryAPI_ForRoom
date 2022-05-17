package com.example.library.LibraryAPI.persistence.crud;

import com.example.library.LibraryAPI.persistence.entity.*;
import org.hibernate.mapping.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.*;

import java.util.*;
import java.util.List;


public interface BookCrudRepository extends CrudRepository<Book, Integer> {
    @Query(value = "\n" +
            "SELECT dbo.books.*, dbo.authors.name AS 'Author', dbo.authors.surname as 'Surname' FROM  dbo.books INNER JOIN   dbo.authors ON dbo.books.author_id = dbo.authors.author_id where authors.name = '?' OR authors.surname = 'Howells';", nativeQuery = true)
    List<Book> findByAuthorOrSurname(String author, String surname);

    // List<Book> findByAuthorOrSurname(String author, String surname);

    List<Book> findByNameContaining(String name);


//    @Query(value = "select * from dbo.books where dbo.books.name like '%?%'", nativeQuery = true)
//    List<Book> getBookByName(String name);
}

