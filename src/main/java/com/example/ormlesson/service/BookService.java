package com.example.ormlesson.service;

import com.example.ormlesson.entity.Book;
import com.example.ormlesson.exceptions.BaseException;
import com.example.ormlesson.model.StatusCode;
import com.example.ormlesson.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public void save(Book book) {
        bookRepository.save(book);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }
    public Book findById(int id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BaseException(HttpStatus.NOT_FOUND, StatusCode.BOOK_NOT_FOUND));
    }
}
