package com.brandonporter.sprintfinal.services;

import com.brandonporter.sprintfinal.models.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();

    Author findAuthorById(long id);
}
