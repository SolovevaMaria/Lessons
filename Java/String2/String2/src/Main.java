//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    //lTrim                                      +      metod udalyayet probeli s leva
    public static char[] mylTrim(char[] arr){
        int countSpaceL = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' '){
                countSpaceL++;
            }else{
                break;
            }
        }
        char[] newArr = new char[arr.length - countSpaceL];//10

        for (int i = countSpaceL,j = 0; i < arr.length; i++,j++) {
            newArr[j] = arr[i];
        }

        return newArr;
    }

    //RTrim                                             metod udalyayet probeli s prava
    public static char[] myRTrim(char[] arr){
        int countSpaceR = 0;

        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] == ' '){
                countSpaceR++;
            }else{
                break;
            }
        }
        char[] newArr = new char[arr.length - countSpaceR];//10

        for (int i = countSpaceR,j = 0; i < arr.length; i++,j++) {
            newArr[j] = arr[i];
        }

        return newArr;
    }
    //Trim                                              metod udalyayet probeli s prava i s leva
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

    //equals                                            metod proveryayet s ucetom registra
    public static boolean myequals (char[] one,char[] two){
        if (one.length!=two.length){
            return false;
        }
        for (int i = 0; i < one.length; i++) {
            if (one[i] != two[i] ){
                return false;
            }
        }
        return true;
    }

    //startsWith                                        metod proveryayet nacinaetsa li stroka na ukazannuyu stroku
    public static boolean myStartsWith (char[] one,char[] two){
        if (one.length < two.length){
            return false;
        }
        for (int i = 0; i < two.length; i++) {
            if (one[i] != two[i] ){
                return false;
            }
        }
        return true;
    }

    //replace                                           metod zamenyayet staruyu stroku na novuyu
    public static boolean contains(char[] arr,char[] search,int start){
        for (int i = 0; i < search.length ; i++) {
            if (arr[i+start] != search[i]){
                return false;
            }
        }
        return true;
    }
    public static int countVxojdeniy(char[] arr ,char[] search ){
        int count = 0;
        for (int i = 0; i <= arr.length - search.length; i++) {
            if (contains(arr,search,i)){
                i+=search.length;
                count++;
            }
        }
        return count;
    }

    public static int indexOf(char[] arr ,char[] search ,int start) {
        for (int i = start; i <= arr.length - search.length; i++) {
            if (contains(arr,search,i)){
                return i;
            }
        }
        return -1;
    }
    public static char[] replaceAll(char[] original,char[] oldStr,char[] newStr){
        int countEnter = countVxojdeniy(original,oldStr);

        if (countEnter == 0){
            return original;
        }
        int newSize = original.length -  (oldStr.length*countEnter) +  (newStr.length*countEnter);

        char[] result = new char[newSize];


        int startIndex = 0;
        int findIndex = 0;
        int resultIndex = 0;


        while ((findIndex = indexOf(original,oldStr,startIndex))!=-1){
          vxojdeniyaresult = arrayCopy(original,startIndex,result,resultIndex,findIndex-startIndex);
            resultIndex += findIndex-startIndex;

            result = arrayCopy(newStr,0,result,resultIndex,newStr.length);
            resultIndex += newStr.length;

            startIndex = findIndex + oldStr.length;
        }


        result = arrayCopy(original,startIndex,result,resultIndex,original.length - startIndex);

        return result;
    }

    public static char[] arrayCopy(char[] str,int strIndex,char[] dest, int destIndex,int leng){
        for (int i = 0; i < leng; i++) {
            dest[destIndex + i] = str[strIndex + i];
        }
        return dest;
    }
    //equalsIgnoreCase                           +      metod proveryayet s bez uceta registra
    public static boolean myEqualsIgnoreCase(char[] one,char[] two){
        if (one.length!=two.length){
            return false;
        }

        for (int i = 0; i < one.length; i++) {

            char X = (one[i]>='A' && one[i]<='Z' ) ? (char) (one[i] + 32) :one[i];
            char Y = (two[i]>='A' && two[i]<='Z' ) ? (char) (two[i] + 32) :two[i];

            if (X != Y ){
                return false;
            }
        }

        return true;
    }
    //concat            ?                                metod kotoriy dobovlyayew k tekusey stroke novuyu stroku
    public static char[] myConcat(char[] originalArr, char[] newArr) {
        char[] result = new char[originalArr.length + newArr.length];
        return result;
    }

    //endsWith                                          metod proveryayet zakancivaetsa li stroka na ukazannuyu stroku
    public static boolean myEndsWith(char[] one,char[] two){
        if (one.length < two.length){
            return false;
        }
        for (int i = 0; i < two.length; i++) {
            if (one[one.length - two.length + i] != two[i]){
                return false;
            }
        }
        return true;
    }
    
    //substring                                         metod izvlekaet pod stroku iz tekusey straki
    public static String mySubstring(String str, int startIndex, int endIndex) {
        char[] charArray = str.toCharArray();
        char[] subArray = new char[endIndex - startIndex];
        for (int i = 0; i < subArray.length; i++) {
            subArray[i] = charArray[startIndex + i];
        }
        return new String(subArray);
    }
    
    //toCharArray                                       metod konvirtiruet stroku v massiv char
    public static char[] toCharArray(String str) {
        if (str == null) {
            return new char[0];
        }
        return str.toCharArray();
    }
    //indexOf( char a)                                  metod vozvrasaet index dannoqo simvola
    public static int myIndexOf(char simvol, char [] arr){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==simvol)
                return i;
        }
        return -1;
    }

    //indexOf( char a , int fromIndex)                  metod vozvrasaet index dannoqo slova esli ono est nacinaya s fromIndex , inace -1
    public static int myIndexOf2(char simvol, char [] arr, int fromIndex){
        if (arr == null || fromIndex < 0 || fromIndex >= arr.length) {
            return -1;
        }
        for (int i = fromIndex; i < arr.length; i++) {
            if (arr[i] == simvol) {
                return i;
            }
        }
        return -1;
    }

    //lastIndexOf( char a)                              metod vozvrasaet index dannoqo simvola s konca , inace -1
    public static int myLastIndexOf(char simvol, char arr []) {
        for (int i= arr.length-1; i >=0; i--) {
            if (arr[i]==simvol)
                return i;
        }
        return -1;
    }

    //lastIndexOf( char a , int fromIndex)              metod vozvrasaet index dannoqo slova s konca esli ono est nacinaya s fromIndex , inace -1
    public static int myLastIndexOf2(char simvol, char [] arr, int fromIndex){
        if (arr == null || fromIndex < 0 || fromIndex >= arr.length) {
            return -1;
        }
        for (int i= arr.length-1; i >=0; i--) {
            if (arr[i]==simvol)
                return i;
        }
        return -1;
    }
    //lastIndexOf( char[] a)                            metod vozvrasaet index dannoqo slova s konca esli ono est , inace -1
    public static int myLastIndexOff(char simvol, char arr []) {
        for (int i= arr.length-1; i >=0; i--) {
            if (arr[i]==simvol)
                return i;
        }
        return -1;
    }

    //indexOf( char[] a)                                metod vozvrasaet index dannoqo slova esli ono est , inace -1
//    public static int myIndexOf(char simvol, char [] arr){
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i]==simvol)
//                return i;
//        }
//        return -1;
//    }

    //indexOf( char[] a , int fromIndex)                metod vozvrasaet index dannoqo slova esli ono est nacinaya s fromIndex  , inace -1
//    public static int myIndexOf2(char simvol, char [] arr, int fromIndex){
//        if (arr == null || fromIndex < 0 || fromIndex >= arr.length) {
//            return -1;
//        }
//        for (int i = fromIndex; i < arr.length; i++) {
//            if (arr[i] == simvol) {
//                return i;
//            }
//        }
//        return -1;
//    }

    //lastIndexOf( char[] a , int fromIndex)            metod vozvrasaet index dannoqo slova s konca esli ono est nacinaya s fromIndex  , inace -1
//    public static int myLastIndexOff(char simvol, char arr []) {
//        for (int i= arr.length-1; i >=0; i--) {
//            if (arr[i]==simvol)
//                return i;
//        }
//        return -1;
//    }

    //contains                                          metod proveryayet soderjit li stroka ukazannuyu stroku
    public static boolean myContains(char[] one,char[] two){
        if (one == null || two == null || two.length == 0 || one.length < two.length){
            return false;
        }
        for (int i = 0; i <= one.length - two.length; i++) {
            boolean result = true;
        for (int j = 0; j <= one.length - two.length; i++) {
            if (one[i+j] != two[j]){
                result = false;
                break;
            }
        } if (result==true){
                return true;
        }
        }
        return false;
    }  

    //split                                             metod razdelyayet stroku na pod stroku
    public static String[] mySplit(String str, char razdelitel) {
        if (str == null) {
            return new String[0];
        }
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == razdelitel) {
                count++;
            }
        }
        String[] result = new String[count + 1];
        int startIndex = 0;
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == razdelitel) {
                result[index++] = str.substring(startIndex, i);
                startIndex = i + 1;
            }
        }
        result[index] = str.substring(startIndex); 
        return result;
    }

    public static void main(String[] args) {
        String str = "Maria     ";
 char[] arr = str.toCharArray();
//        System.out.println(mylTrim(arr).length);
//        System.out.println(myRTrim(arr).length);
//         int [] arr2 = new int[]{1,2,3,4,5};
//        int [] arr3 = new int[]{6,7,8,9};
        System.out.println(myIndexOf('a',arr));
        System.out.println(myIndexOf2('a',arr,2));
        System.out.println(myLastIndexOf('a',arr));
        System.out.println(myLastIndexOf2('a',arr,2));
    }
}
