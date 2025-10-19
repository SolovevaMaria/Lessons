package com.example.workdb.utils;

import com.example.workdb.DTOs.CreateBookRequest;
import org.springframework.stereotype.Component;

@Component
public class BookValidator {

    public boolean validateBookRequest(CreateBookRequest request) {
        if (request.getTitle() == null || request.getTitle().trim().isEmpty()) {
            return false;
        }

        if (request.getAuthor() == null || request.getAuthor().trim().isEmpty()) {
            return false;
        }

        if (request.getPublicationYear() != null) {
            int currentYear = java.time.Year.now().getValue();
            if (request.getPublicationYear() < 1000 || request.getPublicationYear() > currentYear + 5) {
                return false;
            }
        }

        if (request.getPageCount() != null && request.getPageCount() <= 0) {
            return false;
        }

        return true;
    }

    public boolean validateISBN(String isbn) {
        if (isbn == null || isbn.trim().isEmpty()) {
            return true; // ISBN не обязателен
        }

        String cleanIsbn = isbn.replace("-", "").replace(" ", "");
        return cleanIsbn.matches("^(?:\\d{9}[\\dX]|\\d{13})$");
    }
}
