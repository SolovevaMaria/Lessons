package com.example.workdb.repositories;

import com.example.workdb.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByIsbn(String isbn);

    List<Book> findByAuthorContainingIgnoreCase(String author);

    List<Book> findByTitleContainingIgnoreCase(String title);

    List<Book> findByGenreContainingIgnoreCase(String genre);

    List<Book> findByPublicationYear(Integer publicationYear);

    @Query("SELECT b FROM Book b WHERE b.publicationYear BETWEEN :startYear AND :endYear")
    List<Book> findByPublicationYearBetween(@Param("startYear") Integer startYear,
                                            @Param("endYear") Integer endYear);

    boolean existsByIsbn(String isbn);

    @Query("SELECT DISTINCT b.genre FROM Book b WHERE b.genre IS NOT NULL")
    List<String> findDistinctGenres();

    @Query("SELECT DISTINCT b.author FROM Book b WHERE b.author IS NOT NULL")
    List<String> findDistinctAuthors();
}