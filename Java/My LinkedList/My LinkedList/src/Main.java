//import static sun.jvm.hotspot.runtime.BasicObjectLock.size;

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
            tmp = tmp.next;//null
        }
        System.out.println();
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

    public int indexOf(String value) {
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

    }
}
public class Main {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast("Farid");
        myLinkedList.addLast("David");
        myLinkedList.addLast("Oleq");
        myLinkedList.addLast("Mawa");
        myLinkedList.print();
        System.out.println(myLinkedList.contains("Farid"));
        System.out.println(myLinkedList.contains("123"));
        System.out.println(myLinkedList.get(2));
        System.out.println(myLinkedList.get(-1));
        System.out.println(myLinkedList.get(5));
//  +  public int size(); VERNI RAZMER (SKOLKO NODE)
//  -  public boolean contains(String value); // ESLI EST VERNET TRUE ESLI NET FALSE
//  +  public int indexOf(String value);  VOZVRAWAET INDEX DANNOQO ELEMENTA ELSI NETU -1
//  -  public String get(int index); VOZVRAWAET SAM ELEMENT  ELSI NETU THROW NEW EXCEPTION(VI VISLI ZA RAZMER)
//  +  public void add(int index , String value);// DOBAVIT NODE V UKAZANNIY INDEX
    }
}
