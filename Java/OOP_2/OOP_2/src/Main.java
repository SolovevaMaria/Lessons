//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

// 1. Простое наследование
//Создайте базовый класс Animal с атрибутом name.
// Создайте дочерний класс Dog, унаследуйте от Animal, и создайте объект класса Dog, передав ему имя.
////
//   class Animal {
//       String name;
//
//            public Animal(String name) {
//                this.name = name;
//            }
//
//            public String getName() {
//                return name;
//            }
//
//            public void setName(String name) {
//                this.name = name;
//            }
//        }
//        class Dog extends Animal {
//
//            public Dog(String name) {
//                super(name);
//            }
//        }
//2. Добавление нового атрибута
//Создайте класс Vehicle с атрибутом brand.
// Создайте класс Car, который наследует Vehicle, и добавьте атрибут model.
// Создайте объект Car и установите оба атрибута.
        class Vehicle {
            private String brand;

            public Vehicle(String brand) {
                this.brand = brand;
            }

            public String getBrand() {
                return brand;
            }

            public void setBrand(String brand) {
                this.brand = brand;
            }
        }
             class Car extends Vehicle {
            private String model;

            public Car(String brand, String model) {
                super(brand); 
                this.model = model;
            }

            public String getModel() {
                return model;
            }

            public void setModel(String model) {
                this.model = model;
            }
        }
//3. Наследование с использованием метода базового класса
//Создайте класс Person с методом introduce(), который выводит строку "I am a person".
// Создайте класс Student, который наследует Person, и создайте объект Student.
// Вызовите метод introduce().
        class Person {
            public void introduce() {
                System.out.println("I am a person");
            }
        }
         class Student extends Person {

        }
        

//4. Добавление метода в дочерний класс
//Создайте класс Bird с атрибутом species.
// Создайте класс Penguin, который наследует Bird, и добавьте метод swim(), который выводит "I can swim".
        class Bird {
            private String species;

            public Bird(String species) {
                this.species = species;
            }

            public String getSpecies() {
                return species;
            }

            public void setSpecies(String species) {
                this.species = species;
            }
        }
        class Penguin extends Bird {

            public Penguin(String species) {
                super(species);
            }
            public void swim() {
                System.out.println("I can swim");
            }
        }

//5. Наследование с использованием конструктора
//Создайте класс Shape с атрибутом color, который задается через конструктор.
// Создайте класс Rectangle, который наследует Shape, и создайте объект Rectangle с указанием цвета.
        class Shape {
            private String color;

            public Shape(String color) {
                this.color = color;
            }

            public String getColor() {
                return color;
            }

            public void setColor(String color) {
                this.color = color;
            }
        }
        class Rectangle extends Shape {

            public Rectangle(String color) {
                super(color);
            }
        }

//6. Создание нескольких дочерних классов
//Создайте класс Animal.
// Затем создайте два дочерних класса: Dog и Cat.
// В каждом из них добавьте уникальный атрибут, например, breed для собак и color для кошек.
//        class Animal {
//            private String name;
//
//            public Animal(String name) {
//                this.name = name;
//            }
//
//            public String getName() {
//                return name;
//            }
//
//            public void setName(String name) {
//                this.name = name;
//            }
//        }
//        class Dog extends Animal {
//            private String breed;
//
//            public Dog(String name, String breed) {
//                super(name);
//                this.breed = breed;
//            }
//
//            public String getBreed() {
//                return breed;
//            }
//
//            public void setBreed(String breed) {
//                this.breed = breed;
//            }
//        }
//        class Cat extends Animal {
//            private String color;
//
//            public Cat(String name, String color) {
//                super(name);
//                this.color = color;
//            }
//
//            public String getColor() {
//                return color;
//            }
//
//            public void setColor(String color) {
//                this.color = color;
//            }
//        }
        

//7. Наследование с передачей значений в конструктор
//Создайте класс Appliance с атрибутом brand.
// Создайте класс WashingMachine, который наследует Appliance, и установите значение для атрибута brand при создании объекта.

        class Appliance {
            private String brand;

            public Appliance(String brand) {
                this.brand = brand;
            }

            public String getBrand() {
                return brand;
            }

            public void setBrand(String brand) {
                this.brand = brand;
            }
        }
        class WashingMachine extends Appliance {

            public WashingMachine(String brand) {
                super(brand);
            }
        }


//8. Создание цепочки наследования
//Создайте класс LivingBeing с атрибутом type (например, "Living").
// Создайте класс Animal, наследующий LivingBeing, и добавьте атрибут species.
// Создайте класс Mammal, который наследует Animal, и добавьте атрибут name.
        class LivingBeing {
            private String type;

            public LivingBeing(String type) {
                this.type = type;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
        class Animal extends LivingBeing {
            private String species;

            public Animal(String type, String species) {
                super(type);
                this.species = species;
            }

            public String getSpecies() {
                return species;
            }

            public void setSpecies(String species) {
                this.species = species;
            }
        }
        class Mammal extends Animal {
            private String name;

            public Mammal(String type, String species, String name) {
                super(type, species);
                this.name = name;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

//9. Проверка принадлежности к классу
//Создайте класс Fruit и его дочерний класс Apple.
// Создайте объект Apple и с помощью функции isinstance() проверьте, принадлежит ли он к классу Fruit.
        class Fruit {

            private String color;
            public Fruit(String color){
                this.color = color;
            }

            public String getColor(){
                return color;
            }

            public void setColor(String color) {
                this.color = color;
            }
        }
        class Apple extends Fruit {
            public Apple(String color){
                super(color);
            }
        }

//10. Дочерний класс с дополнительным методом
//Создайте класс Device с атрибутом name.
// Создайте класс Phone, который наследует Device, и добавьте метод make_call(), который выводит "Calling...".
        class Device {
            private String name;

            public Device(String name) {

                this.name = name;
            }

            public String getName() {

                return name;
            }

            public void setName(String name) {

                this.name = name;
            }
        }
        class Phone extends Device {
            public Phone(String name) {

                super(name);
            }

            public void makeCall() {
                System.out.println("Calling...");
            }
        }


    }
}
