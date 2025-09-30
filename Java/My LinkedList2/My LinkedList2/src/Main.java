//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Node {
    String value;
    Node next;

    public Node(String value) {
        this.value = value;
    }
}

class MyLinkedList {
    Node head;


    public void addLast(String value) {
        if (head == null) {
            head = new Node(value);
        } else {
            Node tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            Node newNode = new Node(value);
            tmp.next = newNode;
        }
    }

    public void addStart(String value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }


    public void print() {
        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.value + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public int indexOf(String value) {//Farid
        Node tmp = head;
        int index = 0;
        while (tmp != null) {
            if (tmp.value.equals(value)) {
                return index;
            }
            tmp = tmp.next;
            index++;
        }

        return -1;
    }

    public int size() {
        Node tmp = head;
        int size = 0;
        while (tmp != null) {
            size++;
            tmp = tmp.next;
        }
        return size;
    }


    public String removeLast() {
        if (head == null) return null;
        if (head.next == null) {
            String removed = head.value;
            head = null;
            return removed;
        }

        Node tmp = head;
        while (tmp.next.next != null) {
            tmp = tmp.next;
        }
        String removed = tmp.next.value;
        tmp.next = null;
        return removed;
    }


    public void add(int index, String value) throws Exception {
        int size = size();

        if (index < 0 || index > size)
            throw new Exception("Index bolse size libo mense 0");

        if (index == 0) {
            addStart(value);
            return;
        }

        if (index == size) {
            addLast(value);
            return;
        }

        Node tmp = head;
        for (int i = 0; i < index - 1; i++) {
            tmp = tmp.next;
        }
        Node node = new Node(value);
        node.next = tmp.next;
        tmp.next = node;
    }

    public boolean contains(String value) {
        Node tmp = head;
        int index = 0;
        while (tmp != null) {
            if (tmp.value.equals(value)) {
                return true;
            }
            tmp = tmp.next;
            index++;
        }
        return false;
    }

    public String get(int index) {
        int size = size();
        if (index < 0 || index > size) {
            return "net takova znachenia";
        }
        Node tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return String.valueOf(tmp.value);
    }

    public void clear() {
        head = null;
        int size = 0;
    }

    public boolean isEmpty() {
        Node tmp = head;
        if (tmp != null) {
            return false;  // пустой
        }
        return true;       //заполненный
    }

    public String removeFirst() {
        int size = size();
        if (head == null) return null;
        String removedValue = head.value;
        head = head.next;
        size--;
        return removedValue;
    }

    public String getFirst() {
        if (head == null) {
            return null;
        }
        return head.value;
    }

    public String getLast() {
        Node tmp = head;
        if (head == null) {
            return null;
        }
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        return tmp.value;
    }

    public String remove(int index) {
        int size = size();
        if (head == null) {
            System.out.println("нет элементов для удаления");

        }
        if (index < 0 || index >= size) {
            System.out.println("неверный индекс");

        }
        if (index == 0) {
            removeFirst();
            System.out.println("удален первый элемент");

        }
        Node tmp = head;
        for (int i = 0; i < index - 1; i++) {
            if (tmp == null || tmp.next == null) {

            }
            tmp = tmp.next;
        }
        if (tmp.next == null) {
            System.out.println(" - ");
        }
        Node toRemove = tmp.next;
        tmp.next = toRemove.next;
        toRemove.next = null;
        size--;
        return (" ");
    }


    public String remove(String value) {
        int size = size();
        System.out.println("Удаляем значение: " + value);
        Node tmp = head;
        Node tmp2 = null;
        String removedValue = null;
        while (tmp != null) {
            if (tmp.value != null && tmp.value.equals(value)) {
                removedValue = tmp.value;
                if (tmp2 == null) {
                    head = tmp.next;
                } else {
                    tmp2.next = tmp.next;
                }
                size--;
                return removedValue;
            }
            tmp2 = tmp;
            tmp = tmp.next;
        }
        System.out.println("Значение не найдено");
        return null;
    }

    public void set(int index,String value){
        Node tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }

        tmp.value = value;
    }
}

public class Main {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast("Farid");
        myLinkedList.addLast("David");
        myLinkedList.addLast("Oleq");
        myLinkedList.addLast("Masha");
        myLinkedList.print();
//        System.out.println(myLinkedList.isEmpty());
//        System.out.println(myLinkedList.removeFirst());
//        myLinkedList.print();
//        System.out.println(myLinkedList.getFirst());
//        System.out.println(myLinkedList.getLast());
//       myLinkedList.remove(3);
//        myLinkedList.print();
//        myLinkedList.remove("Oleq");
//        myLinkedList.print();

        myLinkedList.set(1, "Masha");
        myLinkedList.print();
//  +  public int size(); VERNI RAZMER (SKOLKO NODE)
//  +  public boolean contains(String value); // ESLI EST VERNET TRUE ESLI NET FALSE
//  +  public int indexOf(String value);  VOZVRAWAET INDEX DANNOQO ELEMENTA ELSI NETU -1
//  +  public String get(int index); VOZVRAWAET SAM ELEMENT  ELSI NETU THROW NEW EXCEPTION(VI VISLI ZA RAZMER)
//  +  public void add(int index , String value);// DOBAVIT NODE V UKAZANNIY INDEX
        //---------------------------------------------------------------------------
//  +  public void clear();                        ocisaet linked list
//  +  public boolean isEmpty();                   vozvrasaet true esli linked list pustoy inace false
//  +  public String removeFirst();                udalyayet perviy element i vozvrasaet eqo
//  +  public String removeLast();                 udalyayet posledniy element i vozvrasaet eqo
//  +  public String getFirst();                   vernut perviy element
//  +  public String getLast();                    vernut posledniy element
//  +  public String remove(int index);            udalyayet po indeksu i vozvrasaet udalyayemiy obyekt
//  +  public String remove(String value);         udalyayet po znaceniyu i vozvrasaet udalyayemiy obyekt
//  -  public void set(int index,String value);    zameni znacenie ukazannoqo index na value
        //****  ---------------------------------------------------------------------------
//  -  public void sort();                         sortiruet elementi po (vozrastaniyu / ubbivaniyu)
//  -  public void reverse();                      povoracivaet elementi naoborot

    }
}
