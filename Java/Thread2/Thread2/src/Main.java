import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int wordCount = 0;
    static int numberCount = 0;
    static int sentenceCount = 0;
    static String text = "";
    public static void main(String[] args) {
        //Читаем файл и анализируем символы через ASCII
        //Нужно посчитать:
        // Количество слов
        // Количество чисел
        // Количество предложений
        // Количество гласных
        //Количество согласных
        // Количество знаков препинания (точка, запятая, !, ?, ;, : )
        //Время выполнения
        //
        //Использовать потоки
        String filepath = "test.txt";

        File file = new File(filepath);
        if (!file.exists()) {

            BufferedWriter writer = null;
            try {
                writer.write(" 123 и 456.  знаки препинания: , ! ?. ");
            } catch (IOException e) {
                System.err.println("Ошибка при создании файла test.txt: " + e.getMessage());
                return;
            }
        }

        LocalDateTime start =  LocalDateTime.now();

        final int[] glCount = {0};
        final int[] soglCount = {0};
        final int[] punctuationCount = {0};

        Thread thread = new Thread(() -> {
            Pattern sentencePattern = Pattern.compile("[.!?]+");
            Pattern numberPattern = Pattern.compile("\\d+");
            String punctuation = ".,!?;:";
            String glasn = "aeiouAEIOUаеёиоуыэюяАЕЁИОУЫЭЮЯ";
            String soglasn = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZбвгджзйклмнпрстфхцчшщъьБВГДЖЗЙКЛМНПРСТФХЦЧШЩЪЬ";

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filepath), StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {

                    String[] words = line.split("\\s+");
                    synchronized (Main.class) {
                        wordCount += words.length;
                    }
                    for (String word : words) {
                        Matcher matcher = numberPattern.matcher(word);
                        if (matcher.matches()) {
                            synchronized (Main.class) {
                                numberCount++;
                            }
                        }
                    }
                    Matcher sentenceMatcher = sentencePattern.matcher(line);
                    synchronized (Main.class) {
                        sentenceCount += sentenceMatcher.results().count();
                    }

                    for (int i = 0; i < line.length(); i++) {
                        char c = line.charAt(i);
                        if (glasn.indexOf(c) != -1) {
                            synchronized (glCount) {
                                glCount[0]++;
                            }
                        } else if (soglasn.indexOf(c) != -1) {
                            synchronized (soglCount) {
                                soglCount[0]++;
                            }
                        } else if (punctuation.indexOf(c) != -1) {
                            synchronized (punctuationCount) {
                                punctuationCount[0]++;
                            }
                        }
                    }
                }
            } catch (IOException e) {
                System.err.println( e.getMessage());
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            System.err.println( e.getMessage());
            Thread.currentThread().interrupt();
            return;
        }
        LocalDateTime end =  LocalDateTime.now();
        Duration executionTime = Duration.between(start, end);

        System.out.println("Результаты:");
        System.out.println("Количество слов: " + wordCount);
        System.out.println("Количество чисел: " + numberCount);
        System.out.println("Количество предложений: " + sentenceCount);
        System.out.println("Количество гласных: " +  glCount[0]);
        System.out.println("Количество согласных: " + soglCount[0]);
        System.out.println("Количество знаков препинания: " + punctuationCount[0]);
        System.out.println("Время выполнения: " + executionTime.toMillis() + " мс");


    }
    }
