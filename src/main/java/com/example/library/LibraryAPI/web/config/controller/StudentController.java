package com.example.library.LibraryAPI.web.config.controller;

import com.example.library.LibraryAPI.domain.service.*;
import com.example.library.LibraryAPI.persistence.entity.*;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    @ApiOperation("Gets all students")
    public ResponseEntity<List<Student>> getAll() {
        return new ResponseEntity<>(studentService.getAll(), HttpStatus.OK);
    }
}
