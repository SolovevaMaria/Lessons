import java.util.ArrayList;
import java.util.Collection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class MySet<E> {
    private ArrayList<E> elements;  // Динамический массив для хранения элементов

    // Конструктор
    public MySet() {
        elements = new ArrayList<>();
    }

    // 1. Добавляет элемент в множество, если его еще нет
    public boolean add(E e) {
        for (E element : elements) {
            if (element.equals(e)) {
                return false;
            }
        }
        elements.add(e);
        return true;
    }

    // 2. Удаляет элемент из множества
    public boolean remove(Object o) {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).equals(o)) {
                elements.remove(i);
                return true;
            }
        }
        return false;
    }

    // 3. Проверяет, содержит ли множество указанный элемент
    public boolean contains(Object o) {
        for (E element : elements) {
            if (element.equals(o)) {
                return true;  
            }
        }
        return false;
    }

    // 4. Возвращает количество элементов в множестве
    public int size() {
        int count = 0;
        for (E element : elements) {
            count++;
        }
        return count;
    }

    // 5. Проверяет, пусто ли множество
    public boolean isEmpty() {
        if (elements.size() == 0){
        return false;
        }
         return true;
    }

    // 6. Удаляет все элементы из множества
    public void clear() {
        elements = new ArrayList<>();
    }

    // 7. Добавляет все элементы из указанной коллекции в множество
    public boolean addAll(Collection<? extends E> c) {
        boolean znachenie = false;
        for (E element : c) {
            if (add(element)) {
                znachenie = true;
            }
        }
        return znachenie;
    }

    // 8. Проверяет, содержит ли множество все элементы из указанной коллекции
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!contains(element)) {
                return false; 
            }
        }
        return true;
    }

    // 9. Удаляет из множества все элементы, которые есть в указанной коллекции
    public boolean removeAll(Collection<?> c) {
        boolean znacheni = false;
        for (Object element : c) {
            if (remove(element)) { 
                znacheni = true;
            }
        }
        return znacheni;
    }

    // 10. Сохраняет только те элементы, которые есть в указанной коллекции
    public boolean retainAll(Collection<?> c) {
        boolean znachenie = false;
        for (int i = 0; i < elements.size(); ) {
            boolean found = false;
            for (Object o : c) {
                if (elements.get(i).equals(o)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                elements.remove(i);
                znachenie = true;
            } else {
                i++; 
            }
        }
        return znachenie;
    }
}
public class Main {
    public static void main(String[] args) {
        MySet<Integer> mySet = new MySet<>();
        mySet.add(1);
        mySet.add(2);
        mySet.add(3);

        mySet.clear();

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);

        mySet.addAll(numbers);

       ArrayList<Integer> toRemove = new ArrayList<>();
        toRemove.add(5);
        mySet.removeAll(toRemove);
       
    }
}
