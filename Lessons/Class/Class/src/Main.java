//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//  Задание 1
//  Создайте класс Circle, который имеет:
//  Поле radius (тип double).
//  Конструктор для установки радиуса.
//  Метод calculateArea(), который возвращает площадь круга.

      class  Circle {
          static double radius ;
      public  Circle  ( double radius){
        this.radius = radius;
      }
      public static double calculateArea(){
         double area = 3.14*radius*radius;
         return area;
      }
      }




//  Задание 2
//  Создайте класс Rectangle, который имеет:
//
//  Поля length и width (оба типа double).
//  Конструктор для установки длины и ширины.
//  Метод calculatePerimeter(), который возвращает периметр прямоугольника.

        class Rectangle {
     static double  length;
     static double  width;

     public  Rectangle (double length, double width){
       this.length = length;
       this.width = width;
    }
    public static  double  calculatePerimeter(){
         double Perimetr =  2 * (length + width);
         return Perimetr;
    }
   }

//
//  Задание 3
//  Создайте класс Student, который имеет:
//
//   Поля name (тип String) и age (тип int).
//   Конструктор для установки имени и возраста.
//   Метод displayInfo(), который выводит имя и возраст студента в консоль.
    class Student{
        static String name;
        static int age;

     public Student(String name, int age){
        this.name = name;
        this.age = age;
        }
        public static void  displayInfo(){
          System.out.println("Name: " + name);
          System.out.println("Age: " + age);
        }
    }
//
//   Задание 4
//   Создайте класс Car, который имеет:
//
//   Поля brand (тип String) и speed (тип int).
//   Конструктор для установки бренда и начальной скорости.
//   Метод accelerate(int increment), который увеличивает скорость на указанное значение.
     class    Car{
         String  brand;
         int speed = 0;
         public Car(String  brand, int speed){
           this.brand = brand; this.speed = speed;
         }
         public int accelerate(int increment){
              this.speed += increment;
        return this.speed;
         }
     }
//
//    Задание 5
//    Создайте класс Book, который имеет:
//
//    Поля title (тип String) и author (тип String).
//    Конструктор для установки названия книги и автора.
//    Метод getBookInfo(), который возвращает строку с информацией о книге.
     class  Book{
         String title;
         String author;
         public Book(String title, String author){
           this.author = author;
           this.title = title;
         }
         public String getBookInfo(){
             return this.author + this.title;
         }
     }

//
//    Задание 6
//    Создайте класс Point, который имеет:
//
//    Поля x и y (оба типа int).
//    Конструктор для установки координат точки.
//    Метод move(int dx, int dy), который изменяет координаты точки на заданное смещение.
       class Point{
           int x;
           int y;
           public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
          public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
       }

//
//     Задание 7
//     Создайте класс Person, который имеет:
//
//     Поля firstName и lastName (оба типа String).
//     Конструктор для установки имени и фамилии.
//     Метод getFullName(), который возвращает полное имя человека.
       class Person{
           static String firstName;
           static String lastName;
            public Person(String firstName, String lastName){
              this.firstName = firstName;
        this.lastName = lastName;
           }
           public static String  getFullName(){
                 return firstName + " " + lastName;
           }
       }
//
//     Задание 8
//     Создайте класс Temperature, который имеет:
//
//     Поле celsius (тип double).
//     Конструктор для установки температуры в градусах Цельсия.
//     Методы toFahrenheit() и toKelvin(), которые возвращают температуру в Фаренгейтах и Кельвинах соответственно.
        class Temperature{
         static double celsius;
          public Temperature(double celsius) {
        this.celsius = celsius;
    }
         public static double toFahrenheit(){
             return (celsius * 9 / 5) + 32;
         }
         public static double  toKelvin(){
              return celsius + 273.15;
         }
        }
//
//     Задание 9
//     Создайте класс Counter, который имеет:
//
//      Поле count (тип int), изначально равное 0.
//      Метод increment(), который увеличивает значение поля на 1.
//      Метод decrement(), который уменьшает значение поля на 1.
//      Метод getCount(), который возвращает текущее значение счетчика.
       class   Counter{
           static int count = 0;
           public static void increment(){
                 count++;

           }
           public static void decrement(){
              count--;

           }
           public static int  getCount(){
            return count;
           }
       }
//
//    Задание 10
//    Создайте класс Time, который имеет:
//
//    Поля hours и minutes (оба типа int).
//    Конструктор для установки времени.
//    Метод addMinutes(int minutes), который добавляет заданное количество минут к времени и корректно обновляет часы.
    class Time{
            int hours;
            int minutes;
        public Time(int hours, int minutes) {
            if (hours < 0 || hours > 23) {
              System.out.println("Часы должны быть в диапазоне от 0 до 23");
            }
             if (minutes < 0 || minutes > 59) {
                 System.out.println("Минуты должны быть от 0 до 59");
             }
        this.hours = hours;
        this.minutes = minutes;
        }
        public static void  addMinutes(int minutes){

             if(minutes < 0){
               System.out.println("Минуты не могут быть меньше 0");
             }
        this.minutes += minutes;
        this.hours += this.minutes / 60;
        this.minutes %= 60;
        this.hours %= 24;
        }
   }
        



    }
}
