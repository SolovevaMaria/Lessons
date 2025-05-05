import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static com.sun.tools.classfile.Module_attribute.RequiresEntry.length;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Main {
    public static void main(String[] args) {
//1-2. Задания на if
//Задание 1: Классификация углов
//Напишите программу, которая запрашивает у пользователя угол в градусах (целое число от 0 до 360) и классифицирует его следующим образом:
//Острый угол (меньше 90 градусов)
//Прямой угол (ровно 90 градусов)
//Тупой угол (от 91 до 179 градусов)
//Развернутый угол (ровно 180 градусов)
//Невалидный угол (больше 180 градусов, но не более 360)
//Выведите соответствующее сообщение. Если введенное число выходит за пределы 0-360, программа должна выводить сообщение об ошибке.
//
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Введите угол в градусах (целое число от 0 до 360)  : ");
        int num = scanner1.nextInt();
        if (num < 0 || num>360 ){
            System.out.println("Вы ввели число, которое выходит за рамки. Введите другое число : ");
        }  else if(num>=0 && num<90){
            System.out.println("Острый угол ");
        } else if (num == 90){
            System.out.println("Прямой угол ");
        } else if (num>90 && num <180){
            System.out.println("Тупой угол ");
        } else if(num==180){
            System.out.println("Развернутый угол ");
        } else if (num > 180 && num<=360){
            System.out.println("Невалидный угол");
        }
        
//Задание 2: Оценка кредита
//Напишите программу, которая запрашивает у пользователя его возраст, ежемесячный доход и сумму кредита, который он хочет взять. Программа должна проверять следующие условия:
//Возраст должен быть от 18 до 65 лет.
//Доход должен быть не менее 50 000 рублей.
//Сумма кредита не должна превышать 10-кратный размер ежемесячного дохода.
//Если все условия выполняются, программа должна сообщить, что кредит одобрен. В противном случае программа должна объяснить причину отказа.
//
//        Scanner scanner2 = new Scanner(System.in);
//        System.out.println("Введите свой возраст : ");
//        int age = scanner2.nextInt();
//        System.out.println("Введите ежемесячный доход : ");
//        double haveMoney = scanner2.nextDouble();
//        System.out.println("Введите сумму кредита, которую хотите взять : ");
//        double creditMoney = scanner2.nextDouble();
//        boolean approved = true;
//        if (age <= 18 || age >= 65){
//            System.out.println("Кредит отклонен: Возраст должен быть от 18 до 65 лет");
//            approved = false;
//        }
//        if (haveMoney < 50000) {
//            System.out.println("Кредит отклонен: Ежемесячный доход должен быть не менее 50 000 рублей");
//            approved = false;
//        }
//        if (creditMoney > 10 *haveMoney) {
//            System.out.println("Кредит отклонен: Сумма кредита не должна превышать 10-кратный размер ежемесячного дохода");
//            approved = false;
//        }
//        if (approved) {
//            System.out.println("Кредит одобрен");
//        }

        
//3. Задание на switch
//Задание 3: Калькулятор простых операций
//Напишите консольную программу, которая запрашивает у пользователя два числа (целые) и оператор (+, -, *, /). Используйте switch для выполнения соответствующей арифметической операции.
//Обработайте следующие случаи:
//Деление на ноль (вывести сообщение об ошибке).
//Ввод некорректного оператора (вывести сообщение об ошибке).
//Корректный вывод результата.
//
//        Scanner scanner3 = new Scanner(System.in);
//        System.out.println("Введите первое целое число : ");
//        int num1 = scanner3.nextInt();
//        System.out.println("Введите второе целое число : ");
//        int num2 = scanner3.nextInt();
//        System.out.println("Введите оператор (+, -, *, /) : ");
//        char operator = scanner3.next().charAt(0);
//        double result = 0;
//        switch (operator) {
//            case '+':
//                result = num1 + num2;
//                break;
//            case '-':
//                result = num1 - num2;
//                break;
//            case '*':
//                result = num1*num2;
//                break;
//            case '/':
//                if(num1 == 0 || num2 == 0){
//                System.out.println("Ошибка! Делить на ноль нельзя!");
//            } else {
//                result = num1 / num2;
//                break;
//            }
//            default:
//                System.out.println("Ошибка! Некорректный оператор.");
//                return;
//        }
//        System.out.println("Результат: " + result);


//4-5. Задания на while
//Задание 4: Поиск числа Фибоначчи
//Пользователь вводит целое положительное число n. Программа должна вывести n-й элемент последовательности Фибоначчи, используя цикл while.
//(Последовательность: 0, 1, 1, 2, 3, 5, 8, 13, …)
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Введите целое положительное число n: ");
//        int n = scanner.nextInt();
//        if (n < 0) {
//            System.out.println("Число n должно быть неотрицательным");
//            return;
//        }
//        if (n <= 1) {
//            System.out.println("n-й элемент последовательности Фибоначчи = " + n);
//            return;
//        }
//        int a = 0;
//        int b = 1;
//        int i = 2;
//        int fibonacci = 0;
//        while (i <= n) {
//            fibonacci = a + b;
//            a = b;
//            b = fibonacci;
//            i++;
//        }
//        System.out.println("n-й элемент последовательности Фибоначчи = " + fibonacci);
//Задание 5: Проверка на палиндром
//Напишите программу, которая запрашивает у пользователя строку и проверяет, является ли она палиндромом (читается одинаково слева направо и справа налево). Используйте цикл while для проверки.
//
        String inputString = "Анна";
        inputString = inputString.toLowerCase().replaceAll("\\s+", "");

        int length = inputString.length();
        int i = 0;
        boolean isPalindrome = true;
        while (i < length / 2) {
            if (inputString.charAt(i) != inputString.charAt(length - 1 - i)) {
                isPalindrome = false;
                break;
            }
            i++;
        }
        if (isPalindrome) {
            System.out.println("Строка является палиндромом.");
        } else {
            System.out.println("Строка не является палиндромом.");
        }
        
//6-7. Задания на ООП
//Задание 6: Банковский счет
//Создайте класс BankAccount, который содержит:
//Поля: balance (баланс), owner (владелец счета).
//Метод deposit(double amount), который увеличивает баланс.
//Метод withdraw(double amount), который уменьшает баланс, но не позволяет уйти в минус.
//Конструктор, который принимает начальный баланс и имя владельца.
//Напишите программу, которая создает объект BankAccount, выполняет несколько операций пополнения и снятия и выводит итоговый баланс.
class BankAccount{
    double balance;
    String owner;

    public BankAccount(double initialBalance, String ownerName) {
        this.balance = initialBalance;
        this.owner = ownerName;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Увеличение на " + amount + " успешно. Текущий баланс: " + balance);
        } else {
            System.out.println("Сумма увеличения должна быть положительной");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Уменьшение на " + amount + " успешно.Текущий баланс: " + balance);
            } else {
                System.out.println("Недостаточно средств на счете");
            }
        } else {
            System.out.println("Сумма уменьшения должна быть положительной");
        }
    }
    public double getBalance() {
        return balance;
    }

    public String wladelec() {
        return owner;
    }
    public void info() {
        System.out.println("Владелец : " + owner);
        System.out.println("Баланс : " + balance);
    }

}

        BankAccount account = new BankAccount(10000, "Мария Соловьева");
        account.info();
        account.deposit(100);
        account.deposit(-100);
        account.withdraw(100);
        account.withdraw(100000);
        account.withdraw(-10);

//Задание 7: Управление заказами
//Создайте классы Product (товар) и Order (заказ).
//Product должен содержать поля: name (название), price (цена).
//Order должен содержать список товаров (List<Product>) и метод getTotalPrice(), который вычисляет общую стоимость заказа.
//Создайте несколько товаров, добавьте их в заказ, посчитайте итоговую сумму и выведите результат.
//
        class Product {
            String name;
            double price;

            public Product(String name, double price) {
                this.name = name;
                this.price = price;
            }

            public String getName() {
                return name;
            }

            public double getPrice() {
                return price;
            }
        }

    class  Order{
         List<Product> products;
        public Order() {
            this.products = new ArrayList<>(); 
        }

        public void addProduct(Product product) {
            this.products.add(product);
        }

        public double getTotalPrice() {
            double totalPrice = 0;
            for (Product product : products) {
                totalPrice += product.getPrice();
            }
            return totalPrice;
        }

        public void displayOrderDetails() {
            System.out.println("Состав заказа:");
            for (Product product : products) {
                System.out.println("- " + product.getName() + ", цена: " + product.getPrice());
            }
            System.out.println("Общая стоимость заказа : " + getTotalPrice());
        }

    }

        Product product1 = new Product("Телефон", 78000);
        Product product2 = new Product("Чехол на телефон", 1500);
        Order order = new Order();
        order.addProduct(product1);
        order.addProduct(product2);
        double total = order.getTotalPrice();
        System.out.println("Итоговая стоимость заказа : " + total);
        order.displayOrderDetails();

//8-9. Задания на Stream API
//Задание 8: Фильтрация чисел
//Дан список чисел List<Integer>. Используйте Stream API, чтобы:
//Оставить только четные числа.
//Упорядочить их по убыванию.
//Вывести их на экран.
//Пример входных данных: [5, 12, 7, 3, 14, 18, 6]
//
//Выход: [18, 14, 12, 6]

        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10);
        List<Integer> result1 = list.stream().filter(n->n%2==0).collect(Collectors.toList());
        System.out.println(result1);
        List<Integer> result2 = list.stream().sorted((y,x)->x.compareTo(y)).collect(Collectors.toList());
        System.out.println(result2);
        List<Integer> result3 = list.stream().toList();
        System.out.println(result3);

//Задание 9: Поиск самого длинного слова
//Дан список строк List<String>. Используйте Stream API, чтобы:
//Найти самое длинное слово.
//Если есть несколько слов одинаковой длины, выбрать первое.
//Вывести его на экран.
//Пример входных данных: ["кот", "слон", "крокодил", "тигр", "леопард"]
//
//Выход: "крокодил"
//
        List<String> list2 = List.of("кот", "слон", "крокодил", "тигр", "леопард", "гиппопотам");
        Optional<String> word = list2.stream().max((word1, word2) -> Integer.compare(word1.length(), word2.length()));

        if (word.isPresent()) {
            System.out.println(word.get());
        } else {
            System.out.println("Список пуст");
        }
    
//10. Задание на IO File
//Задание 10: Чтение и обработка данных из файла
//Напишите программу, которая:
//Читает файл input.txt, содержащий числа (по одному числу в строке).
//Суммирует все числа из файла.
//Записывает результат в файл output.txt.
        String filename = "input.txt";

        List<Integer> numbers = List.of(10, 20, 30, 40, 50, 150, 0, 20, 50, 21);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Integer number : numbers) {
                writer.write(number.toString()); 
                writer.newLine();
            }
            System.out.println("Файл " + filename + " успешно создан и заполнен ");

        } catch (IOException e) {
            System.out.println("Ошибка при создании/записи файла : " + e.getMessage());
        }
        int sum = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    int number = Integer.parseInt(line);
                    sum += number;
                } catch (IOException e) {
                    System.out.println("Некорректное число в файле " + line);
                }
                }
            System.out.println("Сумма всех чисел из файла =  " + sum);
        } catch (IOException e) {
            System.out.println( e.getMessage());
            return;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write("Сумма = " + String.valueOf(sum));
        } catch (IOException e) {
            System.out.println( e.getMessage());
        }

    }
}
