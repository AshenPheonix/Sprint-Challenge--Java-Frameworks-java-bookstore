package com.brandonporter.sprintfinal.repository;

import com.brandonporter.sprintfinal.models.Book;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BookRepository extends  PagingAndSortingRepository<Book,Long>{
    List<Book> findAll();
}
