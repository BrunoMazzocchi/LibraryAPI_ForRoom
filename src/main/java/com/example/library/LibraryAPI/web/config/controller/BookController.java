package com.example.library.LibraryAPI.web.config.controller;

import com.example.library.LibraryAPI.domain.service.*;
import com.example.library.LibraryAPI.persistence.entity.*;
import io.swagger.annotations.*;
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
    @ApiOperation("Gets all books")
    public ResponseEntity<List<Book>> getAll() {
        return new ResponseEntity<>(bookService.getAll(), HttpStatus.OK);
    }


    @ApiOperation("Search a specific book with an ID")
    @GetMapping("/{id}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not found")
    })
    public ResponseEntity<Book> getBook(@ApiParam(value = "Book's ID", required = true, example = "1") @PathVariable("id") int bookId) {
        return bookService.getBook(bookId)
                .map(book -> new ResponseEntity<>(book, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @ApiOperation("Search a specific list of books or book with a name/or part of it")
    @GetMapping("/name/{bookName}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not found")
    })
    public ResponseEntity<List<Book>> findByNameContaining(@ApiParam(value = "Book's name", required = true, example = "The Legend Of Zelda") @PathVariable("bookName") String bookName) {
        return bookService.findByNameContaining(bookName)
                .map(book -> new ResponseEntity<>(book, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @ApiOperation("Search a book with the author's name or surname")
    @GetMapping("/author/{nameOrsurname}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not found")
    })
    public ResponseEntity<List<Book>> findByAuthorOrSurname(@ApiParam(value = "Author's name/surname (String)", required = true, example = "William Dean or Howells")
                                                            @PathVariable("nameOrsurname") String author, String surname) {
        return bookService.findByAuthorOrSurname(author, surname).map(
                books -> new ResponseEntity<>(books, HttpStatus.OK)

        ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @ApiOperation("Saves a book with the information required")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not found")
    })
    @PostMapping("/save")
    public ResponseEntity<Book> save(@ApiParam(value = "The book entity", required = true, example = "" +
            "{\n" +
            "  \"name\": INTRODUCE HERE,\n" +
            "  \"pageCount\": INTRODUCE HERE {\n" +
            "    \"point\": INTRODUCE HERE,\n" +
            "    \"authorId\": INTRODUCE HERE\"string\",\n" +
            "    \"typeId\": INTRODUCE HERE\n" +
            "  }" +
            "") @RequestBody Book book) {
        return new ResponseEntity<>(bookService.save(book), HttpStatus.CREATED);
    }

    @ApiOperation("Deletes a product with the information required")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not found")
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@ApiParam(value = "The book's ID") @PathVariable("id") int bookId) {
        if (bookService.delete(bookId)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
