package com.example.workdb.services;

import com.example.workdb.DTOs.BookDTO;
import com.example.workdb.DTOs.CreateBookRequest;
import com.example.workdb.entities.Book; // Правильный импорт!
import com.example.workdb.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    private BookDTO convertToDTO(Book book) {
        return new BookDTO(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.getPublicationYear(),
                book.getGenre(),
                book.getPublisher(),
                book.getDescription(),
                book.getPageCount(),
                book.getCreatedAt(),
                book.getUpdatedAt()
        );
    }

    private Book convertToEntity(CreateBookRequest bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setIsbn(bookDTO.getIsbn());
        book.setPublicationYear(bookDTO.getPublicationYear());
        book.setGenre(bookDTO.getGenre());
        book.setPublisher(bookDTO.getPublisher());
        book.setDescription(bookDTO.getDescription());
        book.setPageCount(bookDTO.getPageCount());
        return book;
    }

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<BookDTO> getBookById(Long id) {
        return bookRepository.findById(id)
                .map(this::convertToDTO);
    }

    public BookDTO createBook(CreateBookRequest createBookRequest) {
        if (createBookRequest.getIsbn() != null &&
                bookRepository.existsByIsbn(createBookRequest.getIsbn())) {
            throw new RuntimeException("Книга с ISBN " + createBookRequest.getIsbn() + " уже существует");
        }

        Book book = convertToEntity(createBookRequest);
        Book savedBook = bookRepository.save(book);
        return convertToDTO(savedBook);
    }

    public BookDTO updateBook(Long id, CreateBookRequest updateRequest) {
        Optional<Book> existingBook = bookRepository.findById(id);
        if (existingBook.isEmpty()) {
            throw new RuntimeException("Книга с ID " + id + " не найдена");
        }

        Book book = existingBook.get();
        book.setTitle(updateRequest.getTitle());
        book.setAuthor(updateRequest.getAuthor());
        book.setIsbn(updateRequest.getIsbn());
        book.setPublicationYear(updateRequest.getPublicationYear());
        book.setGenre(updateRequest.getGenre());
        book.setPublisher(updateRequest.getPublisher());
        book.setDescription(updateRequest.getDescription());
        book.setPageCount(updateRequest.getPageCount());

        Book updatedBook = bookRepository.save(book);
        return convertToDTO(updatedBook);
    }

    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Книга с ID " + id + " не найдена");
        }
        bookRepository.deleteById(id);
    }

    public List<BookDTO> searchByAuthor(String author) {
        return bookRepository.findByAuthorContainingIgnoreCase(author)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<BookDTO> searchByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<BookDTO> searchByGenre(String genre) {
        return bookRepository.findByGenreContainingIgnoreCase(genre)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<String> getDistinctGenres() {
        return bookRepository.findDistinctGenres();
    }

    public List<String> getDistinctAuthors() {
        return bookRepository.findDistinctAuthors();
    }

    public List<BookDTO> getBooksByYear(Integer year) {
        return bookRepository.findByPublicationYear(year)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<BookDTO> getBooksByYearRange(Integer startYear, Integer endYear) {
        return bookRepository.findByPublicationYearBetween(startYear, endYear)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}