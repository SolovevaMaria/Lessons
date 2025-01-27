//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class MyList {
    private int[] arr;
    private int size;
    private int capacity;

    public MyList() {
        capacity = 10;
        arr = new int[capacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    private void resize() {
        capacity *= 2;
         
    }
    public void add(int value) {
        if (size == capacity) {
            resize();
        }
        arr[size++] = value;
    }

    public void removeByValue(int value) {
        int newSize = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] != value) {
                arr[newSize++] = arr[i];
            }
        }
        size = newSize;
    }

    public void removeByIndex(int index) {
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }


    public boolean isHasValue(int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) {
                return true;
            }
        }
        return false;
    }

    public void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
public class Main {

    public static void main(String[] args) {
        
   // public void removeByValue(int value)
   // public void removeByIndex(int index)
   // public boolean isHasValue(int value)
        MyList myList = new MyList();
        myList.add(1);
        myList.add(5);
        myList.add(4);
        myList.add(3);
        myList.add(7);
         myList.capacity();
       
         myList.size();

         myList.isHasValue(3);

         myList.removeByIndex(4);

         myList.removeByValue(7);

    }
    }
