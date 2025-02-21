//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class MyList {
    private int[] arr;
    private int size;
    private int capacity;

    {
        capacity = 10;
        size = 0;
        arr = new int[capacity];
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public void increaseArr() {
        if (size >= capacity) {
            capacity = capacity * 2;
            int[] tmp = new int[capacity];
            for (int i = 0; i < size; i++) {
                tmp[i] = arr[i];
            }
            arr = tmp;
        }
    }

    public void add(int value) {
        increaseArr();
        arr[size] = value;
        size++;
    }


    public void addStart(int value) {
        increaseArr();
        for (int i = size; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = value;
        size++;
    }


    public void addByIndex(int index, int value) {
        if (index <= 0) {
            addStart(value);
        } else if (index >= size) {
            add(value);
        } else {
            increaseArr();
            for (int i = size; i > index; i--) {
                arr[i] = arr[i - 1];
            }
            arr[index] = value;
            size++;
        }
    }

    public void sort(boolean isFlag) {
        for (int i = 0; i < size; i++) {
            for (int j = isFlag ? i + 1 : 0; j < size; j++) {
                if (arr[i] < arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    public void printInfo() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addAll(int index, MyList myList) {
        if (myList == null || myList.size == 0) return;

        if (index < 0) {
            index = 0;
        }
        for (int i = 0; i < myList.size; i++) {
            addByIndex(index + i, myList.arr[i]);
        }
    }


    public void clear() {
        for (int i = 0; i < size; i++) {
            arr[i] = 0;
        }
        size = 0;
    }

    public boolean isHasValue(int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }


    public void removeByIndex(int index) {
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        if (size > 0) {
            arr[size - 1] = 0;
        }
        size--;
    }

    public void removeByValue(int value) {
        int newSize = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] != value) {
                arr[newSize++] = arr[i];
            }
        }
        for (int i = newSize; i < size; i++) {
            arr[i] = 0;
        }
        size = newSize;
    }

    public void addAll(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            Integer value = arr[i];
            if (value != null) {
                add(value);
            }
        }
    }


    public void removeAllDuplikat() {
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (arr[i] == arr[j]) {
                    removeByIndex(j);
                    j--;
                }
            }
        }
    }

    public void decreaseArr() {
        if (size == 0) {
            capacity = 10;
            arr = new int[capacity];
            return;
        }
        int newCapacity = size;
        if (newCapacity < 10) {
            newCapacity = 10;
        }
        capacity = newCapacity;
        int[] newArr = new int[capacity];
        for (int i = 0; i < Math.min(arr.length, capacity); i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }


    }
}

public class Main {
    public static void main(String[] args) {
//     -   public void clear()
////   -   public boolean isHasValue(int  value)
////   -   public int indexOf(int value)
// ----------------------------------------------------------------------------
////   -   public void removeByIndex(int index)

////   -   public void removeByValue(int value)
////   -   public void addAll(Integer[] arr)
//----------------------------------------------------------------------------
////   -   public void removeAllDuplikat()
////   -   public void decreaseArr()

        MyList list = new MyList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(4);
        list.add(3);
        list.print();
        System.out.println();
      

        list.removeByIndex(1);
        list.print();

        list.removeByValue(3);
        System.out.println();

        Integer[] arrayToAdd = {5, 6, 7};
        list.addAll(arrayToAdd);
        
        list.print();
        System.out.println();

        list.removeAllDuplikat();
        list.print();
        System.out.println();
        list.decreaseArr();
        list.print();
        System.out.println();
        list.clear();
        list.print();

    }
    }
