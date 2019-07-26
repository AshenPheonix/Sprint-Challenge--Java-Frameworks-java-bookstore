package com.brandonporter.sprintfinal.repository;

import com.brandonporter.sprintfinal.models.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
