package com.example.library.LibraryAPI.persistence;

import com.example.library.LibraryAPI.persistence.crud.*;
import com.example.library.LibraryAPI.persistence.entity.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;

import java.util.*;
@EnableAutoConfiguration
@Repository
public class AuthorRepository implements com.example.library.LibraryAPI.domain.repository.AuthorRepository{
    @Autowired
    private AuthorCrudRepository authorCrudRepository;

    @Override
    public List<Author> getAll() {
        List<Author> authors = (List<Author>) authorCrudRepository.findAll();
        return authors;
    }
}
