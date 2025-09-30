package com.example.workdb.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.awt.print.Book;

import static java.util.Collections.reverseOrder;
import static org.apache.commons.lang3.ArrayUtils.isSorted;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


//задание 1

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private Book testBook;

    @BeforeEach
    void setUp() {

        testBook = new Book();
        testBook.setTitle("Война и мир");
        testBook.setAuthor("Лев Толстой");
        testBook.setIsbn("978-5-00123-456-7");
        testBook.setPublishedYear(1869);
        testBook.setPrice(399.99);
    }

    @Test
    void testCreateBook() throws Exception {
        mockMvc.perform(
                        post("/api/books")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(testBook))
                )
                .andExpect(status().isCreated())
                .andExpect(jsonPath("title").value(testBook.getTitle()))
                .andExpect(jsonPath("author").value(testBook.getAuthor()));
    }

    @Test
    void testGetExistingBook() throws Exception {
        ResultActions result = mockMvc.perform(
                post("/api/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testBook))
        );

        long bookId = Long.parseLong(result.andReturn()
                .getResponse()
                .getHeader("Location")
                .split("/")[2]);

        mockMvc.perform(
                        get("/api/books/{id}", bookId)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("title").value(testBook.getTitle()));
    }

    @Test
    void testGetNonExistingBook() throws Exception {
        mockMvc.perform(
                        get("/api/books/{id}", 999999999L)
                )
                .andExpect(status().isNotFound());
    }


    // задание 2
    @Test
    void testCreateBookWithEmptyTitle() throws Exception {
        Book invalidBook = new Book();
        invalidBook.setTitle("");
        invalidBook.setAuthor("Автор");
        invalidBook.setIsbn("978-5-00123-456-7");
        invalidBook.setPublishedYear(2023);
        invalidBook.setPrice(100.0);

        mockMvc.perform(
                        post("/api/books")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(invalidBook))
                )
                .andExpect(status().isBadRequest());
    }

    @Test
    void testCreateBookWithInvalidISBN() throws Exception {
        Book invalidBook = new Book();
        invalidBook.setTitle("Книга");
        invalidBook.setAuthor("Автор");
        invalidBook.setIsbn("123-45-6789"); // Невалидный формат
        invalidBook.setPublishedYear(2023);
        invalidBook.setPrice(100.0);

        mockMvc.perform(
                        post("/api/books")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(invalidBook))
                )
                .andExpect(status().isBadRequest());
    }

    @Test
    void testCreateBookWithNegativePrice() throws Exception {
        Book invalidBook = new Book();
        invalidBook.setTitle("Книга");
        invalidBook.setAuthor("Автор");
        invalidBook.setIsbn("978-5-00123-456-7");
        invalidBook.setPublishedYear(2023);
        invalidBook.setPrice(-10.0);

        mockMvc.perform(
                        post("/api/books")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(invalidBook))
                )
                .andExpect(status().isBadRequest());
    }

    @Test
    void testCreateBookWithFuturePublicationYear() throws Exception {
        Book invalidBook = new Book();
        invalidBook.setTitle("Книга");
        invalidBook.setAuthor("Автор");
        invalidBook.setIsbn("978-5-00123-456-7");
        invalidBook.setPublishedYear(2100); // Год в будущем
        invalidBook.setPrice(100.0);

        mockMvc.perform(
                        post("/api/books")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(invalidBook))
                )
                .andExpect(status().isBadRequest());
    }

    //задание 3
    @Test
    void testUpdateExistingBook() throws Exception {

        Book updatedBook = new Book();
        updatedBook.setTitle("Анна Каренина");
        updatedBook.setAuthor("Лев Толстой");
        updatedBook.setIsbn("978-5-00123-456-8");
        updatedBook.setPublishedYear(1873);
        updatedBook.setPrice(499.99);

        mockMvc.perform(
                        put("/api/books/{id}", bookId)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(updatedBook))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("title").value("Анна Каренина"))
                .andExpect(jsonPath("price").value(499.99));
    }

    @Test
    void testUpdateNonExistingBook() throws Exception {
        mockMvc.perform(
                        put("/api/books/{id}", 999999999L)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(testBook))
                )
                .andExpect(status().isNotFound());
    }

    @Test
    void testPartialUpdateBook() throws Exception {

        String patchContent = "{\"price\": 299.99}";

        mockMvc.perform(
                        patch("/api/books/{id}", bookId)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(patchContent)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("title").value(testBook.getTitle()))
                .andExpect(jsonPath("price").value(299.99));
    }

    @Test
    void testUpdateWithInvalidData() throws Exception {
        Book invalidBook = new Book();
        invalidBook.setTitle(""); // Пустое название
        invalidBook.setPrice(-100.0); // Отрицательная цена

        mockMvc.perform(
                        put("/api/books/{id}", bookId)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(invalidBook))
                )
                .andExpect(status().isBadRequest());
    }

    //задание 4
    @Test
    void testSearchByTitle() throws Exception {
        String searchTitle = testBooks.get(0).getTitle().substring(0, 5);

        mockMvc.perform(
                        get("/api/books?title={title}", searchTitle)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].title").isArray())
                .andExpect(jsonPath("$[*].title", hasItem(containing(searchTitle))));
    }

    @Test
    void testSearchByAuthor() throws Exception {
        String author = testBooks.get(0).getAuthor();

        mockMvc.perform(
                        get("/api/books?author={author}", author)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].author", hasItem(author)));
    }

    @Test
    void testFilterByPriceRange() throws Exception {
        double minPrice = 200.0;
        double maxPrice = 500.0;

        mockMvc.perform(
                        get("/api/books?minPrice={minPrice}&maxPrice={maxPrice}", minPrice, maxPrice)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].price", everyItem(allOf(
                        greaterThanOrEqualTo(minPrice),
                        lessThanOrEqualTo(maxPrice)
                )));
    }

    @Test
    void testFilterByYear() throws Exception {
        int year = 2000;

        mockMvc.perform(
                        get("/api/books?year={year}", year)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].publishedYear", hasItem(year)));
    }
    @Test
    void testCombinedSearch() throws Exception {
        String author = testBooks.get(0).getAuthor();
        double minPrice = 100.0;
        int year = 2000;

        String query = String.format(
                "?author=%s&minPrice=%f&year=%d",
                author,
                minPrice,
                year
        );

        mockMvc.perform(
                        get("/api/books" + query)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].author", hasItem(author)))
                .andExpect(jsonPath("$[*].price", everyItem(greaterThanOrEqualTo(minPrice))))
                .andExpect(jsonPath("$[*].publishedYear", hasItem(year)))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    //задание 5
    @Test
    void testFirstPage() throws Exception {
        mockMvc.perform(
                        get("/api/books?page=0&size=10")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("content").isArray())
                .andExpect(jsonPath("content", hasSize(10)))
                .andExpect(jsonPath("number").value(0))
                .andExpect(jsonPath("size").value(10));
    }

    @Test
    void testSpecificPage() throws Exception {
        mockMvc.perform(
                        get("/api/books?page=5&size=10")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("content").isArray())
                .andExpect(jsonPath("content", hasSize(10)))
                .andExpect(jsonPath("number").value(5))
                .andExpect(jsonPath("size").value(10));
    }

    @Test
    void testSortByPriceAsc() throws Exception {
        mockMvc.perform(
                        get("/api/books?sort=price,asc")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("content[*].price", isSorted()));
    }

    @Test
    void testSortByPriceDesc() throws Exception {
        mockMvc.perform(
                        get("/api/books?sort=price,desc")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("content[*].price", isSorted(reverseOrder())));
    }

    @Test
    void testSortByYear() throws Exception {
        mockMvc.perform(
                        get("/api/books?sort=publishedYear,asc")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("content[*].publishedYear", isSorted()));
    }

    @Test
    void testEmptyPage() throws Exception {
        mockMvc.perform(
                        get("/api/books?page=100&size=10")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("content").isEmpty())
                .andExpect(jsonPath("number").value(100))
                .andExpect(jsonPath("size").value(10))
                .andExpect(jsonPath("totalElements").value(1000));
    }
}

