package com.brandonporter.sprintfinal.repository;

import com.brandonporter.sprintfinal.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
}
