//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static boolean contains(char[] arr,char[] search,int start){
        int i = 0;
      if  ( start < 0 || start+ search.length> arr.length ) {
                return false;
            }
      while (i<search.length) {
          if (arr[start + i] != search[i]){
              return false;
          }
          i++;
      }

        return true;
    }

    public static int countVxojdeniy(char[] arr ,char[] search ){
        int count = 0;
        int i = 0;
        while ( i <= arr.length - search.length) {
            if (contains(arr,search,i)){
                count++;
                i+=search.length;
            }  else {
                i++;
            }
        }
        return count;
    }
    
    public static int indexOf(char[] arr ,char[] search ,int start) {
        int i = start;
        while ( i <= arr.length - search.length) {
            if (contains(arr,search,i)){
                return i;
            }
            i ++;
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

            result = arrayCopy(original,startIndex,result,resultIndex,findIndex-startIndex);
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

    public static void main(String[] args) {
        char[] str =    "kak dela? masha ti tut? Poka masha!".toCharArray();
        char[] search = "masha".toCharArray();
        char[] old = "Oleq".toCharArray();
        System.out.print("My function => " );
        char[] result = replaceAll(str,search,old);
        for (int i = 0; i < result.length ; i++) {
            System.out.print(result[i]);
        }
        System.out.println();
      
    }
}
