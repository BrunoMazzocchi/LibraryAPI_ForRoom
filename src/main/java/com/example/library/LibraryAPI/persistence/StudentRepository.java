package com.example.library.LibraryAPI.persistence;

import com.example.library.LibraryAPI.persistence.crud.*;
import com.example.library.LibraryAPI.persistence.entity.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;

import java.util.*;
@EnableAutoConfiguration
@Repository
public class StudentRepository  implements  com.example.library.LibraryAPI.domain.repository.StudentRepository {

    @Autowired
    private StudentCrudRepository studentCrudRepository;

    @Override
    public List<Student> getAll() {
        List<Student> students = (List<Student>) studentCrudRepository.getAll();
        return students;
    }
}