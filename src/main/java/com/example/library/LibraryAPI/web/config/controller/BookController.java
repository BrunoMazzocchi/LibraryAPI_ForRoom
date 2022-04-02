package com.example.library.LibraryAPI.web.config.controller;

import com.example.library.LibraryAPI.domain.service.*;
import com.example.library.LibraryAPI.persistence.entity.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAll(){
        return new ResponseEntity<>(bookService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book>getBook(@PathVariable("id") int bookId){
        return bookService.getBook(bookId)
                .map(book -> new ResponseEntity<>(book, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Book> save(@RequestBody Book book){
        return new ResponseEntity<>(bookService.save(book), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int bookId){
        if(bookService.delete(bookId)) {
            return new ResponseEntity(HttpStatus.OK);
        } else  {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}