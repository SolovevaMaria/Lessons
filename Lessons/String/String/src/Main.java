//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
//    public static int length(char[] arr));
//    Описание: Метод возвращает длину массива символов arr.
//    Считает количество символов в массиве arr и возвращает это значение.
public static int myLength(char[] arr){
  int count = 0;
    for (int i = 0; i < arr.length; i++) {
      count++;
    }
    return count;
}

//    public static char charAt(int index);
//    Описание:
//    Метод возвращает символ, находящийся по указанному индексу в массиве.
//    Берет массив символов и индекс index, проверяет, существует ли символ на этом месте. Если индекс корректен, возвращает символ.
public static char myCharAt(char [] arr, int index) {
    if (index >= 0 && index < arr.length) {
        return arr[index];
    } else {
        return ' ';
    }
}


//    public static int indexOf(char simvol);
//    Описание:
//    Метод возвращает индекс первого вхождения символа simvol в массиве. Если символ не найден, возвращает -1.
//    Проходит по массиву слева направо, ищет первый символ, совпадающий с simvol. Если символ найден, возвращает его индекс. Если нет, возвращает -1.
    public static int myIndexOf(char simvol, char [] arr){
    for (int i = 0; i < arr.length; i++) {
        if (arr[i]==simvol)
      return i;
    }
        return -1;
}

//    public static int lastIndexOf(char simvol);
//    Описание:
//    Метод возвращает индекс последнего вхождения символа simvol в массиве. Если символ не найден, возвращает -1.
//    Проходит по массиву справа налево, ищет последний символ, совпадающий с simvol. Если символ найден, возвращает его индекс. Если нет, возвращает -1.
public static int myLastIndexOf(char simvol, char arr []) {
    for (int i= arr.length-1; i >=0; i--) {
        if (arr[i]==simvol)
            return i;
    }
    return -1;
}

//    public static char[] toUpperCase(char[] arr) ;
//    Описание:
//    Метод возвращает новый массив символов, где все буквы преобразованы в верхний регистр.
//    Для каждой буквы в массиве проверяет, является ли она строчной (например, a-z). Если да, то заменяет её на соответствующую заглавную (например, A-Z).
//    Если символ не является буквой, он остается неизменным.
public static char[] mytoUpperCase(char[] arr) {
    for (int i = 0; i < arr.length; i++) {
      if(arr[i]>='a' && arr[i]<='z'){
          arr[i] -=32;
      }
    }
    return arr;
}

//    public static char[] toLowerCase(char[] arr) ;
//    Описание:
//    Метод возвращает новый массив символов, где все буквы преобразованы в нижний регистр.
//    Для каждой буквы в массиве проверяет, является ли она заглавной (например, A-Z). Если да, то заменяет её на соответствующую строчную (например, a-z).
//    Если символ не является буквой, он остается неизменным.
public static char[] myToLowerCase(char[] arr){
    for (int i = 0; i < arr.length; i++) {
        if(arr[i]>='A' && arr[i]<='Z'){
            arr[i] +=32;
        }
    }
    return arr;
}

//    public static char[] trim(char[] arr );
//    Метод возвращает новый массив символов, из которого удалены начальные и конечные пробелы.
//    Удаляет все пробелы (символы ' ') с начала и конца массива.
//    Пробелы внутри строки остаются неизменными.
public static char[] myTrim(char[] arr ){
    int countSpaceL = 0;
    int countSpaceR = 0;
    for (int i = 0; i < arr.length-1; i++) {
       if(arr[i] == ' '){
           countSpaceL ++;
       } else {
           break;
       }
    }
    for (int i = 0; i < arr.length-1; i++) {
        if(arr[i] == ' '){
            countSpaceR ++;
        } else {
            break;
        }
    }
   char[] arr2 = new char[arr.length-countSpaceR-countSpaceL];
    System.out.println(arr2.length);
    for (int i = countSpaceL,j=0; i < arr.length-countSpaceR; i++,j++) {
        arr2[j]=arr[i];
    }
    return arr2;
}

    public static void main(String[] args) {
         char [] arr  = new char []{'M','a','r','i','a'};
         int lenght = myLength(arr);
        System.out.println("myLenght "+ lenght);
        System.out.println("original " + arr.length);
          int index = myIndexOf('r', arr);
        System.out.println(index);
        int lastIndex = myLastIndexOf('a', arr);
        System.out.println(lastIndex);
        System.out.println(mytoUpperCase(arr));
        System.out.println(myToLowerCase(arr));
        System.out.println(myTrim(arr));
        System.out.println(myCharAt(arr,5));
        

    }
}
