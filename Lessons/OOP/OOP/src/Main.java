//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        //   Создайте класс Person с полями:
        //// name (строка, доступ к полю только внутри класса),  +
        ////age (целое число, доступ только из пакета),          +
        ////email (строка, доступ из любого места),              +
        ////phone (строка, доступ только наследникам класса).    +
        ////
        //// Реализуйте в классе Person:
        ////Конструктор, который инициализирует все поля.       +
        ////Методы для получения значений всех полей (геттеры) с соблюдением их модификаторов доступа.   +
        ////Метод displayInfo(), который выводит имя, возраст и email (может вызываться из любого места). +
        ////Создайте второй класс Employee, который наследуется от класса Person. В этом классе:
        ////
        ////Реализуйте метод для вывода номера телефона (доступен только внутри пакета).
        ////Напишите основной класс Main с методом main, в котором:
        ////
        ////Создайте объект класса Person.
        ////Попробуйте обратиться к каждому из полей напрямую и через методы (проверьте соблюдение модификаторов доступа).
        ////Создайте объект класса Employee и вызовите все доступные методы для проверки наследования и работы с полями.
        class Person {
            private String name;
            int age;
            public String email;
            protected String phone;

            public Person(String name, int age, String email, String phone) {
                this.age = age;
                this.email = email;
                this.phone = phone;
            }


            public String getName() {
                return this.name;
            }

            int getAge() {
                return this.age;
            }

            public String getEmail() {
                return this.email;
            }

            protected String getPhone() {
                return this.phone;
            }

            public void displayInfo() {
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Email: " + email);
            }
        }

        class Employee extends Person {

            public Employee(String name, int age, String email, String phone) {
                super(name, age, email, phone);
            }


            String getPhoneNumber() {
                return phone;
            }
        }


                Person person = new Person("Maria", 21, "maria@mail.ru", "8-918-984-87-77");

                System.out.println("Person class : ");

                System.out.println("Age : " + person.age);

                System.out.println("Email : " + person.email);

                System.out.println("Name : " + person.getName());
                System.out.println("Age : " + person.getAge());
                System.out.println("Email : " + person.getEmail());
                System.out.println("Phone : " + person.getPhone());


                person.displayInfo();


                System.out.println("Employee class : ");
                Employee employee = new Employee("Dasha", 25, "dasha.mail.ru", "8-918-879-89-78");

                System.out.println("Name : " + employee.getName());
                System.out.println("Age : " + employee.getAge());
                System.out.println("Email : " + employee.getEmail());
                System.out.println("Phone : " + employee.getPhone());

                employee.displayInfo();

                System.out.println("Phone number : " + employee.getPhoneNumber());
            }

        }
