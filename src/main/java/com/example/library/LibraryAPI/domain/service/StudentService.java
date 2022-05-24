package com.example.library.LibraryAPI.domain.service;

import com.example.library.LibraryAPI.persistence.StudentRepository;
import com.example.library.LibraryAPI.persistence.entity.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAll(){
        return studentRepository.getAll();
    }
}
