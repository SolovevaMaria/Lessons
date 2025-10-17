package com.example.workdb.controllers;

import com.example.workdb.books.BookEntity;

import com.example.workdb.books.BookRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;


import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    @Operation(summary = "Получить список книг")
    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    @PostMapping
    @Operation(summary = "Добавить новую книгу")
    public BookEntity addBook(@RequestBody @Valid BookEntity book) {
        return bookRepository.save(book);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить книгу")
    public BookEntity updateBook(@PathVariable Long id, @RequestBody @Valid BookEntity book) {
        Optional<BookEntity> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            BookEntity existingBook = optionalBook.get();
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthorId(book.getAuthorId());
            existingBook.setPublicationDate(book.getPublicationDate());
            return bookRepository.save(existingBook);
        }
        throw new RuntimeException("Книга с id " + id + " не найдена");
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить книгу")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

