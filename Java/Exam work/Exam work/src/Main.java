import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static java.rmi.server.LogStream.log;

class Contact{
    private int id = generateUniqueId();
    private String name;
    private String surname;
    private int age;
    private String phoneNumber;
    private LocalTime creationTime;

    private static int nextId = 1;

    public Contact() {
    }

    private int generateUniqueId() {
        return nextId++;
    }
    
    public Contact(String name, String surname, int age, String phoneNumber) {
        this.id = generateUniqueId();
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.creationTime = LocalTime.now();
    }

    @Override
    public String toString() {
        return " -------------------------------------------------------------------------\n" +
               "| ID : " + id +  ", Имя Фамилия :  " + name + " " + surname  + " " + "   |\n" +
               "| возраст :  " + age + ", номер телефона :  " + phoneNumber  +   "       |\n" +
               " -------------------------------------------------------------------------\n";
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalTime creationTime) {
        this.creationTime = creationTime;
    }
}


class User {
    private String name;
    private String surname;
    private String  username;
    private String   password;
    private List<Contact> contacts;
    private LocalTime creationUser;

    public User() {
        this.contacts = new ArrayList<>();
    }

    public User(String login, String password) {
        this(login, password, LocalTime.now().toString());
    }
    
    public User(String login, String password, String creationTime) {
        this.username = login;
        this.password = password;
        this.creationUser = LocalTime.parse(creationTime);
        this.contacts = new ArrayList<>();
    }

    public String getName() {
        return  name;
    }

    public void setName(String login) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String login) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String login) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", username, password, creationUser);
    }
}

class PhoneBook{
    private static List<Contact> contacts = new ArrayList<>();

    public PhoneBook(List<Contact> contacts) {
        this.contacts = contacts;
    }
    public static   void addContact(Scanner scanner, List<Contact> contacts) {

        System.out.println(" ----------------------------------------\n" +
                "|                                                  |\n" +
                "|                  Введите имя:                    |\n" +
                " ---------------------------------------------------\n");
        String name = scanner.nextLine();

        System.out.println(" ----------------------------------------\n" +
                "|                                                  |\n" +
                "|                  Введите фамилию:                |\n" +
                " ---------------------------------------------------\n");
        String surname = scanner.nextLine();

        System.out.println(" ----------------------------------------\n" +
                "|                                                  |\n" +
                "|                Введите возраст:                  |\n" +
                " ---------------------------------------------------\n");
        int age;
        
        try {
            age = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {

            System.out.println(" -----------------------------------------------\n" +
                    "|                                                         |\n" +
                    "| Неверный формат возраста.  Возраст должен быть числом!  |\n" +
                    " ----------------------------------------------------------\n");
            return;
        }

        System.out.println(" ---------------------------------------\n" +
                "|                  Введите телефон.                |\n" +
                "|         Используйте формат: +7-ХХХ-ХХХ-ХХ-ХХ     |\n" +
                " ---------------------------------------------------\n");
        String phoneNumber = scanner.nextLine();
        Contact contact = new Contact(name, surname, age, phoneNumber);
        contacts.add(contact);
        System.out.println(" ---------------------------------------\n" +
                "|  Контакт " + name + " " + surname +  " добавлен.|\n" +
                " ---------------------------------------------------\n");
    }

    public static void printAll(List<Contact> contacts) {
        if (contacts.isEmpty()) {
            System.out.println( " ---------------------------------------------------\n" +
                                "|                                                  |\n" +
                                "|                 Список контактов пуст.           |\n" +
                                " ---------------------------------------------------\n");

        } else {
            System.out.println(" ---------------------------------------------------\n" +
                               "|                  Список контактов:               |\n" +
                               " ---------------------------------------------------\n");
            for (int i = 0; i < contacts.size(); i++) {
                Contact contact = contacts.get(i);
                System.out.println((i + 1) + ". " + contact);
            }
        }
    }
    

    public static void editContact(String name, String surname, String newName, String newSurname, String newPhoneNumber, int newAge) {
        for (Contact contact : contacts) {
            if (Objects.equals(contact.getName(), name) && Objects.equals(contact.getSurname(),  surname)) {
                   if (newName != null && !newName.trim().isEmpty()) {
                        contact.setName(newName);
                   }
                   if (newSurname != null && !newSurname.trim().isEmpty()) {
                        contact.setSurname(newSurname);
                   }
                   if (newPhoneNumber != null && !newPhoneNumber.trim().isEmpty()) {
                        contact.setPhoneNumber(newPhoneNumber);
                   }
                   if (newAge > 0) {
                        contact.setAge(newAge);
                   }
                    System.out.println(" --------------------------------------------------------------------------------------\n" +
                                       "| Контакт с именем " + name + " и фамилией " +  surname  + " успешно отредактирован.  |\n" +
                                       "---------------------------------------------------------------------------------------\n");
                   return;
            }
        }
            System.out.println(" ----------------------------------------------------------------\n" +
                    "| Контакт с именем " + name + " и фамилией " +  surname  + " не найден.    |\n" +
                    "----------------------------------------------------------------------------\n");

    }

    public static void deleteContact(int id,  List<Contact> contacts) {
        System.out.println(" ---------------------------------------------------\n" +
                "|       Попытка удаления контакта с id: " + id      +        "|\n" +
                " --------------------------------------------------------------\n");

        boolean removed = contacts.removeIf(contact -> contact.getId() == id);

        if (removed) {
            System.out.println(" ---------------------------------------------------\n" +
                    "|      Контакт с id " + id + " успешно удален."+             "|\n" +
                    " --------------------------------------------------------------\n");
        } else {
            System.out.println(" ---------------------------------------------------\n" +
                    "|     Контакт с id " + id + " не найден."      +             "|\n" +
                    " --------------------------------------------------------------\n");
        }
    }

    public static void deleteContact(String name,  List<Contact> contacts) {
        System.out.println(" ---------------------------------------------------\n" +
                "|       Попытка удаления контакта с именем : " +  name   +   "|\n" +
                " --------------------------------------------------------------\n");

        boolean removed = contacts.removeIf(contact -> Objects.equals(contact.getName(), name));

        if (removed) {
            System.out.println(" ---------------------------------------------------\n" +
                    "|      Контакт с именем : " + name + " успешно удален."+     "|\n" +
                    " --------------------------------------------------------------\n");
        } else {
            System.out.println(" ---------------------------------------------------\n" +
                    "|      Контакт с именем : " + name + "  не найден."+         "|\n" +
                    " --------------------------------------------------------------\n");
        }
    }

    public static void sortByName(int choice, List<Contact> contacts) {
        if(choice == 1) {
            contacts.sort(Comparator.comparing(Contact::getName, String.CASE_INSENSITIVE_ORDER));
            System.out.println(" ----------------------------------------------------\n" +
                               "|             Сортировка по имени (от А до Я) :     |\n" +
                               "-----------------------------------------------------\n");
            System.out.println(contacts+"\n");
        }
        if (choice == 2) {
            Collections.reverse(contacts);
            System.out.println(" ----------------------------------------------------\n" +
                               "|             Сортировка по имени (от Я до А) :     |\n" +
                               "-----------------------------------------------------\n");
            System.out.println(contacts+"\n");
        }
    }

    public static void sortBySurname(int choice,List<Contact> contacts) {
        if(choice == 1) {
            contacts.sort(Comparator.comparing(Contact::getSurname));
            System.out.println(" ----------------------------------------------------\n" +
                               "|             Сортировка по фамилии (от А до Я) :   |\n" +
                               "-----------------------------------------------------\n");
            System.out.println(contacts+"\n");
        }
        if (choice == 2) {
            Collections.reverse(contacts);
            System.out.println(" ----------------------------------------------------\n" +
                               "|             Сортировка по фамилии (от Я до А) :   |\n" +
                               "-----------------------------------------------------\n");
            System.out.println(contacts+"\n");
        }
    }

    public static void sortByPhoneNumber(int choice, List<Contact> contacts) {
        if(choice == 1) {
            contacts.sort(Comparator.comparing(Contact::getPhoneNumber));
            System.out.println(" ----------------------------------------------------\n" +
                               "|     Сортировка по номеру (по возрастанию) :        |\n" +
                               "-----------------------------------------------------\n");
            System.out.println(contacts+"\n");
        }
        if (choice == 2) {
            Collections.reverse(contacts);
            System.out.println(" -----------------------------------------------------\n" +
                               "|             Сортировка по номеру (по убыванию) :   |\n" +
                               "------------------------------------------------------\n");
            System.out.println(contacts+"\n");
        }
    }

    public static void interpreterByName(String name, List<Contact> contacts  ) {
        List<Contact> matches = new ArrayList<>();

        for (Contact contact : contacts) {
            if (contact.getName().toLowerCase().startsWith(name.toLowerCase())) {
                matches.add(contact);
            }
        }

        if (matches.isEmpty()) {
            System.out.println( " ---------------------------------------------------\n" +
                                "|                                                  |\n" +
                                "|                 Совпадений не найдено!           |\n" +
                                " ---------------------------------------------------\n");
        } else {
            System.out.println( " ---------------------------------------------------\n" +
                                "|                                                  |\n" +
                                "|        Совпадения по введенному имени :          |\n" +
                                " ---------------------------------------------------\n");
            System.out.println(matches);
        }
    }

    public static void interpreterBySurname(String surname,List<Contact> contacts ) {

        List<Contact> matches = new ArrayList<>();

        for (Contact contact : contacts) {
            if (contact.getSurname().toLowerCase().startsWith(surname.toLowerCase())) {
                matches.add(contact);
            }
        }
        if (matches.isEmpty()) {
            System.out.println(" ---------------------------------------------------\n" +
                               "|                                                  |\n" +
                               "|                 Совпадений не найдено!           |\n" +
                               " ---------------------------------------------------\n");
        } else {
            System.out.println( " ---------------------------------------------------\n" +
                                "|                                                  |\n" +
                                "|        Совпадения по введенной фамилии :         |\n" +
                                " ---------------------------------------------------\n");
            System.out.println(matches);
        }
    }
    
    public static void interpreterByPhoneNumber(String phoneNumber,List<Contact> contacts ){
        List<Contact> matches = new ArrayList<>();

        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().startsWith(phoneNumber)) {
                matches.add(contact);
            }
        }
        if (matches.isEmpty()) {
            System.out.println( " ---------------------------------------------------\n" +
                                "|                                                  |\n" +
                                "|                 Совпадений не найдено!           |\n" +
                                " ---------------------------------------------------\n");
        } else {
            System.out.println( " ---------------------------------------------------\n" +
                                "|                                                  |\n" +
                                "|        Совпадения по введенному телефону :       |\n" +
                                " ---------------------------------------------------\n");
            System.out.println(matches);
        }
    }

    public List<Contact> getAllContacts() {
        return new ArrayList<>(contacts);  
    }
}

class FileManager {
    public static final String FOLDER_PATH = "memories";
    private static final String FILE_PATH_CONTACTS = "contacts";
    private static final String FILE_PATH_USERS = "users";
    private static final String CONTACTS_FILE = "contacts.dat";

    public static String getContactFilename(String username) {
        String filename = FOLDER_PATH + "/" + username + "/" + "contacts.dat";
        System.out.println("Сформированное имя файла: " + filename);
        return filename;
    }
    public static List<User> readAllUsers(String path) {
        List<User> userList = new ArrayList<>();
        try {
            List<String> lines = Files.lines(Paths.get(path)).collect(Collectors.toList());

            for (String line : lines) {
                String[] userFields = line.split(" ");
                if (userFields.length != 3) {
                    System.err.println(" " + line);
                    continue;
                }
                User user = new User(userFields[0], userFields[1], userFields[2]);
                userList.add(user);

                File contactsFile = new File(FOLDER_PATH + "/" + user.getUsername() + "/" + FILE_PATH_CONTACTS + ".txt");
                if (contactsFile.exists()) {
                    List<String> contactsLines = Files.lines(Paths.get(contactsFile.getAbsolutePath())).collect(Collectors.toList());
                    List<Contact> contacts = new ArrayList<>();
                    for (String contactLine : contactsLines) {
                        String[] contactFields = contactLine.split(" ");
                        if (contactFields.length != 5) {
                            System.err.println(": " + contactLine);
                            continue;
                        }
                        try {
                            int id = Integer.parseInt(contactFields[0]);
                            String name = contactFields[1];
                            String surname = contactFields[2];
                            String phoneNumber = contactFields[4];
                            int age = Integer.parseInt(contactFields[3]);

                            Contact contact = new Contact(name, surname, age, phoneNumber);
                            contacts.add(contact);
                        } catch (NumberFormatException e) {
                            System.err.println(" " + contactLine + " ");
                            continue;
                        }
                    }
                    user.setContacts(contacts);
                }
            }
        } catch (IOException e) {
            System.out.println(" " + e.getMessage());
        }
        return userList;
    }


    public static void saveAllUsers(List<User> users) {
        File userFile = new File(FOLDER_PATH + "/" + FILE_PATH_USERS + ".txt");
        try (FileWriter fileWriter = new FileWriter(userFile)) {
            userFile.createNewFile();
            for (User user : users) {
                fileWriter.write(user.toString() + "\n");


                if (!user.getContacts().isEmpty()) {
                    File userFolder = new File(FOLDER_PATH + "/" + user.getUsername());
                    userFolder.mkdir();

                    File contactsFile = new File(userFolder + "/" + FILE_PATH_CONTACTS + ".txt");
                    try (FileWriter contactsWriter = new FileWriter(contactsFile)) {
                        contactsFile.createNewFile();
                        for (Contact contact : user.getContacts()) {
                            contactsWriter.write(contact.toString() + "\n");
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(" " + e.getMessage());
        }
    }
    

    public static boolean loginUser(String username, String password) {
        String usersFilePath = Paths.get(FOLDER_PATH, FILE_PATH_USERS).toString();
        File file = new File(usersFilePath);

        if (!file.exists()) {
            System.out.println(" ----------------------------------------\n" +
                    "|          Нет файла : " + usersFilePath +        "|\n" +
                    "|                                                  |\n" +
                    " ---------------------------------------------------\n");
            return false;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(" ");

                if (data.length >= 2 && data[0].equals(username) && data[1].equals(password)) {
                    return true;
                }
            }
            return false;

        } catch (FileNotFoundException e) {
            System.out.println(" ----------------------------------------\n" +
                    "|          Файл не найден : " + usersFilePath +   "|\n" +
                    "|                                                  |\n" +
                    " ---------------------------------------------------\n");
            return false;
        }
    }
    public static boolean registerUserWithDetails(String firstName, String surname, String username, String password, String confirmPassword) {
        if (firstName == null || firstName.trim().isEmpty() || surname == null || surname.trim().isEmpty() || username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            System.out.println(" -------------------------------------------------\n" +
                    "|             Не все поля заполнены!               |\n" +
                    " ---------------------------------------------------\n");
            return false;
        }

        if (!password.equals(confirmPassword)) {
            System.out.println(" -------------------------------------------------\n" +
                    "|            Пароли не совпадают!                  |\n" +
                    " ---------------------------------------------------\n");
            return false;
        }

        if (password.length() < 8) {
            System.out.println(" -------------------------------------------------\n" +
                    "|           Минимальная длина пароля 8 символов!   |\n" +
                    " ---------------------------------------------------\n");
            return false;
        }

        createFolder(FOLDER_PATH);

        String usersFilePath = Paths.get(FOLDER_PATH, FILE_PATH_USERS).toString();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(usersFilePath, true))) {
            bw.write(username + " " + password + " Имя : " + firstName + " Фамилия : " + surname);

            createUserFile(username);
            return true;

        } catch (IOException e) {
            System.out.println(" -------------------------------------------------\n" +
                    "|          Ошибка записи в файл!                   |\n" +
                    " ---------------------------------------------------\n");
            return false;
        }
    }

    public static void createFolder(String folderPath) {
        File folder = new File(folderPath);
        if (!folder.exists()) {
            if (folder.mkdirs()) {
                System.out.println(" -------------------------------------------------\n" +
                        "|        Папка " + folderPath + " создана."  +    "|\n" +
                        " ---------------------------------------------------\n");
            } else {
                System.out.println(" -------------------------------------------------\n" +
                        "|     Не удалось создать папку " + folderPath  +  "|\n" +
                        " ---------------------------------------------------\n");
            }
        } else {
            System.out.println(" -----------------------------------------------------\n" +
                    "|        Папка " + folderPath + " уже существует."  + "|\n" +
                    " -------------------------------------------------------\n");
        }
    }

    public static void createUserFile(String username) {
        String filePath = FOLDER_PATH + "/" + username + ".txt";
        File userFile = new File(filePath);

        try {
            if (userFile.createNewFile()) {
                System.out.println(" -----------------------------------------------------\n" +
                        "|  Файл пользователя " + username + " создан." +      "|\n" +
                        " -------------------------------------------------------\n");
            } else {
                System.out.println(" --------------------------------------------------------\n" +
                        "|  Файл пользователя " + username + " уже существует." + "|\n" +
                        " ----------------------------------------------------------\n");
            }
        } catch (IOException e) {
            System.out.println(" ---------------------------------------------------------------\n" +
                    "|  Ошибка при создании файла пользователя: " + e.getMessage() + "|\n" +
                    " -----------------------------------------------------------------\n");
        }
    }



public static void saveContactsToFile(List<Contact> contacts, String filename) {

    if (contacts == null) {
        System.out.println("Список контактов пуст!");
        return;
    }

    try {
        File file = new File(filename);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Contact contact : contacts) {
                if (contact == null) {
                    System.out.println("Обнаружен null контакт!");
                    continue;
                }
                String contactString = contact.toString();
                writer.write(contactString);
                writer.newLine();
            }
            System.out.println("Контакты успешно сохранены в файл: " + filename);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());

        }

    } catch (Exception e) {
        System.out.println("Ошибка: " + e.getMessage());

    }
}

public static List<Contact> loadContactsFromFile(String filename) {
        List<Contact> contacts = new ArrayList<>();
        File file = new File(filename);

        if (!file.exists()) {
            System.out.println(" --------------------------------------------------------------\n" +
                    "|                 Файл " + filename + " не найден." +          "|\n" +
                    " ----------------------------------------------------------------\n");
            return contacts;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            contacts = (List<Contact>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(" --------------------------------------------------------------\n" +
                    "|  Ошибка при загрузке контактов из файла: " + e.getMessage() +"|\n" +
                    " ----------------------------------------------------------------\n");
            System.out.println(" --------------------------------------------------------------\n" +
                    "|                  Создан новый список контактов.               |\n" +
                    " ----------------------------------------------------------------\n");
        }
        return contacts;
    }

    private static final String LOG_FILE = "activity.log";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static final ThreadLocal<String> currentUser = new ThreadLocal<>();

    public static void setCurrentUser(String username) {
        currentUser.set(username);
    }

    public static void clearCurrentUser() {
        currentUser.remove();
    }

    private static  void log(String action) {
        String username = currentUser.get();

        try (FileWriter fw = new FileWriter(LOG_FILE, true)) {
            String timestamp = LocalDateTime.now().format(DATE_TIME_FORMATTER);
            String logEntry = String.format("%s | %s | %s\n", timestamp, username, action);
            fw.write(logEntry);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        
        }
    }

    public static void logLogin() {
        log("Вход.");
    }

    public static void logLogout() {
        log("Выход.");
        clearCurrentUser();
    }

}



    public class Main {
       
        private static String loggedInUsername = null;
        private static final String DEFAULT_CONTACTS_FILE = "contacts.txt";

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            List<User> users = new ArrayList<>();
            String contactsFile;
            String userFolderPath;
            File userFolder;

            if (loggedInUsername != null) {
                contactsFile = FileManager.getContactFilename(loggedInUsername);
                userFolderPath = FileManager.FOLDER_PATH + "/" + loggedInUsername;
                userFolder = new File(userFolderPath);
                if (!userFolder.exists()) {
                    userFolder.mkdirs();
                }
            } else {
                contactsFile = DEFAULT_CONTACTS_FILE;
                userFolderPath = "default";
                userFolder = new File(userFolderPath);
                if (!userFolder.exists()) {
                    userFolder.mkdirs(); 
                }

            }

            String baseFolderPath = "users";
            FileManager.createFolder(baseFolderPath);

            List<Contact> contacts = FileManager.loadContactsFromFile(contactsFile);
            PhoneBook contactCommand = new PhoneBook(contacts);

            boolean continueRegistration = true;

            while (loggedInUsername == null) {
                System.out.println(" ------------------------------------\n" +
                        "|          Телефонная книга.       |\n" +
                        "|          Добро пожаловать!       |\n" +
                        "|          Выберете действие:      |\n" +
                        "|                                  |\n" +
                        "|            1 - Войти             |\n" +
                        "|                                  |\n" +
                        "|       2 - Зарегистрироваться     |\n" +
                        "|                                  |\n" +
                        "|                                  |\n" +
                        " -----------------------------------\n");
                String choice = scanner.nextLine();

                if (choice.equals("1")) {
                    System.out.println(" ---------------------------------------------------\n" +
                            "|                                                  |\n" +
                            "|                 Введите логин :                  |\n" +
                            " ---------------------------------------------------\n");
                    String login = scanner.nextLine();
                    System.out.println(" ---------------------------------------------------\n" +
                            "|                                                  |\n" +
                            "|                  Введите пароль :                |\n" +
                            " --------------------------------------------------\n");
                    String password = scanner.nextLine();
                    if (FileManager.loginUser(login, password)) {
                        System.out.println(" ---------------------------------------------------\n" +
                                "|                  Вход выполнен!                  |\n" +
                                "|                Добро пожаловать!                 |\n" +
                                " ---------------------------------------------------\n");
                        loggedInUsername = login;
                    } else {
                        System.out.println(" ---------------------------------------------------\n" +
                                "|               Неправильные данные!                |\n" +
                                "|                Попробуйте снова.                  |\n" +
                                " ---------------------------------------------------\n");
                        FileManager.logLogin();

                    }
                } else if (choice.equals("2")) {
                    System.out.println(" ---------------------------------------------------\n" +
                            "|                 Регистрация пользователя!        |\n" +
                            "|                       Введите имя:               |\n" +
                            " ---------------------------------------------------\n");
                    String firstName = scanner.nextLine();
                    System.out.println(" ---------------------------------------------------\n" +
                            "|                                                  |\n" +
                            "|               Введите фамилию :                  |\n" +
                            " ---------------------------------------------------\n");
                    String lastName = scanner.nextLine();
                    System.out.println(" ---------------------------------------------------\n" +
                            "|                                                  |\n" +
                            "|               Введите логин :                    |\n" +
                            " ---------------------------------------------------\n");
                    String username = scanner.nextLine();
                    System.out.println(" ---------------------------------------------------\n" +
                            "|                                                  |\n" +
                            "|                Введите пароль :                  |\n" +
                            " ---------------------------------------------------\n");
                    String password = scanner.nextLine();
                    System.out.println(" ---------------------------------------------------\n" +
                            "|                                                  |\n" +
                            "|               Подтвердите пароль :               |\n" +
                            " ---------------------------------------------------\n");
                    String confirmPassword = scanner.nextLine();

                    if (FileManager.registerUserWithDetails(firstName, lastName, username, password, confirmPassword)) {
                        System.out.println(" ---------------------------------------------------\n" +
                                "|                                                  |\n" +
                                "|                Регистрация прошла успешно!       |\n" +
                                " ---------------------------------------------------\n");
                        loggedInUsername = username;
                        FileManager.createUserFile(username);
                        
                    } else {
                        System.out.println(" ---------------------------------------------------\n" +
                                "|                                                  |\n" +
                                "|               Регистрация не удалась.            |\n" +
                                " ---------------------------------------------------\n");
                    }
                    FileManager.logLogin();
                } else {
                    System.out.println(" ---------------------------------------------------\n" +
                            "|                 Неверный выбор!                  |\n" +
                            "|                Выберите 1 или 2!                 |\n" +
                            " ---------------------------------------------------\n");
                }
            }
            boolean exit = false;


            do {
                System.out.println(" ------------------------------------------------------------------------\n" +
                        "|                                                                     |\n" +
                        "|                              Главное меню                           |\n" +
                        "|                            Выберете действие:                       |\n" +
                        "|                                                                     |\n" +
                        "|                        0- Сохранить и выйти                         |\n" +
                        "|          1 - Открыть меню контактов(добавить,удалить,обновить)      |\n" +
                        "|          2 - Показать (все контакты)                                |\n" +
                        "|        3 - Сортировать(по имени,по фамилии,по номеру телефона)      |\n" +
                        "|    4 - Поиск контакта(по имени,по фамилии, по номеру телефона)      |\n" +
                        "|                                                                     |\n" +
                        " ----------------------------------------------------------------------\n");
                System.out.println();
                Scanner scanner1 = new Scanner(System.in);
                String comand = scanner1.nextLine();

                if (comand.equals("0")) {
                    System.out.println(" ----------------------------------------\n" +
                            "|                 Данные сохранены!                |\n" +
                            "|                   До свидания!                   |\n" +
                            " ---------------------------------------------------\n");
                    FileManager.logLogout();
                    break;

                } else if (comand.equals("1")) {
                    System.out.println(" ------------------------------------------\n" +
                            "|             Меню контактов.               |\n" +
                            "|                                           |\n" +
                            "|          Выберете действие:               |\n" +
                            "|                                           |\n" +
                            "|        1 - Добавить контакт               |\n" +
                            "|        2 - Удалить контакт                |\n" +
                            "|        3 - Обновить контакт               |\n" +
                            "|        4 - Вернуться в главное меню       |\n" +
                            " --------------------------------------------\n");
                    String contactCommand2 = scanner.nextLine();

                    if (contactCommand2.equals("1")) {
                        System.out.println(" -------------------------------------\n" +
                                "|        Добавить контакт.           |\n" +
                                " -------------------------------------\n");
                        PhoneBook.addContact(scanner,contacts);

                    } else if (contactCommand2.equals("2")) {
                        System.out.println(" -----------------------------------------------------------------\n" +
                                "|                                                                  |\n" +
                                "| Удаление контакта (Введите имя или номер контакта для удаления): |\n" +
                                " -------------------------------------------------------------------\n");
                        String delete = scanner.next();
                        contactCommand.deleteContact(delete, contacts);
                    } else if (contactCommand2.equals("3")) {
                        System.out.println(" ----------------------------------------------------------------------------\n" +
                                "|                                                                             |\n" +
                                "|                        Редактирование контакта :                            |\n" +
                                " ------------------------------------------------------------------------------\n");
                        System.out.println(" ----------------------------------------------------------------------------\n" +
                                "|                                                                             |\n" +
                                "|           Введите имя контакта, который хотите отредактировать:             |\n" +
                                " ------------------------------------------------------------------------------\n");
                        String nameToEdit = scanner.nextLine();
                        System.out.println(" ----------------------------------------------------------------------------\n" +
                                "|                                                                             |\n" +
                                "|          Введите фамилию контакта, который хотите отредактировать:          |\n" +
                                " ------------------------------------------------------------------------------\n");
                        String surnameToEdit = scanner.nextLine();
                        System.out.println(" ----------------------------------------------------------------------------\n" +
                                "|                                                                             |\n" +
                                "|   Введите новое имя (или нажмите Enter, чтобы оставить без изменений):      |\n" +
                                " ------------------------------------------------------------------------------\n");
                        String newName = scanner.nextLine();
                        System.out.println(" ----------------------------------------------------------------------------\n" +
                                "|                                                                             |\n" +
                                "|   Введите новую фамилию (или нажмите Enter, чтобы оставить без изменений):  |\n" +
                                " ------------------------------------------------------------------------------\n");
                        String newSurname = scanner.nextLine();
                        System.out.println(" ----------------------------------------------------------------------------------\n" +
                                "|                                                                                   |\n" +
                                "|  Введите новый номер телефона (или нажмите Enter, чтобы оставить без изменений):  |\n" +
                                " ------------------------------------------------------------------------------------\n");
                        String newPhoneNumber = scanner.nextLine();
                        System.out.println(" ----------------------------------------------------------------------------------\n" +
                                "|                                                                                   |\n" +
                                "|                              Введите новый возраст:                               |\n" +
                                " ------------------------------------------------------------------------------------\n");
                        int newAge = scanner.nextInt();
                        scanner.nextLine();
                        PhoneBook.editContact(nameToEdit, surnameToEdit, newName, newSurname, newPhoneNumber, newAge);
                        FileManager.saveContactsToFile(contacts, contactsFile);
                        System.out.println("Изменения сохранены.");
                    } else if (contactCommand2.equals("4")) {
                        System.out.println(" --------------------------------\n" +
                                "|                        |\n" +
                                "| Выход в главное меню : |\n" +
                                " -------------------------\n");

                    } else {
                        System.out.println(" -------------------------\n" +
                                "|                        |\n" +
                                "|     Неверная команда!  |\n" +
                                " -------------------------\n");
                    }
                } else if (comand.equals("2")) {
                    PhoneBook.printAll(contacts);
                } else if (comand.equals("3")) {
                    System.out.println(" ------------------------------------------------\n" +
                            "|                 Меню сортировки.                |\n" +
                            "|                                                 |\n" +
                            "|               Выберете действие:                |\n" +
                            "|                                                 |\n" +
                            "|           1 - Сортировать по имени              |\n" +
                            "|           2 - Сортировать по фамилии            |\n" +
                            "|           3 - Сортировать по номеру телефона    |\n" +
                            "|           4 - Вернуться в главное меню          |\n" +
                            " --------------------------------------------------\n");

                    String sortCommand = scanner.nextLine();
                    if (sortCommand.equals("1")) {
                        System.out.println(" ------------------------------------\n" +
                                "|           Сортировка по имени :        |\n" +
                                "|            1 - От А до Я               |\n" +
                                "|            2 - От Я до А               |\n" +
                                " -----------------------------------------\n");
                        String sort = scanner.nextLine();

                        if (sort.equals("1")) {
                            PhoneBook.sortByName(1, contacts);
                        }
                        if (sort.equals("2")) {
                            PhoneBook.sortByName(2, contacts);
                        }
                    } else if (sortCommand.equals("2")) {
                        System.out.println(" ------------------------------------\n" +
                                "|           Сортировка по фамилии :      |\n" +
                                "|            1 - От А до Я               |\n" +
                                "|            2 - От Я до А               |\n" +
                                " -----------------------------------------\n");
                        String sort = scanner.nextLine();
                        if (sort.equals("1")) {
                            PhoneBook.sortBySurname(1, contacts);
                        }
                        if (sort.equals("2")) {
                            PhoneBook.sortBySurname(2, contacts);
                        }
                    } else if (sortCommand.equals("3")) {
                        System.out.println(" --------------------------------------------\n" +
                                "|           Сортировка по номеру телефона :      |\n" +
                                "|             1 - По возрастанию                 |\n" +
                                "|             2 - По убыванию                    |\n" +
                                " -------------------------------------------------\n");
                        String sort = scanner.nextLine();
                        if (sort.equals("1")) {
                            PhoneBook.sortByPhoneNumber(1, contacts);
                        }
                        if (sort.equals("2")) {
                            PhoneBook.sortByPhoneNumber(2, contacts);
                        }
                    } else if (sortCommand.equals("4")) {
                        System.out.println(" --------------------\n" +
                                "|                        |\n" +
                                "| Выход в главное меню.  |\n" +
                                " -------------------------\n");

                    } else {
                        System.out.println(" ----------------------------------------------\n" +
                                "|                                                  |\n" +
                                "|         Неверная команда для сортировки!         |\n" +
                                " --------------------------------------------------\n");
                    }
                } else if (comand.equals("4")) {
                    System.out.println(" -------------------м-------------------\n" +
                            "|                 Меню поиска                    |\n" +
                            "|                                                |\n" +
                            "|              Выберете действие:                |\n" +
                            "|                                                |\n" +
                            "|           1 - Поиск по имени                   |\n" +
                            "|           2 - Поиск по фамилии                 |\n" +
                            "|           3 - Поиск по номеру телефона         |\n" +
                            "|           4 - Вернуться в главное меню         |\n" +
                            " -------------------------------------------------\n");
                    String searchCommand = scanner.nextLine();

                    if (searchCommand.equals("1")) {
                        System.out.println(" ----------------------------------------------\n" +
                                "|                                                  |\n" +
                                "|                 Поиск по имени :                 |\n" +
                                " ---------------------------------------------------\n");
                        String nameSearch = scanner.nextLine();
                        PhoneBook.interpreterByName(nameSearch, contacts);

                    } else if (searchCommand.equals("2")) {
                        System.out.println(" ----------------------------------------------\n" +
                                "|                                                  |\n" +
                                "|                  Поиск по фамилии :              |\n" +
                                " ---------------------------------------------------\n");
                        String surnameSearch = scanner.nextLine();
                        PhoneBook.interpreterBySurname(surnameSearch, contacts);

                    } else if (searchCommand.equals("3")) {
                        System.out.println(" ----------------------------------------------\n" +
                                "|                                                  |\n" +
                                "|                Поиск по номеру телефона  :       |\n" +
                                " ---------------------------------------------------\n");
                        String numberSearch = scanner.nextLine();
                        PhoneBook.interpreterByPhoneNumber(numberSearch, contacts);

                    } else if (searchCommand.equals("4")) {
                        System.out.println(" ---------------------\n" +
                                "|                        |\n" +
                                "| Выход в главное меню : |\n" +
                                " -------------------------\n");

                    } else {
                        System.out.println(" ----------------------------------------------\n" +
                                "|                                                  |\n" +
                                "|      Неверная команда для поиска контакта!       |\n" +
                                " --------------------------------------------------\n");
                    }

                } else {
                    System.out.println(" ----------------------------------------------\n" +
                            "|                 Неверная команда!                |\n" +
                            "|    Пожалуйста, выберете команду из списка!       |\n" +
                            " --------------------------------------------------\n");
                }
            } while (true);
            FileManager.saveContactsToFile(contacts, contactsFile);
            
        }
    }
