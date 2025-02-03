package com.example.ormlesson.controller;

import com.example.ormlesson.entity.User;
import com.example.ormlesson.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;


    @PostMapping
    public void create(@RequestBody @Valid User user) {
        this.userService.save(user);
    }

    @GetMapping
    public Page<User> findAll(@RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "10") int size) {
        return this.userService.findAll(page, size);
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable int id) {
        return this.userService.findById(id);
    }

    @GetMapping("/calculate")
    public int calculate(int a, int b){
        return this.userService.calculate(a, b);
    }
}