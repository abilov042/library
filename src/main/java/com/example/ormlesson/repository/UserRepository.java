package com.example.ormlesson.repository;

import com.example.ormlesson.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    Page<User> findByFirstName(String username, Pageable pageable);
}
