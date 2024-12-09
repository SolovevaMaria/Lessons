//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        1) Найдите и выведите количество положительных и отрицательных чисел в массиве.
//        int arr[] = new int []{1,-52,-3,44,5,0,7,8,9,10, 0, 9, 0, 12,0, 45,98,65,87,0};
//        int x = 0;
//        int y = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] >=0)
//                x++;
//            else {
//                y++;
//            }
//        }
//        System.out.println(x);
//        System.out.println(y);

//        2) Подсчет нулей: Создайте массив из 20 чисел, заполните его случайными числами , и подсчитайте, сколько в нем нулей.
//        int arr[] = new int []{1,-52,-3,44,5,0,7,8,9,10, 0, 9, 0, 12,0, 45,98,65,87,0};
//        int x = 0;
//        for (int i = 0; i < arr.length; i++){
//            if (arr[i]==0)
//                x++;
//        }
//        System.out.println(x);

//        3) Поиск элементов, равных индексу: Найдите все элементы массива, значения которых равны их индексам.
//        int arr[] = new int []{1,1,2,3,5,4,6,7,9,3,21,11,24,13};
//        int x = 0;
//        for (int i = 0; i < arr.length; i++) {
//          if (arr[i]==i)
//              x++;
//        }
//        System.out.print(x);

//        4) Удаление элементов: Создайте массив из 15 чисел, замените все отрицательные числа на нули.
//        int arr[] = new int []{1, 2, -2, 4, -5,-6,7 ,8,-9,10,11,-33,23,45,-65};
//        for (int i = 0; i < arr.length; i++){
//               if(arr[i]<0){
//                   arr[i] = 0;
//               }
//            System.out.print(arr[i] + " ");
//        }

//        5) Дублирование массива: Создайте массив из 15 чисел,а потом каждый элемент удвойти.
//        int arr[] = new int []{1, 0, 12,6, 45,98,65,87,8,3,21,33,23,45,65};
//
//        for (int i = 0; i < arr.length; i++){
//               arr[i]= arr[i]*2;
//            System.out.println(arr[i]);
//        }

//        6) Подсчет элементов, больших предыдущих: Определите количество элементов массива, которые больше предыдущего элемента.
//        int arr[] = new int []{1,2, 3, 4, 5, 4, 3, 2, 1, 0};
//        int x = 0;
//        for (int i = 1; i < arr.length; i++) {
//            if (arr[i] > arr[i-1])
//                x++;
//        }
//        System.out.println(x);

//        7) Произведение элементов: Найдите произведение всех элементов массива, кроме нулевых.
//        int []arr = new int[] {10,20,30,40,50};
//        int x = 1;
//        for (int i = 1; i < arr.length; i++) {
//               x=x*arr[i];
//        }
//        System.out.println(x);

//        8) Сравнение крайних элементов: Определите, больше ли сумма первых пяти элементов массива, чем сумма последних пяти.
//        int arr[] = new int []{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int x = 0;
//        int y = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (i<=4)
//                x = x + arr[i];
//            else {
//                y = y + arr[i];
//            }
//        }
//        if (x>y)
//            System.out.println("сумма первых пяти элементов больше" + x + '>' + y);
//        else {
//            System.out.println("сумма первых пяти элементов меньше" + x + '<' + y);
//        }

//        9) Поиск двух наименьших элементов:  Найдите два наименьших элемента в массиве из 10 чисел.
//        int[] arr = {8, 3, 1, -90, 2, 7, 4, 6, -5, 0};
//        int min = arr[0];
//        int min2 = 0;
//        for (int i = 1; i < arr.length; i++) {
//            if (arr[i] < min) {
//                min2 = min;
//                min = arr[i];
//            } else if (arr[i] < min2) {
//                min2 = arr[i];
//            }
//        }
//        System.out.println(min);
//        System.out.println(min2);
//    


//        10) Проверка на упорядоченность:   Определите, отсортирован ли массив по возрастанию.
//        int[] arr = {11, 88, 2, -8, 54, 73, 25, 71, 16, 0, 4, 9, 3};
//        boolean x = true;
//        for (int i = 0; i < arr.length - 1; i++) {
//            if (arr[i] < arr[i + 1]) {
//                x = false;
//                break;
//            }
//        }
//        if (x) {
//            System.out.println("отсортирован");
//        } else {
//            System.out.println("не отсортирован");
//        }
    
//        11) Проверка на упорядоченность: Определите, отсортирован ли массив по убыванию.
//        int[] arr = {11, 88, 2, -8, 54, 73, 25, 71, 16, 0, 4, 9, 3};
//        boolean x = true;
//        for (int i = 0; i < arr.length - 1; i++) {
//            if (arr[i] > arr[i + 1]) {
//                x = false;
//                break;
//            }
//        }
//        if (x) {
//            System.out.println("отсортирован");
//        } else {
//            System.out.println("не отсортирован");
//        }

//        12) Частота элементов: Подсчитайте, сколько раз каждое число встречается в массиве.
//        int arr[] = new int []{1, 2, 2, 4, 5,2,7 ,8,-9,10,11,-33,23,45,-65};
//        int x = 0;
//        for (int i = 0; i < arr.length; i++){
//                if (arr[i]==arr[i]){
//                    x++;
//                }
//
//            System.out.print(arr[i]+" ");
//        }

//        13) Инвертирование знаков: Замените все положительные числа в массиве на отрицательные, и наоборот.
//        int arr[] = new int []{1, 2, -2, 4, -5,-6,7 ,8,-9,10,11,-33,23,45,-65};
//        for (int i = 0; i < arr.length; i++){
//                arr[i] = arr[i]*-1;
//
//            System.out.print(arr[i] + " ");
//        }

//        14) Замена элементов на чётные индексы: Замените все элементы на чётных индексах на их квадрат.
//        int arr[] = new int []{1, 2, -2, 4, -5,-6,7 ,8,-9,10,11,-33,23,45,-65};
//        for (int i = 0; i < arr.length; i++){
//            if(i%2==0){
//                arr[i] = arr[i]*arr[i];
//            }
//            System.out.print(arr[i] + " ");
//        }

//        15) Сумма элементов на чётных индексах: Найдите сумму элементов, расположенных на чётных индексах массива.
//        int arr[] = new int []{1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int sum = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (i % 2 == 0) {
//                sum += arr[i];
//            }
//        }
//        System.out.println(sum);

//        16) Замена минимального элемента на 100: Замените минимальный элемент из массива.
//        int arr[] = new int []{1,2,3,-4,5,6,7,8,-9,10};
//        int min = arr[0];
//        int index = 0;
//        for (int i = 0; i <arr.length; i++) {
//            if (arr[i] <= min) {
//                min = arr[i];
//                index = i;
//            }
//        }
//        arr[index]=100;
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }

//        17) Обратный порядок массива: Распечатайте массив наоборот
//        int[] arr = {1, 2, 3, 4, 5};
//        for (int i = arr.length - 1; i >= 0; i--) {
//            System.out.print(arr[i] + " ");
//        }

//        18) Замена элементов на индекс: Замените все элементы массива на их индекс.
//        int arr[] = new int []{1, 2, 3, 4, 5, 6, 7};
//        for (int i = 0; i < arr.length; i++) {
//           arr[i]=i;
//            System.out.print(arr[i]+" ");
//        }

//        19) Сумма положительных элементов: Найдите сумму всех положительных элементов массива.
//        int arr[] = new int []{0, 1, 2, 3, -4, -5, -10, 1, 0, -21, 12};
//        int x = 0;
//        int sum = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] >=0)
//                sum = sum+arr[i];
//        }
//        System.out.println(sum);

//        20) Поиск последнего отрицательного элемента: Найдите последний отрицательный элемент в массиве и замените его на 0.
//        int arr[] = new int[]{1, 2, 3, -4, 5, 6, 7};
//        int otr = -1;
//
//        for (int i = arr.length - 1; i >= 0; i--) {
//            if (arr[i] < 0) {
//                otr = i;
//                break;
//            }
//        }
//        if (otr != -1) {
//            arr[otr] = 0;
//        }
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
        
//        21) Удвоение элементов на нечётных индексах: Умножьте все элементы на нечётных индексах на 2.
//        int arr[] = new int []{1,1,2,3,5,4,6,7,9,3,21,11,24,13};
//        for (int i = 0; i < arr.length; i++) {
//          if (i%2!=0)
//              arr[i] = arr[i]*2;
//            System.out.print(arr[i]+" ");
//        }

//        22) Замена максимального элемента на минимальный: Найдите максимальный элемент массива и замените его на минимальный.
//        int arr[] = new int []{1,2,3,-4,5,6,7,8,9,10};
//        int min = arr[0];
//        int max = arr[0];
//        for (int i = 0; i <arr.length; i++) {
//            if (arr[i] <= min) {
//                min = arr[i];
//            }
//            if (arr[i]>max)   {
//            max = arr[i];
//            }
//        }
//        System.out.println(max);
//        System.out.println(min);
//        for (int i = 0; i <arr.length; i++) {
//            if (arr[i] == min){
//               arr[i]  = max;
//            }
//           else  if (arr[i] == max) {
//                arr[i] = min;
//            }
//            System.out.print(arr[i] + " ");
//        }

//        23) Замена элементов, делящихся на 2 и 3: Замените в массива все элементы, которые делятся на 2 и на 3 на число 100.
//        int arr[] = new int []{1,1,2,3,5,4,6,7,9,3,21,11,24,13};
//        for (int i = 0; i < arr.length; i++) {
//          if (arr[i]%2==0) {
//              arr[i] = 100;
//          }
//          if (arr[i]%3==0) {
//              arr[i] = 100;
//          }
//            System.out.print(arr[i]+" ");
//        }

//        24) Количество элементов, больших среднего арифметического: Подсчитайте количество элементов, которые больше среднего арифметического массива.
//        int arr[] = new int []{1,2,3,4,5};
//        int x = 0;
//        int sum = 0;
//        int a = 0;
//            for (int i = 0; i < arr.length; i++) {
//                 sum = sum + arr[i];
//                x = sum / arr.length;
//             }
//             for (int i = 0; i < arr.length; i++) {
//                  if (arr[i]>x)
//                      a++;
//              }
//              System.out.println(a);

//        25) Нахождение индекса максимального элемента: Найдите индекс максимального элемента в массиве.
//        int arr[] = new int []{1,2,3,4,5,6,7,8,9,10};
//        int max = arr[0];
//        int x = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i]>max);
//            max = arr[i];
//            x = i;
//        }
//        System.out.println("индекс максимума " + x);
//        System.out.println("максимум " + max);

    }
}
