package com.example.workdb.schedulers;

import com.example.workdb.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BookScheduler {

    private static final Logger logger = LoggerFactory.getLogger(BookScheduler.class);

    @Autowired
    private BookService bookService;

    @Scheduled(fixedRate = 24 * 60 * 60 * 1000) // 24 часа
    public void logBookStatistics() {
        try {
            long bookCount = bookService.getAllBooks().size();
            long genreCount = bookService.getDistinctGenres().size();
            long authorCount = bookService.getDistinctAuthors().size();

            logger.info("Статистика библиотеки: Всего книг - {}, Жанров - {}, Авторов - {}",
                    bookCount, genreCount, authorCount);
        } catch (Exception e) {
            logger.error("Ошибка при получении статистики книг", e);
        }
    }

    @Scheduled(cron = "0 0 6 * * ?")
    public void dailyDataCheck() {
        logger.info("Ежедневная проверка данных книг выполнена");
    }
}