import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//1
enum Day{
    MONDAY,TUESDAY , WEDNESDAY , THURSDAY , FRIDAY , SATURDAY , SUNDAY
}

//2
enum  Seasons{
     WINTER, SPRING, SUMMER, AUTUMN
 }

//3
 enum  Difficulty{
     EASY, MEDIUM, HARD;
    public String getDirectionMessage() {
        return "Вы движетесь на " + this;
    }
 }

//4
enum Direction{
    NORTH, EAST, SOUTH, WEST
}

//5
enum Status {
    START, PROCESSING, FINISHED
}

//6
enum Priority {
    LOW, MEDIUM, HIGH
}

//7
enum Months{
    DECEMBER,JANUARY,FEBRUARY,MARCH,APRIL,MAY,JUNE,JULY,AUGUST,SEPTEMBER,OCTOBER,NOVEMBER
}

//8
enum Season {
    WINTER("Cold"), SPRING("Warm"), SUMMER("Hot"), FALL("Cool");
    private final String description;

    Season(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

//9
enum ProductCategory {
    ELECTRONICS(0.1), FOOD(0.12), CLOTHING(0.21);
    private final double taxRate;

    ProductCategory(double taxRate) {
        this.taxRate = taxRate;
    }

    public double calculateTax(double price) {
        return price * taxRate;
    }
}

//10
enum Days{
    MONDAY(true),
    TUESDAY(true),
    WEDNESDAY(true),
    THURSDAY(true),
    FRIDAY(true),
    SATURDAY(false),
    SUNDAY(false);

    private final boolean isWorkingDay;

    Days(boolean isWorkingDay) {
        this.isWorkingDay = isWorkingDay;
    }

    public boolean isWorkingDay() {
        return isWorkingDay;
    }
}



public class Main {

public static void main(String[] args) {
//1. Создание и использование enum для дней недели:
//Создайте перечисление Day с константами для всех дней недели.
//Напишите метод, который принимает Day в качестве аргумента и выводит сообщение: "Сегодня [день]".
  // public static void printDay(Day day){
        //            System.out.println("Today is " + day);
        //        }
       // printDay(Day.MONDAY);

//2. Создание enum для времён года:
//Создайте перечисление Season с константами WINTER, SPRING, SUMMER, FALL.
//Напишите метод, который принимает сезон и возвращает логическое значение: true, если это лето.
  //public static void printSeason(Seasons seasons){
    //    if (seasons == Seasons.SUMMER){
    //        System.out.println(true);
    //}  else {
    //        System.out.println(false);
    //    }
//    printSeason(Seasons.SUMMER);
//    printSeason(Seasons.SPRING);
//    printSeason(Seasons.AUTUMN);
//    printSeason(Seasons.WINTER);

//3. Перечисление для уровней сложности:
//Создайте enum Difficulty с уровнями EASY, MEDIUM, HARD.
//Используйте цикл для перебора всех значений перечисления и выведите их на экран.
        for (int i = 0; i < Difficulty.values().length; i++) {
            System.out.println(Difficulty.values()[i]);
        }

//4. Перечисление для направлений:
//Создайте enum Direction с константами NORTH, EAST, SOUTH, WEST.
//Напишите метод, который принимает направление и возвращает сообщение: "Вы движетесь на [направление]".

//        System.out.println(Direction.NORTH.getDirectionMessage());
//        System.out.println(Direction.SOUTH.getDirectionMessage());


//5. Использование метода valueOf:
//Создайте enum Status с константами START, PROCESSING, FINISHED.
//Напишите программу, которая принимает строку из консоли и преобразует её в значение перечисления с помощью valueOf.
    Scanner scanner = new Scanner(System.in);
    System.out.print("Введите статус (START, PROCESSING, FINISHED): ");
    String input = scanner.nextLine().trim().toUpperCase();
    try {
        Status status = Status.valueOf(input);
        System.out.println("Выбран статус: " + status);

    } catch(IllegalArgumentException e){
        System.out.println("Неверный статус. Допустимые значения: START, PROCESSING, FINISHED");
    } finally {
        scanner.close();
    }
//6. Работа с ordinal:
//Создайте enum Priority с уровнями LOW, MEDIUM, HIGH.
//Напишите метод, который возвращает номер каждого уровня, используя метод ordinal().
//public static int getPriorityNumber(Priority priority) {
//    return priority.ordinal();
//}
//   System.out.println("Priority LOW: " + getPriorityNumber(Priority.LOW));
//   System.out.println("Priority MEDIUM: " + getPriorityNumber(Priority.MEDIUM));
//   System.out.println("Priority HIGH: " + getPriorityNumber(Priority.HIGH));

//7. Перебор значений с values:
//Создайте enum Months с названиями месяцев.
//Используйте метод values() для вывода всех месяцев на экран.
//     for (Months month : Months.values()) {
//         System.out.println(month);
//     }
    
//8. Добавление описания к временам года:
//Создайте enum Season с константами WINTER, SPRING, SUMMER, FALL.
//Добавьте поле description (строка) для каждого сезона (например, "Cold", "Warm").
//Напишите метод getDescription, который возвращает описание сезона.
//example: System.out.println(Season.WINTER.getDescription());
  //   System.out.println(Season.WINTER.getDescription());

//9. Добавление полей и методов для категорий товаров:
//Создайте enum ProductCategory с константами ELECTRONICS, FOOD, CLOTHING.
//Для каждой категории добавьте поле taxRate (процент налога).
//Напишите метод calculateTax, который принимает цену товара и возвращает налог на него.
//example: double tax = ProductCategory.ELECTRONICS.calculateTax(1000);
//         System.out.println("Tax: " + tax);
//     double clothingTax = ProductCategory.CLOTHING.calculateTax(200);
//     System.out.println("Tax for clothing: " + clothingTax);

//10. Определение рабочего времени по дням недели:
//Создайте enum Day с константами для всех дней недели.
//Добавьте поле isWorkingDay (логическое значение).
//Реализуйте метод isWorkingDay, который возвращает true для будних дней и false для выходных.
//example: System.out.println(Day.MONDAY.isWorkingDay()); // true
//         System.out.println(Day.SUNDAY.isWorkingDay()); // false
   //  System.out.println(Days.MONDAY.isWorkingDay());
 }
}
