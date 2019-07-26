package com.brandonporter.sprintfinal.controllers;

import com.brandonporter.sprintfinal.models.Author;
import com.brandonporter.sprintfinal.models.Book;
import com.brandonporter.sprintfinal.services.AuthorService;
import com.brandonporter.sprintfinal.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RootController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @GetMapping(value = "/books",
                produces={"application/json"})
    public ResponseEntity<?> allBooks(){
        List<Book> res=bookService.findAll();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping(value = "/authors",
                produces = {"application/json"})
    public ResponseEntity<?> allAuthors(){
        List<Author> res=authorService.findAll();
        return new ResponseEntity<>(res,HttpStatus.OK);
    }
}
