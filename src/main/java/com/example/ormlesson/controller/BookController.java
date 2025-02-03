package com.example.ormlesson.controller;

import com.example.ormlesson.entity.Book;
import com.example.ormlesson.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public void save(@RequestBody @Valid Book book) {
        bookService.save(book);
    }

    @GetMapping
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable int id) {
        return this.bookService.findById(id);
    }
}
