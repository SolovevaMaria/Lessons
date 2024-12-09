//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    //1)public static  int add(int a, int b);
//Условие: Вернуть сумму двух чисел a и b.
    public static  int add(int a, int b){
        return (a+b);
    }

//2)public static  void printMessage(String message);
//Условие: Вывести строку message в консоль.
public static  void printMessage(String message) {
    System.out.println(message);
}

//3)public static int subtract(int a, int b);
//Условие: Вернуть разность чисел a и b.
public static int subtract(int a, int b){
        return (a-b);
}

//4)public static  void greet();
//Условие: Напечатать в консоли стандартное приветствие, например, "Hello, world!".
public static  void greet(){
    System.out.println("Hello, world!");
}

//5)public static  int square(int number);
//Условие: Вернуть квадрат числа number.
public static  int square(int number){
        return (number*number);
}

//6)public static int kub(int number);
//Условие: Вернуть kub числа number.
public static int kub(int number){
  return (number*number*number);
}

//7)public static  boolean isEven(int number);
//Условие: Вернуть true, если число number чётное, иначе false.
public static  boolean isEven(int number){
        if (number%2==0){
            return (true);
        }  else {
            return (false);
        }
}

//8)public static boolean isNeqativ(int number);
//Условие: Вернуть true, если число number отрицательное иначе false.
public static boolean isNeqativ(int number){
    if (number>0){
        return (true);
    }  else {
        return (false);
    }
}

//9)public static void printNumber(int number);
//Условие: Вывести число number в консоль.
public static void printNumber(int number){
    System.out.println(number);
}

//10)public static boolean areEqual(int a, int b);
//Условие: Вернуть true, если числа a и b равны, иначе false.
public static boolean areEqual(int a, int b){
        if(a==b){
            return (true);
        } else {
            return (false);
        }
}
//11)public static int multiply(int a, int b);
//Условие: Вернуть произведение чисел a и b.
public static int multiply(int a, int b){
        return (a*b);
}

    public static void main(String[] args) {
        //number 1
        System.out.println(add(5, 6));
       System.out.println(add(78, 64));
        System.out.println(add(98, 4));

        // number 2
        printMessage("hello world");
        printMessage("my name is Masha");
        printMessage("i am student");

        // number 3
        System.out.println(subtract(5, 6));
        System.out.println(subtract(78, 64));
        System.out.println(subtract(98, 4));

        // number 4
         greet();

        // number 5
        System.out.println(square(11));
        System.out.println(square(2));
        System.out.println(square(6));

        // number 6
        System.out.println(kub(2));
        System.out.println(kub(5));
        System.out.println(kub(100));

        // number 7
        System.out.println(isEven(3));
        System.out.println(isEven(5));
        System.out.println(isEven(2));
        System.out.println(isEven(54));

        // number 8
        System.out.println(isEven(-5));
        System.out.println(isEven(5));
        System.out.println(isEven(-587));
        System.out.println(isEven(54));

        // number 9
        printNumber(65);
        printNumber(89);
        printNumber(5);

        // number 10
        System.out.println(areEqual(43, 43));
        System.out.println(areEqual(3, 43));

        // number 11
        System.out.println(multiply(5,4));
    }
}
