//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
// 1   Написать метод, который возвращает факториал заданного числа.
public static long factorial(int n) {
    if (n == 0) {
        return 1;
    }
    return n * factorial(n - 1);
}
// 2   Написать метод, который возвращает среднее арифметическое массива чисел.
public static int srArifmetichescoe(int[] arr) {
    int x = 0;
    int srednee = 0;
    for (int i = 0; i < arr.length; i++) {
srednee  = srednee + arr[i];
x = srednee/ arr.length;
        }
    return srednee;
    }

// 3   Написать метод, который возвращает сумму элементов массива.
public static int summa(int[] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
        sum = sum +  arr[i];
    }
    return (sum);
}

// 4   Написать метод, который возвращает произведение элементов массива.
public static int proiz(int[] arr) {
    int proizvedenie = 1;
    for (int i = 0; i < arr.length; i++) {
        proizvedenie = proizvedenie* arr[i];
    }
    return (proizvedenie);
}

// 5   Написать метод, который возвращает наибольшее число из массива.
public static int naibolshee(int[] arr) {
    int max = arr[0];
 for (int i = 0; i < arr.length; i++) {
 if (arr[i]>max);
 max = arr[i];
       }
    return (max);
}

// 6   Написать метод, который возвращает наименьшее число из массива.
public static int naimenshee(int[] arr) {
    int min = arr[0];
    for (int i = 0; i < arr.length; i++) {
if (arr[i] <= min)
     min = arr[i];
        }
    return (min);
}

// 7   Написать метод, который возвращает разницу между максимальным и минимальным элементом массива.
public static int raznica(int[] arr){
     int raznica = naibolshee(arr) - naimenshee(arr);
     return (raznica);
}

// 8   Написать метод, который возвращает сумму квадратов элементов массива.
public static int summaKvadratov(int[] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
        arr[i] = arr[i]*arr[i];
    }
    for (int i = 0; i < arr.length; i++) {
        sum = sum + arr[i];
    }
    return (sum);
}

// 9   Написать метод, который находит объем цилиндра по радиусу и высоте.
public static int chilindrV(int r , int h, int p){
       return (r*r*h*p);
}

// 10  Написать метод, который вычисляет гипотенузу прямоугольного треугольника по двум катетам.
public static int gipatenyza(int a, int b){
    int c = a*a+b*b; //как извлечь корень из числа?
    return (c);
}

// 11  Написать метод, который возвращает сумму чисел от 1 до заданного числа без использования циклов и условий.
public static long summaDoZadannogoChisla(long n) {
    return n * (n + 1) / 2;
}

// 12  Написать метод, который проверяет, является ли число степенью двойки.
public static boolean stepenOfTwo(int n) {
    if (n <= 0) {
        return false;
    }
    return (n & (n - 1)) == 0;
}
// 13  Написать метод, который вычисляет сумму чисел, кратных 3 или 5, в заданном диапазоне.
public static int summaVdiapozone(int start, int end) {
    int sum = 0;
    for (int i = start; i <= end; i++) {
        if (i % 3 == 0 || i % 5 == 0) {
            sum += i;
        }
    }
    return sum;
}

// 14  Написать метод, который возвращает сумму цифр числа.
// 15  Написать метод, который возвращает произведение цифр числа.

// 16  Написать метод, который возвращает количество цифр в числе.
??? public static int countString(int n) {
    return Integer.toString(Math.abs(n)).length();
}

// 17  Написать метод, который возвращает число, полученное в результате зеркального отображения (реверса) заданного числа.

// 18  Написать метод, который возвращает значение числа Фибоначчи с заданным номером.
 public static long fibonacci(int n) {
    if (n <= 1) {
        return n;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
}

// 19  Написать метод, который возвращает длину окружности по заданному радиусу.
public static int dlinaOkr(int r ,  int p){
    return (2*r*p);
}

// 20  Написать метод, который проверяет, является ли треугольник прямоугольным по трём сторонам.
public static void treygolnik(int a, int b, int c) {
    if (a * a == b * b + c * c) {
        System.out.println("Треугольник прямоугольный");
    }
    if (b * b == a * a + c * c) {
        System.out.println("Треугольник прямоугольный");
    }
    if (c * c == a * a + b * b) {
        System.out.println("Треугольник прямоугольный");
    }
}
    public static void main(String[] args) {
        //number 1
        System.out.println(factorial(5));
        // number 2
        int arr[] = new int []{1,2,3,4,5};
        System.out.println(srArifmetichescoe(arr));
        // number 3
        int arr1[] = new int []{1,2,3,4,5,6};
        System.out.println(summa(arr1));
        // number 4
        int arr2[] = new int []{1,2,3,4,5,6};
        System.out.println(proiz(arr2));
        // number 5
        int arr3[] = new int []{1,2,3,4,5,6};
        System.out.println(naibolshee(arr3));
        // number 6
        System.out.println(naimenshee(arr3));
        // number 7
        System.out.println(raznica(arr2));
        // number 8
        System.out.println(summaKvadratov(arr2));
        // number 9
        System.out.println(chilindrV(2,3, 4));
        // number 10
        System.out.println(gipatenyza(3,1));
        // number 11
        long n = 2;
        System.out.println(summaDoZadannogoChisla(n));
        // number 12
        System.out.println(stepenOfTwo(15));
        // number 13
        System.out.println(summaVdiapozone(2, 9));
        // number 14
        // number 15
        // number 16
        System.out.println("№ 16 : " + countString(65544));
       
        // number 17
        // number 18
        System.out.println(fibonacci(3));
        // number 19
        System.out.println(dlinaOkr(2,4));
        // number 20
       treygolnik(4,2,3);
    }
}
