import java.lang.reflect.Array;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//1
// Напишите метод printElement, который принимает один параметр любого типа (T) и выводит его значение в консоль.
//Создайте обобщённый метод для работы с массивами.
        printElement(12);
        printElement(9);
        printElement("hello");
        printElement('-');

//2
// Напишите метод getFirstElement, который принимает массив любого типа (T[]) и возвращает его первый элемент.
//Напишите метод для проверки равенства.
       
//3
// Реализуйте метод isEqual, который принимает два параметра одного типа (T) и возвращает true, если они равны.
//Создайте обобщённый класс для хранения пары.

//4
// Напишите класс Pair<T1, T2>, который хранит два значения (T1 и T2).
// Реализуйте методы getFirst() и getSecond().


//5
//Обобщённый метод для реверса массива.
// Напишите метод reverseArray, который принимает массив любого типа (T[]) и возвращает новый массив с элементами в обратном порядке.

//6
//Сравнение элементов.
// Реализуйте метод compareElements, который принимает два элемента одного типа (T) и возвращает строку:
//"Элементы равны" — если они равны.
//"Элементы не равны" — если они различны.
//Создайте обобщённый метод для поиска элемента.

//7
// Напишите метод findIndex, который принимает массив (T[]) и элемент (T) и возвращает индекс первого вхождения элемента в массив (или -1, если элемент не найден).
//Обобщённый метод для создания списка.

//8
// Реализуйте метод toList, который принимает массив любого типа (T[]) и возвращает список (List<T>), содержащий те же элементы.
//Метод для копирования массива.

//9
// Напишите метод copyArray, который принимает массив любого типа (T[]) и возвращает его копию.
        Integer[] arr1 = {1, 2, 3, 4, 5};
        Integer[] arr2 = copyArray(arr1);
        System.out.println(Arrays.toString(arr2));
//10
// Создайте класс для хранения трёх объектов.
//Реализуйте класс Triple<T1, T2, T3>, который содержит три поля разных типов (T1, T2, T3). Добавьте методы для установки и получения значений.
        Triple<String, Integer, Double> triple1 = new Triple<>("Hello", 123, 3.14);
        System.out.println("First: " + triple1.getFirst() + ", Second: " + triple1.getSecond() + ", Third: " + triple1.getThird());

    }


//1
    private static <T> void printElement(T element) {
        System.out.println(element);
    }

// 2
   private static <T> T getFirstElement  (T[] elements) {
      return elements[0];
    }

//3
    public static <T> boolean isEqual(T element1, T element2) {
        if (element1 == element2) {
            return true;
        }
        return false;
    }

//4
  public static class Pair<T1, T2>{
    public T1 first;
    public T2 second;

    public void znachenie(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }
    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }
}
//5
     public static <T> T[] reverseArray(T[] array){
        T[] reverseArray = (T[]) new Object[array.length];
        return reverseArray;
     }

//6
    public static <T> void compareElements (T element1, T element2){
        if (element1 == element2){
            System.out.println("Элементы равны");
        } else {
            System.out.println("Элементы не равны");
        }
    }

//7
    public static <T> int findIndex(T[] array, T element){
        if (array == null || element == null) {
            return -1;
        }
        for (int i = 0; i < array.length; i++) {
            if (element.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }



//8

//9
public static <T> T[] copyArray(T[] arr1) {
    if (arr1 == null) {
        return null;
    }
    return Arrays.copyOf(arr1, arr1.length);
}

//10
public static class Triple<T1, T2, T3> {
    public T1 first;
    public T2 second;
    public T3 third;

    public Triple(T1 first, T2 second, T3 third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T1 getFirst() {
        return first;
    }

    public void setFirst(T1 first) {
        this.first = first;
    }

    public T2 getSecond() {
        return second;
    }

    public void setSecond(T2 second) {
        this.second = second;
    }

    public T3 getThird() {
        return third;
    }

    public void setThird(T3 third) {
        this.third = third;
    }
}












}
