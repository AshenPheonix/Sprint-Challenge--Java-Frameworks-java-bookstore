package com.brandonporter.sprintfinal.controllers;

import com.brandonporter.sprintfinal.models.Author;
import com.brandonporter.sprintfinal.models.Book;
import com.brandonporter.sprintfinal.services.AuthorService;
import com.brandonporter.sprintfinal.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/data")
public class DataController {
    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @PreAuthorize("hasAuthority('ROLE_DATA')")
    @PutMapping(value = "/books/{id}",
                produces = {"application/json"},
                consumes = {"application/json"})
    public ResponseEntity<?> updateBook(@PathVariable long id, @RequestBody @Valid Book book){
        Book res = bookService.update(book,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/books/{bookid}/authors/{authorid}")
    public ResponseEntity<?> updateAuthor(@PathVariable long bookid, @PathVariable long authorid){
        Author author=authorService.findAuthorById(authorid);
        Book book = bookService.findBookById(bookid);

        book.getAuthors().add(author);
        book=bookService.save(book);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable long id){
        bookService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
