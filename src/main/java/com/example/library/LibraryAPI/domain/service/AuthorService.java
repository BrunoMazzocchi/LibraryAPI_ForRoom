package com.example.library.LibraryAPI.domain.service;

import com.example.library.LibraryAPI.domain.repository.*;
import com.example.library.LibraryAPI.persistence.entity.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;
@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAll() {
        return authorRepository.getAll();
    }
}
