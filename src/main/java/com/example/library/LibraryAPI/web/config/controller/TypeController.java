package com.example.library.LibraryAPI.web.config.controller;

import com.example.library.LibraryAPI.domain.service.*;
import com.example.library.LibraryAPI.persistence.entity.*;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/all")
    @ApiOperation("Gets all types")
    public ResponseEntity<List<Type>> getAll() {
        return new ResponseEntity<>(typeService.getAll(), HttpStatus.OK);
    }
}
