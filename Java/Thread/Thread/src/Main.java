//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Random;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        int COUNT_TO = 10000;
        for (int i = 0; i < COUNT_TO; i++) {
            //System.out.print(i + " ");
        }
    }
}
class StarRunnable implements Runnable {
    @Override
    public void run() {
        int STAR_COUNT = 5000;
        for (int i = 0; i < STAR_COUNT; i++) {
            //System.out.print("*");
        }
    }
}

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//Задание 1: Сравнение последовательного и параллельного выполнения
//Создайте программу, которая демонстрирует разницу между последовательным и параллельным выполнением двух задач:
//Первая задача: подсчет и вывод чисел от 0 до 10000
//Вторая задача: вывод 5000 символов "*"
//Измерьте и выведите время выполнения для обоих подходов (последовательного и с использованием потоков).
        System.out.println("Start");
        long startTimeSequential = System.currentTimeMillis();

        MyRunnable countTask = new MyRunnable();
        countTask.run();

        StarRunnable starTask = new StarRunnable();
        starTask.run();

        long endTimeSequential = System.currentTimeMillis();
        long durationSequential = endTimeSequential - startTimeSequential;
        System.out.println("\nTime: " + durationSequential + " ms");

        long startTimeParallel = System.currentTimeMillis();

        Thread countThread = new Thread(new MyRunnable());
        Thread starThread = new Thread(new StarRunnable());

        countThread.start();
        starThread.start();
        long endTimeParallel = System.currentTimeMillis();
        long durationParallel = endTimeParallel - startTimeParallel;
        System.out.println("\nTime: " + durationParallel + " ms");

//Задание 2: Использование разных способов создания потоков
//Напишите программу, которая выполняет одну и ту же задачу (например, вывод чисел от 1 до 100) тремя разными способами:
//Используя наследование от класса Thread (как MyThread в примере)
//Используя интерфейс Runnable (как MyRunnable в примере)
//Используя лямбда-выражение
//Для каждого способа выведите имя потока и его приоритет.
        class MyThread extends Thread {
            @Override
            public void run() {
                int count = 100;
                System.out.println("Thread  " + getName() + ", Priority = " + getPriority());
                for (int i = 1; i <=  count; i++) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
        MyThread thread1 = new MyThread();
        thread1.start();

        class MyRunnable implements Runnable {
            @Override
            public void run() {
                int  count = 100;
                System.out.println("Thread " + Thread.currentThread().getName() + ", Priority = " + Thread.currentThread().getPriority());
                for (int i = 1; i <=  count; i++) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
        Thread thread2 = new Thread(new MyRunnable());
        thread2.start();

        Thread thread3 = new Thread(() -> {
            int  count = 100;
            System.out.println("Thread  " + Thread.currentThread().getName() + ", Priority = " + Thread.currentThread().getPriority());
            for (int i = 1; i <=  count; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        });
        thread3.start();


//Задание 3: Взаимодействие между потоками
//Создайте два потока:
//Первый поток генерирует и печатает случайные числа (от 1 до 100) каждую секунду
//Второй поток ожидает, когда будет сгенерировано число больше 90, и останавливает оба потока
//Используйте методы join(), sleep() и interrupt() для управления потоками,
// а также продемонстрируйте различные состояния жизненного цикла потока (NEW, RUNNABLE, TERMINATED и т.д.).
        Random random = new Random();
        Thread generatorThread = null;
        Thread stopperThread = null;

        generatorThread = new Thread(() -> {
            System.out.println("Состояние потока : " + Thread.currentThread().getState());
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    int randomNumber = random.nextInt(100) + 1;
                    System.out.println("Сгенерировано : " + randomNumber);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                System.out.println("поток прерван");
            } finally {
                System.out.println("Состояние потока : " + Thread.currentThread().getState());
            }
        });

        final Thread generatorThreadRef = generatorThread;
        stopperThread = new Thread(() -> {
            System.out.println("Состояние потока : " + Thread.currentThread().getState());
            try {
                Thread.sleep(100);
                while (!Thread.currentThread().isInterrupted()) {

                    if (System.currentTimeMillis() % 5 > 0) {
                        Thread.sleep(100);
                        continue;
                    }

                    System.out.println("Number > 90 условие выполнено ");
                    generatorThreadRef.interrupt();
                    break;
                }
            } catch (InterruptedException e) {
                System.out.println("поток прерван");
            } finally {
                System.out.println("Состояние потока : " + Thread.currentThread().getState());
            }
        });

        System.out.println("Состояние потока : " + generatorThread.getState());
        System.out.println("Состояние потока : " + stopperThread.getState());

        generatorThread.start();
        stopperThread.start();

        System.out.println("Состояние потока : " + generatorThread.getState());
        System.out.println("Состояние потока : " + stopperThread.getState());
        stopperThread.join();
        System.out.println("Программа завершена.");

    }
}
