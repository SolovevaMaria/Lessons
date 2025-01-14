//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
// 1. Базовое задание: Абстрактный класс
//Создайте абстрактный класс Shape с методом calculateArea().
// Реализуйте два наследника: Circle и Rectangle.
// В классе Circle метод должен вычислять площадь круга, а в Rectangle — площадь прямоугольника.
//        abstract class Shape {
//            public abstract void calculateArea();
//        }
//        class Circle extends Shape {
//            int r;
//
//            public Circle(int r) {
//                this.r = r;
//            }
//
//            @Override
//            public void calculateArea() {
//                System.out.print("Площадь круга =  ");
//                System.out.println(3.14 * r * r);
//            }
//        }
//        class Rectangle extends Shape {
//            int dlina;
//            int shirina;
//
//            public Rectangle(int dlina, int shirina) {
//                this.dlina = dlina;
//                this.shirina = shirina;
//            }
//
//            @Override
//            public void calculateArea() {
//                System.out.print("Площадь Прямоугольника =  ");
//                System.out.println(dlina * shirina);
//            }
//        }
//        Circle circle = new Circle(10);
//        circle.calculateArea();
//        Rectangle rectangle = new Rectangle(2, 3);
//        rectangle.calculateArea();
//2. Интерфейс для животных
//Создайте интерфейс Animal с методами:
//makeSound()
//move()
//Создайте классы Dog и Bird, которые реализуют этот интерфейс.
// Реализуйте методы так, чтобы собака лаяла, а птица пела.
//        interface Animal {
//            void makeSound();
//
//            void move();
//        }
//        class Dog implements Animal {
//            public String name;
//
//            public Dog(String name) {
//                this.name = name;
//            }
//
//            @Override
//            public void makeSound() {
//                System.out.println(this.name + " gav-gav ");
//
//            }
//
//            @Override
//            public void move() {
//                System.out.println(this.name + " runs");
//            }
//        }
//        class Bird implements Animal {
//            public String name;
//
//            public Bird(String name) {
//                this.name = name;
//            }
//
//            @Override
//            public void makeSound() {
//                System.out.println(this.name + " chirik-chirik");
//            }
//
//            @Override
//            public void move() {
//                System.out.println(this.name + " flies");
//            }
//        }
//        Dog dog = new Dog(" Sharik ");
//        dog.makeSound();
//        dog.move();
//
//        Bird bird = new Bird("Vorona");
//        bird.makeSound();
//        bird.move();


//3. Абстрактный класс + интерфейс
//Создайте абстрактный класс Vehicle с методом startEngine().
// Добавьте интерфейс Flyable с методом fly(). Реализуйте два класса:
//Car (наследует Vehicle)
//Plane (наследует Vehicle и реализует Flyable).
        abstract class Vehicle {
            public abstract void startEngine();
        }
        interface Flyable {
            void fly();
        }
        class Car extends Vehicle {

            @Override
            public void startEngine() {
                System.out.println("Car engine started");
            }
        }
        class Plane extends Vehicle implements Flyable {

            @Override
            public void fly() {
                System.out.println("Plane is flying");
            }

            @Override
            public void startEngine() {
                System.out.println("Plane engine started");
            }
        }

        Car car = new Car();
        car.startEngine();

        Plane plane = new Plane();
        plane.startEngine();
        plane.fly();


//4. Список сотрудников
//Создайте абстрактный класс Employee с методами getSalary() и getRole().
// Реализуйте два класса:
//Manager
//Developer
//Каждый класс должен возвращать свою зарплату и роль.
        abstract class Employee {
            public abstract double getSalary();

            public abstract String getRole();
        }
        class Manager extends Employee {

            @Override
            public double getSalary() {
                return 10000.05;
            }

            @Override
            public String getRole() {
                return "Manager";
            }
        }
        class Developer extends Employee {

            @Override
            public double getSalary() {
                return 2311.77;
            }

            @Override
            public String getRole() {
                return "Developer";
            }
        }
        Manager manager = new Manager();
        System.out.println("Role: " + manager.getRole());
        System.out.println("Zarplata : " + manager.getSalary());

        Developer developer = new Developer();
        System.out.println("Role: " + developer.getRole());
        System.out.println("Zarplata : " + developer.getSalary());


//5. Управление устройствами
//Создайте интерфейс Switchable с методами turnOn() и turnOff(). Реализуйте классы:
//LightBulb
//Fan
//Каждый класс должен менять свое состояние (включено/выключено).
        interface Switchable {
            void turnOn();

            void turnOff();
        }
        class LightBulb implements Switchable {
            private boolean on;

            public LightBulb() {
                this.on = false;
            }

            @Override
            public void turnOn() {
                this.on = true;
                System.out.println("LightBulb turned ON");
            }

            @Override
            public void turnOff() {
                this.on = false;
                System.out.println("LightBulb turned OFF");
            }

            public boolean on() {
                return on;
            }
        }
        class Fan implements Switchable {
            private boolean on;

            public Fan() {
                this.on = false;
            }

            @Override
            public void turnOn() {
                this.on = true;
                System.out.println("Fan turned ON");
            }

            @Override
            public void turnOff() {
                this.on = false;
                System.out.println("Fan turned OFF");
            }

            public boolean on() {
                return on;
            }
        }


//6. Геометрические фигуры
//Создайте интерфейс Drawable с методом draw().
// Реализуйте классы:
//Circle
// Square
//Метод draw() должен выводить текстовое описание фигуры (например, "Рисуем круг").
        interface Drawable {
            void draw();
        }
        class Circle implements Drawable {

            @Override
            public void draw() {
                System.out.println("Рисуем круг");
            }
        }
        class Square implements Drawable {

            @Override
            public void draw() {
                System.out.println("Рисуем квадрат");
            }
        }
        Circle circle = new Circle();
        circle.draw();

        Square square = new Square();
        square.draw();

//7. Работа с базой данных
//Создайте интерфейс Database с методами:
//connect()
//disconnect()
//Реализуйте классы:
//MySQLDatabase
//PostgreSQLDatabase
//Каждый класс должен выводить сообщения о подключении и отключении.
        interface Database {
            void connect();

            void disconnect();
        }
        class MySQLDatabase implements Database {

            @Override
            public void connect() {
                System.out.println("Подключение к MySQL");
            }

            @Override
            public void disconnect() {
                System.out.println("Отключение от MySQL");
            }
        }
        class PostgreSQLDatabase implements Database {

            @Override
            public void connect() {
                System.out.println("Подключение к PostgreSQL");
            }

            @Override
            public void disconnect() {
                System.out.println("Отключение от PostgreSQL");
            }
        }
        MySQLDatabase mySQLDatabase = new MySQLDatabase();
        mySQLDatabase.connect();
        mySQLDatabase.disconnect();

        System.out.println();

        PostgreSQLDatabase postgreSQLDatabase = new PostgreSQLDatabase();
        postgreSQLDatabase.connect();
        postgreSQLDatabase.disconnect();
//8. Спортивные соревнования
//Создайте интерфейс Athlete с методами:
//run()
//jump()
//Реализуйте классы:
//Runner
//Jumper
//Каждый класс должен реализовать соответствующие методы.
        interface Athlete {
            void run();

            void jump();
        }
        class Runner implements Athlete {

            @Override
            public void run() {
                System.out.println("Бежит");
            }

            @Override
            public void jump() {
                System.out.println("Бегун не  прыгаeт");
            }
        }
        class Jumper implements Athlete {

            @Override
            public void run() {
                System.out.println("Прыгун не  бегаeт");
            }

            @Override
            public void jump() {
                System.out.println("Прыгает");
            }
        }
        Runner runner = new Runner();
        runner.run();
        runner.jump();

        Jumper jumper = new Jumper();
        jumper.run();
        jumper.jump();

//9. Магазин
//Создайте абстрактный класс Product с методами:
//getPrice()
//getName()
//Создайте классы Electronics и Clothing, которые наследуют Product и реализуют методы.
        abstract class Product {
            public abstract double getPrice();

            public abstract String getName();
        }
        class Electronics extends Product {
            public String name;
            public double price;

            public Electronics(String name, double price) {
                this.name = name;
                this.price = price;
            }

            @Override
            public double getPrice() {
                return price;
            }

            @Override
            public String getName() {
                return name;
            }
        }
        class Clothing extends Product {
            public String name;
            public double price;

            public Clothing(String name, double price) {
                this.name = name;
                this.price = price;
            }

            @Override
            public double getPrice() {
                return price;
            }

            @Override
            public String getName() {
                return name;
            }
        }
        Electronics electronics = new Electronics("Laptop", 1000.0);
        System.out.println("Product: " + electronics.getName());
        System.out.println("Price: " + electronics.getPrice());

        Clothing clothing = new Clothing("T-Shirt", 200.25);
        System.out.println("Product: " + clothing.getName());
        System.out.println("Price: " + clothing.getPrice());
//10. Зоопарк
//Создайте абстрактный класс Animal с методами:
//eat()
//sleep()
//Добавьте интерфейс SoundMaker с методом makeSound(). Реализуйте классы:
//Lion
//Elephant
//Каждое животное должно реализовать свои звуки, приемы пищи и сон.
        abstract class Animal {
            public abstract void eat();
            public abstract void sleep();

        }
        interface SoundMaker{
            void   makeSound();
        }
        class Lion extends Animal implements SoundMaker {

            @Override
            public void makeSound() {
                System.out.println("Рpppppp");
            }

            @Override
            public void eat() {
                System.out.println("Лев ест мясо");
            }

            @Override
            public void sleep() {
                System.out.println("Лев спит 15 часов");
            }
        }
        class Elephant extends Animal implements SoundMaker {
            @Override
            public void eat() {
                System.out.println("Слон ест траву");
            }

            @Override
            public void sleep() {
                System.out.println("Слон спит 3 часа");
            }

            @Override
            public void makeSound() {
                System.out.println("yyyyy");
            }
        }
        Lion lion = new Lion();
        lion.eat();
        lion.sleep();
        lion.makeSound();

        Elephant elephant = new Elephant();
        elephant.eat();
        elephant.sleep();
        elephant.makeSound();


    }
}
