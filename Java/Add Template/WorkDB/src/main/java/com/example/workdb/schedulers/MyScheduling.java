//package com.example.workdb.schedulers;
//
//import com.example.workdb.entities.Author;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//
//import java.time.LocalDateTime;
//
//@Configuration
//@EnableScheduling
////@EnableAsync
//public class MyScheduling {
//
////    @Scheduled(fixedRate = 5 * 1000, initialDelay = 10 * 1000)
////    public void executeTask() throws InterruptedException {
////        System.out.println("Da  : "  + LocalDateTime.now() );
//
//    /// /        Thread.sleep(10000);
//    /// /        System.out.println("Time : "  + LocalDateTime.now() );
////
////    }
////    @Scheduled(fixedDelay = 5 * 1000, initialDelay = 60 * 1000)
////    public void executeTask() throws InterruptedException {
////        System.out.println("Time  : " + LocalDateTime.now());
////
////    }
//
//    int count = 1;
//
//    //       ---------------------------------------- секунда     (0-59)
//    //       |   ------------------------------------ минута      (0-59)
//    //       |   |   -------------------------------- час         (0-23)
//    //       |   |   |   ---------------------------- день месяцв (1-31)
//    //       |   |   |   |   ------------------------ месяцв      (1-12)
//    //       |   |   |   |   |   -------------------- день недели (0-7)
//    //       |   |   |   |   |   |
//    //       |   |   |   |   |   |
//    //       |   |   |   |   |   |
//    //       |   |   |   |   |   |
//
//    //       *   *   *   *   *   *
//
//    // *     -> любое значение
//    // ?     -> любое значение (дня месяца или недели)
//    // 1-2   -> диапазон значений (MON-FRI)
//    // 1,2,3 -> сисок значений (MON-FRI)
//    // /     -> */5  каждые 5 секунд
//    // L     -> последний день недели или месяца
//    // W     -> ближайший рабочий день
//    // #     -> ближайший рабочий день
//
//
////    @Scheduled(cron = "*/5 45 12 * * 6,7")
////    @Scheduled(cron = "* */10 * * * *")
////    @Scheduled(cron = "0 30 10 * * *")
////    @Scheduled(cron = "0 */15 * * * *")
////    @Scheduled(cron = "0 0 9 * * 1-5")
////    @Scheduled(cron = "* 10 9 * * MON")
////    @Scheduled(cron = "0 0 13 * * MON")
////    @Scheduled(cron = "0 0 9 15 * *")
////    @Scheduled(cron = "0 0 0 L * *")
////    @Scheduled(cron = "0 0 9-17 * * 1-5")
////    @Scheduled(cron = "${app.cron.expression}")
////    @Async
////    @Scheduled(fixedDelayString = "${app.fixed.rate}")
////    @Scheduled(fixedRateString = "${app.fixed.delay}")
////    @Scheduled(cron = "0 0 0 1 * *")
////    @Scheduled(cron = "0 30 9 1 * MON#3")
//    public void executeQrafik(){
//
//        System.out.println("Hello World : " + count++);
//    }
//
//}
