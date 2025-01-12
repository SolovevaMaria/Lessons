import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        1. Деление на ноль
//        Попросите пользователя ввести два числа (делимое и делитель). Если пользователь пытается выполнить деление на ноль, обработайте эту ситуацию, выведя сообщение об ошибке.
//         Scanner scanner = new Scanner(System.in);
//       double delimoe;
//       double delitel;
//       double result = 0;
//      try {
//          System.out.println("Введите делимое : ");
//          delimoe =  scanner.nextDouble();
//          System.out.println("Введите делитель : ");
//          delitel=  scanner.nextDouble();
//          if (delitel==0){
//              System.out.println("На ноль делить нельзя");
//          } else {
//          result= delimoe/delitel;
//              System.out.println(result);
//          }
//        }     catch (Exception ex) {
//
//          System.out.println(ex.getMessage());
//
//        }

//        2. Неверный формат числа
//        Запросите у пользователя ввод числа. Если пользователь ввёл строку, не являющуюся числом, выбросьте исключение и выведите сообщение об ошибке.
//        Scanner scanner = new Scanner(System.in);
//        double chislo;
//        try {
//            System.out.println("Введите число : ");
//            chislo =  scanner.nextDouble();
//        }     catch (Exception ex) {
//            System.out.println("Введенная строка не является числом");
//           scanner.next();
//        }
//        3. Обращение к элементу массива
//        Создайте массив из 5 элементов. Запросите у пользователя индекс и выведите элемент массива по этому индексу. Обработайте ситуацию, когда индекс выходит за границы массива.

//          int arr [] = new int [] {1, 2, 3, 4, 5};
//          int index;
//        Scanner scanner = new Scanner(System.in);
//        try {
//            System.out.println("Введите интекс числа : ");
//            index = scanner.nextInt();
//            System.out.println("Элемент массива с индексом : "  + index + " : " + arr[index]);
//        } catch (Exception ex) {
//            System.out.println("Введите другое число");
//            scanner.next();
//        }
//        4. Нахождение минимального числа
//        Запросите у пользователя несколько чисел (например, 5). Если одно из введённых значений не является числом, выбросьте исключение и выведите сообщение об ошибке.
//         Scanner scanner = new Scanner(System.in);
//         int chisla = 5;
//        int [] arr = new int [chisla];
//        for (int i = 0; i < chisla; i++) {
//          try {
//              System.out.println("Введите число : ");
//               arr [i] = scanner.nextInt();
//          } catch (Exception ex)  {
//              System.out.println("Введенная строка не является числом");
//              scanner.next();
//          }
//        }
//        5. Чтение строки с ограничением длины
//        Запросите у пользователя ввод строки. Если длина строки превышает 10 символов, выбросьте исключение с сообщением, что строка слишком длинная.
//         Scanner scanner = new Scanner(System.in);
//        String stroka = "";
//        try {
//            System.out.print("Введите строку: ");
//            stroka = scanner.nextLine();
//            if (stroka.length() > 10){
//                System.out.println("Строка слишком длинная");
//            }
//        }  catch (Exception ex){
//            System.out.println(ex.getMessage());
//
//       }
//        6. Поиск подстроки
//        Запросите у пользователя строку и символ. Если строка не содержит указанный символ, выбросьте исключение и выведите сообщение об ошибке.
//          Scanner scanner = new Scanner(System.in);
//          char a;
//          String stroka;
//          try {
//              System.out.print("Введите строку: ");
//              stroka = scanner.nextLine();
//              System.out.print("Введите символ: ");
//              a = scanner.next().charAt(0);
//              if (!stroka.contains(String.valueOf(a))) {
//                  System.out.println("Строка не содержит указанный символ ");
//              } else {
//                  System.out.println("Строка содержит символ - " + a);
//              }
//          }  catch(Exception ex) {
//              System.out.println(ex.getMessage());
//
//       }

//        7. Число в диапазоне
//        Попросите пользователя ввести число. Если введённое число меньше 1 или больше 100, выбросьте исключение с сообщением о некорректном диапазоне.
//         Scanner scanner = new Scanner(System.in);
//         double a;
//         try {
//             System.out.println("Введите число от 1 до 100 : ");
//             a =   scanner.nextDouble();
//             if (a > 100 || a < 1 ){
//                 System.out.println("Введите другое число, ваше число не входит в указанный диапозон");
//
//             }
//         }   catch(Exception ex) {
//              System.out.println(ex.getMessage());
//             scanner.next();
//      }

//        8. Парсинг массива
//        Создайте массив строк. Попробуйте преобразовать каждую строку в целое число. Если преобразование невозможно, выбросьте исключение и выведите сообщение о некорректном значении.
//          String arr [] = new String {"10", "20", "hello", "12","name" };
//        for (int i = 0; i < arr.length; i++) {
//          try {
//                int number = Integer.parseInt(arr);
//                System.out.println("Строка '" + arr+ "' преобразована в число: " + number);
//            } catch (NumberFormatException e) {
//                System.out.println("Ошибка: не удалось преобразовать строку '" + str + "' в число.");
//            }
//            }

//        9. Проверка делимости
//        Попросите пользователя ввести два числа. Если второе число не является делителем первого, выбросьте исключение с сообщением: "Число не делится без остатка".
//          Scanner scanner = new Scanner(System.in);
//       double number1;
//       double number2;
//       double result = 0;
//      try {
//          System.out.println("Введите делимое : ");
//          number1 =  scanner.nextDouble();
//          System.out.println("Введите делитель : ");
//          number2 =  scanner.nextDouble();
//          if (number1%number2 != 0){
//              System.out.println("Число не делится без остатка");
//          } else {
//          result= number1/number2;
//              System.out.println(result);
//          }
//        }     catch (Exception ex) {
//
//          System.out.println(ex.getMessage());
//
//        }
//        10. Индексы и значение
//        Создайте массив из 10 элементов. Попросите пользователя ввести индекс и значение для записи в массив. Обработайте ситуации, когда индекс выходит за пределы массива или значение некорректно.
//        int arr [] = new int [10];
//        int index;
//        int znachenie;
//        Scanner scanner = new Scanner(System.in);
//        try {
//            System.out.println("Введите индекс : ");
//            index = scanner.nextInt();
//
//            if (index < 0 || index >= arr.length) {
//                System.out.println("Индекс выходит за пределы длинны массива");
//            }
//            System.out.println("ведите значение для указанного индекса : ");
//            znachenie = scanner.nextInt();
//
//
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
//



        
        }

    }
