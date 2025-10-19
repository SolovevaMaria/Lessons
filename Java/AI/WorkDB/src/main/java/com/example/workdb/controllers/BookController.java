package com.example.workdb.controllers;

import com.example.workdb.DTOs.BookDTO;
import com.example.workdb.DTOs.CreateBookRequest;
import com.example.workdb.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @RestController
    @RequestMapping("/api/books")
    @CrossOrigin(origins = "*")
    public class BookApiController {

        @GetMapping
        public ResponseEntity<List<BookDTO>> getAllBooks() {
            try {
                List<BookDTO> books = bookService.getAllBooks();
                return ResponseEntity.ok(books);
            } catch (Exception e) {
                return ResponseEntity.internalServerError().build();
            }
        }

        @GetMapping("/{id}")
        public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
            try {
                return bookService.getBookById(id)
                        .map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
            } catch (Exception e) {
                return ResponseEntity.internalServerError().build();
            }
        }

        @PostMapping
        public ResponseEntity<?> createBook(@RequestBody CreateBookRequest createBookRequest) {
            try {
                BookDTO createdBook = bookService.createBook(createBookRequest);
                return ResponseEntity.ok(createdBook);
            } catch (RuntimeException e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            } catch (Exception e) {
                return ResponseEntity.internalServerError().body("Ошибка при создании книги");
            }
        }

        @PutMapping("/{id}")
        public ResponseEntity<?> updateBook(@PathVariable Long id, @RequestBody CreateBookRequest updateRequest) {
            try {
                BookDTO updatedBook = bookService.updateBook(id, updateRequest);
                return ResponseEntity.ok(updatedBook);
            } catch (RuntimeException e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            } catch (Exception e) {
                return ResponseEntity.internalServerError().body("Ошибка при обновлении книги");
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteBook(@PathVariable Long id) {
            try {
                bookService.deleteBook(id);
                return ResponseEntity.ok().body("Книга успешно удалена");
            } catch (RuntimeException e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            } catch (Exception e) {
                return ResponseEntity.internalServerError().body("Ошибка при удалении книги");
            }
        }

        @GetMapping("/search/author")
        public ResponseEntity<List<BookDTO>> searchByAuthor(@RequestParam String author) {
            try {
                List<BookDTO> books = bookService.searchByAuthor(author);
                return ResponseEntity.ok(books);
            } catch (Exception e) {
                return ResponseEntity.internalServerError().build();
            }
        }

        @GetMapping("/search/title")
        public ResponseEntity<List<BookDTO>> searchByTitle(@RequestParam String title) {
            try {
                List<BookDTO> books = bookService.searchByTitle(title);
                return ResponseEntity.ok(books);
            } catch (Exception e) {
                return ResponseEntity.internalServerError().build();
            }
        }

        @GetMapping("/search/genre")
        public ResponseEntity<List<BookDTO>> searchByGenre(@RequestParam String genre) {
            try {
                List<BookDTO> books = bookService.searchByGenre(genre);
                return ResponseEntity.ok(books);
            } catch (Exception e) {
                return ResponseEntity.internalServerError().build();
            }
        }

        @GetMapping("/genres")
        public ResponseEntity<List<String>> getGenres() {
            try {
                List<String> genres = bookService.getDistinctGenres();
                return ResponseEntity.ok(genres);
            } catch (Exception e) {
                return ResponseEntity.internalServerError().build();
            }
        }

        @GetMapping("/authors")
        public ResponseEntity<List<String>> getAuthors() {
            try {
                List<String> authors = bookService.getDistinctAuthors();
                return ResponseEntity.ok(authors);
            } catch (Exception e) {
                return ResponseEntity.internalServerError().build();
            }
        }
    }
}