import java.io.*;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Person {
    private String name;
    private String surname;
    private int age;
    private String email;

    public Person(String name, String surname, int age, String email) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
    }
    @Override
    public String toString() {
        return   name + " " + surname  + " " + age ;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
public class Main {
    public static void AddPerson(Scanner scanner, String filePath, List<Person> people) {
        System.out.print("Введите имя : ");
        String name = scanner.nextLine();
        System.out.print("Введите фамилию : ");
        String surname = scanner.nextLine();
        System.out.print("Введите возраст :  ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Введите адрес электронной почты : ");
        String email = scanner.nextLine();
        Person person = new Person(name, surname, age, email);
        people.add(person);
        saveData(filePath, people);
        System.out.println("Человек успешно добавлен ");
    }

    public static void removePerson(Scanner scanner, String filePath, List<Person> people) {
        System.out.print("Введите индекс  для удаления : ");
        int index = scanner.nextInt();
        scanner.nextLine();
        if (index >= 0 && index < people.size()) {
            people.remove(index);
            saveData(filePath, people);
            System.out.println("Человек удален из списка ");
        } else {
            System.out.println("Неверный индекс ");
        }
    }

    public static void updatePerson(Scanner scanner, String filePath, List<Person> people) {
        System.out.print("Введите индекс для обновления : ");
        int index = scanner.nextInt();
        scanner.nextLine();
        if (index >= 0 && index < people.size()) {
            Person person = people.get(index);
            System.out.print("Введите новое имя : ");
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) {
                person.setName(newName);
            }
            System.out.print("Введите новую фамилию : ");
            String newSurname = scanner.nextLine();
            if (!newSurname.isEmpty()) {
                person.setSurname(newSurname);
            }
            System.out.print("Введите новый возраст : ");
            String newAgeStr = scanner.nextLine();
            System.out.print("Введите новый email : ");
            String newEmail = scanner.nextLine();
            if (!newEmail.isEmpty()) {
                person.setEmail(newEmail);
            }
            saveData(filePath, people);
            System.out.println("Данные обновлены ");
        } else {
            System.out.println("Неверный индекс ");
        }
    }

    public static void printAllPersons(Scanner scanner, String filePath, List<Person> people) {
        if (people.isEmpty()) {
            System.out.println("Нет данных о людях.");
        } else {
            for (int i = 0; i < people.size(); i++) {
                Person person = people.get(i);
                System.out.println(i + ": " +   person.getName() + " " +  person.getSurname() + "," +   person.getAge() + ", Email: " + person.getEmail());
            }
        }
    }

    private static void saveData(String filePath, List<Person> people) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Person person : people) {
                writer.write(person.getName() + ", " + person.getSurname() + ", " + person.getAge() + ", " + person.getEmail());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println( e.getMessage());
        }
    }

    public static void main(String[] args)throws IOException {
        String path;
        File file = new File("persons.txt");
        String filePath = "persons.txt";
        List<Person> people = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String name = parts[0];
                    String surname = parts[1];
                    int age = Integer.parseInt(parts[2]);
                    String email = parts[3];
                    people.add(new Person(name, surname, age, email));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Ошибка при чтении файла  " +  e.getMessage());
        }


            Scanner scanner = new Scanner(System.in);
            do {
                System.out.print("Enter command (Add/Remove/Update/Print All/Exit) : ");
                String command = scanner.nextLine();

                if (command.equalsIgnoreCase("add")) {
                    AddPerson(scanner, filePath, people);
                } else if (command.equalsIgnoreCase("remove")) {
                    removePerson(scanner, filePath, people);
                } else if (command.equalsIgnoreCase("update")) {
                    updatePerson(scanner, filePath, people);
                } else if (command.equalsIgnoreCase("print all")) {
                    printAllPersons(scanner, filePath, people);
                } else if (command.equalsIgnoreCase("exit")) {
                    System.out.println("Выход из программы ");
                    break;
                } else {
                    System.out.println("Неверная команда.");
                }
            } while (true);

    }


    }
