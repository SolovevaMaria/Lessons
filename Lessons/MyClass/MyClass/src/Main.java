//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class MyList {
    String[] arr;

    public MyList() {
        arr = new String[0];
    }

    public boolean remove(String value) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(value)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            String[] tmp = new String[arr.length - 1];
            for (int i = 0, j = 0; i < tmp.length; j++) {
                if (j != index) {
                    tmp[i] = arr[j];
                    i++;
                }

            }
            arr = tmp;
            return true;
        }

        return false;
    }
    public boolean remove(int index){
        if (index < 0 || index >= arr.length) {
            return false;
        }
        String[] tmp = new String[arr.length - 1];

        // Копируем элементы до индекса
        for (int i = 0; i < index; i++) {
            tmp[i] = arr[i];
        }

        // Копируем оставшиеся элементы, начиная с позиции после индекса
        for (int i = index + 1, j = index; i < arr.length; i++,j++){
            tmp[j] = arr[i];
        }
        arr = tmp;
        return true;
    }
    public void add(String value) {
        String[] tmp = new String[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            tmp[i] = arr[i];
        }

        tmp[arr.length] = value;

        arr = tmp;
    }

    public void add(int index, String value) {
        String[] tmp = new String[arr.length + 1];
        for (int i = 0; i < index; i++) {
            tmp[i] = arr[i];
        }

        tmp[index] = value;

        for (int i = index; i < arr.length; i++) {
            tmp[i + 1] = arr[i];
        }

        arr = tmp;
    }

    public void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
    public int size(){
        return arr.length;
    }
    public String get(int index){
       return arr[index];

    }
    public void clear() {
        String[] arr2 = new String[0];
        arr =  arr2;
    }
}


public class Main {
    public static void main(String[] args) {
        //Realizovat Dynamic Array

        // +  1 add(T value)
        // +  2 add(int index , T value)
        // +  3 size()
        // +  4 get(int index)
        // +  5 clear()
        // +  6 remove(T value)
        // +  7 remove(int index)
        MyList myList = new MyList();
        myList.add("Farid");
        myList.add("Dima");
        myList.add("Dawa");
        myList.add("Farid");
        myList.print();
        myList.add(3,"hello");
        System.out.println();
        myList.print();
        System.out.println("Udalil? -> " + (myList.remove("Olqa")));
        myList.print();
        System.out.println("Udalil? -> " + (myList.remove(2)));
        myList.print();
        System.out.println("Element at index 1: " + myList.get(1));
        myList.clear();
        myList.print();
    }
}
