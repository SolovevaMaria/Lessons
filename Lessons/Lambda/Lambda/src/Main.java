import java.util.*;
import java.util.function.Consumer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    interface Testeble {
        int sum (int a, int b);
    }

   interface  Testeble2 {
       boolean isEmpty (String str);
   }

   interface Lenght {
        int lent (String str);
   }

   interface Maximum {
        int max (int a, int b);
   }
    interface IsEvan {
        boolean foo (int a);
    }

    interface  Kvadrat {
        int kvad (int a);
    }

    interface Stroka {
        void print(String str);
    }

    interface VRegistr {
         String toUpperCase (String str);
    }

    interface Podstroka {
        boolean contains (String str);
    }

    interface VChislo{
        int parseInt (String str);
    }

    interface Proizvedenie {
        int proizved (int a, int b);
    }

    interface Positive {
        boolean foo (int a);
    }

    interface Filter {
        boolean isEven(int number);
    }

    interface Max {
        int findMax(List<Integer> numbers);
    }

    interface StringLength {
        int compare(String a, String b);
    }

    interface StringOb {
        String ob (String str);
    }

    interface  Obedinenie <T> {
        List<T> combine(List<T> list1, List<T> list2);
    }

    interface FirstLetter {
        String first (String str);

    }

    interface Proverka{
        boolean isNumber (String str);
    }

    public static void main(String[] args) {
//1) Напишите лямбда-выражение, которое принимает два целых числа и возвращает их сумму.
    Testeble testeble = (a,b) -> a+b;
        System.out.println(testeble.sum(10,12));
//2) Создайте лямбда-выражение, которое проверяет, является ли строка пустой.
     Testeble2 testeble2 = (str -> str.isEmpty());
     String str = "Hello!";
        System.out.println(testeble2.isEmpty(str));
//3) Напишите лямбда-выражение, которое принимает строку и возвращает её длину.
     Lenght lenght = lent -> str.length();
        System.out.println(lenght.lent(str));
//4) Создайте лямбда-выражение, которое возвращает максимальное из двух чисел.
      Maximum maximum = (a,b) -> a>b? a:b;
        System.out.println(maximum.max(12,21));
//5) Напишите лямбда-выражение для проверки, является ли число четным.
IsEvan isEvan = a -> a%2==0;
        System.out.println(isEvan.foo(21));
//6) Напишите лямбда-выражение, которое возводит число в квадрат.
      Kvadrat kvadrat = a -> a*a;
        System.out.println(kvadrat.kvad(2));
//7) Создайте лямбда-выражение, которое выводит на экран строку.
        Stroka stroka = a -> System.out.println(str);
        stroka.print("Hello!");
//8) Напишите лямбда-выражение, которое принимает строку и возвращает её в верхнем регистре.
         VRegistr vRegistr = a -> str.toUpperCase();
        System.out.println(vRegistr.toUpperCase("Hello."));
//9) Напишите лямбда-выражение, которое проверяет, содержит ли строка подстроку.
         Podstroka podstroka = a ->  str.contains(a);
        System.out.println(podstroka.contains("Hello!"));
//10) Напишите лямбда-выражение, которое преобразует строку в число.  "число" в инт
        VChislo  vC = a -> Integer.parseInt(a);
        System.out.println(vC.parseInt("21"));
//11) Создайте лямбда-выражение, которое умножает два числа и возвращает результат.
        Proizvedenie proizvedenie = (a,b) -> a*b;
        System.out.println(proizvedenie.proizved(2,3));
//12) Напишите лямбда-выражение, которое проверяет, является ли число положительным.
         Positive positive = a -> {
             if (a>0) return true;
             else return false;
         };
        System.out.println(positive.foo(-2));
//13) Напишите лямбда-выражение для фильтрации всех чётных чисел из списка.
        List<Integer> numbers = new ArrayList<>();
        numbers.add(15);
        numbers.add(26);
        numbers.add(3);
        numbers.add(34);
        numbers.add(59);
        numbers.add(0);
        numbers.add(33);
        numbers.add(1);
        numbers.add(-12);
        numbers.add(10);
        Filter evenFilter = number -> number%2 == 0;
        List<Integer> evenNumbers = new ArrayList<>();
        for (int number : numbers) {
            if (evenFilter.isEven(number)) {
                evenNumbers.add(number);
            }
        }
        System.out.println(numbers);
        System.out.println(evenNumbers);
//14) Напишите лямбда-выражение, которое находит наибольший элемент в списке чисел.
        Max maxFinder = numbersList ->   Collections.max(numbers);
        Integer maxNumber = maxFinder.findMax(numbers);
        if (maxNumber != null) {
            System.out.println("Наибольший элемент : " + maxNumber);
        } else {
            System.out.println("Список пуст ");
        }
//15) Напишите лямбда-выражение, которое сортирует список строк по длине.
        List<String> strings = Arrays.asList("Кирилл", "Даша", "София", "Павел", "Маша");
        StringLength lengthComparator = (a, b) -> a.length() - b.length();
        strings.sort((a, b) -> lengthComparator.compare(a, b));
        System.out.println("Отсортированный список: " + strings);
//16) Создайте лямбда-выражение, которое возвращает строку без пробелов в начале и в конце.
//        StringOb stringOb = str -> str.trim();
//        String stringWithSpaces = "   Hello, world!   ";
//        String trimmedString = stringOb.ob(stringWithSpaces);
//        System.out.println(trimmedString);
//17) Напишите лямбда-выражение, которое объединяет два списка в один.
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        Obedinenie <Integer> combiner = (a, b) -> {
            List<Integer> combinedList = new ArrayList<>(a);
            combinedList.addAll(b);
            return combinedList;
        };
        List<Integer> combinedList = combiner.combine(list1, list2);
        System.out.println( combinedList);
//18) Напишите лямбда-выражение, которое возвращает строку с первой буквой в верхнем регистре.
//        FirstLetter firstLetter = str -> {
//            if (str == null || str.isEmpty()) {
//                return str; // Обработка пустой строки
//            }
//            return str.substring(0, 1).toUpperCase() + str.substring(1);
//        };
//        String inputString = "hello world";
//        String capitalizedString = firstLetter.first(inputString);
//        System.out.println(capitalizedString);
//19) Напишите лямбда-выражение, которое находит разницу между двумя датами.   можно пропустить 
//20) Напишите лямбда-выражение, которое проверяет, является ли строка числом.
//        Proverka proverka = str -> {
//            try {
//                Integer.parseInt(str);
//                return true;
//            } catch (Exception ex) {
//                return false;
//            }
//        };
//        System.out.println(proverka.isNumber("22"));
//        System.out.println(proverka.isNumber("hello"));
//

    }
}
