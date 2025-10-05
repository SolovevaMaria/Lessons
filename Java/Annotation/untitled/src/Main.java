import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Задания по Аннотациям и Reflection
// Задание 1: Аннотация для валидации возраста
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
 @interface MinAge {
    int value();
}

class AgeValidator {
    public static void validate(Object object) throws IllegalArgumentException {
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);

            if (field.isAnnotationPresent(MinAge.class)) {
                MinAge minAge = field.getAnnotation(MinAge.class);
                try {
                    int age = field.getInt(object);
                    if (age < minAge.value()) {
                        throw new IllegalArgumentException(
                                "Возраст должен быть не менее " + minAge.value()
                        );
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

// Задание 2: Аннотация для логирования параметров
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
 @interface LogParameters {
}

class LogAspect {
    public static Object createProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (method.isAnnotationPresent(LogParameters.class)) {
                            StringBuilder params = new StringBuilder();
                            Parameter[] parameters = method.getParameters();

                            for (int i = 0; i < args.length; i++) {
                                if (i > 0) params.append(", ");
                                params.append(parameters[i].getName())
                                        .append("=")
                                        .append(args[i]);
                            }

                            System.out.println("Method: " + method.getName() +
                                    ", Parameters: [" + params.toString() + "]");
                        }

                        return method.invoke(target, args);
                    }
                }
        );
    }
}

// Задание 3: Аннотация для подсчета вызовов
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
 @interface CountCalls {
}

class CallCounter {
    private static final ConcurrentHashMap<Method, Integer> callMap =
            new ConcurrentHashMap<>();

    public static Object countAndInvoke(Object proxy, Method method, Object[] args)
            throws Throwable {

        if (method.isAnnotationPresent(CountCalls.class)) {
            int count = callMap.getOrDefault(method, 0) + 1;
            callMap.put(method, count);

            System.out.println("Method " + method.getName() +
                    " called " + count + " time(s)");
        }

        return method.invoke(proxy, args);
    }
}

class User {
    private int age;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

interface UserService {
    void createUser(String name, int age);

    void processData();
}

class UserServiceImpl implements UserService {
    @LogParameters
    @Override
    public void createUser(String name, int age) {
        System.out.println("Пользователь создан: " + name + ", возраст: " + age);
    }

    @CountCalls
    @Override
    public void processData() {
        System.out.println("Данные обработаны");
    }
}


//Задания по Regex
  class RegexTasks {

    // Задание 1: Извлечение email-адресов
    public static void extractEmails(String text) {
        String emailPattern = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(text);

        List<String> emails = new ArrayList<>();

        while (matcher.find()) {
            emails.add(matcher.group());
        }

        System.out.println("Найденные email-адреса:");
        for (String email : emails) {
            System.out.println(email);
        }
    }

    // Задание 2: Валидация номера телефона
    public static boolean isValidPhone(String phone) {
        String phonePattern = "^(\\+7|8)\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$";
        return phone.matches(phonePattern);
    }

    // Задание 3: Замена цензурных слов
    public static String censorText(String text) {
        String[] badWords = {"bad", "ugly", "stupid"};

        String pattern = String.join("|", badWords);

        return text.replaceAll("(?i)(" + pattern + ")", "***");
    }
}

    public class Main {
        public static void main(String[] args) {

            try {
                User user = new User();
                user.setAge(16);
                AgeValidator.validate(user);
                System.out.println("Пользователь успешно валидирован");
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка валидации возраста: " + e.getMessage());
            }

            UserService service = (UserService) LogAspect.createProxy(new UserServiceImpl());
            service.createUser("John", 25);
            service.createUser("Alice", 30);

            try {
                Method method = UserServiceImpl.class.getMethod("processData");
                UserServiceImpl processor = new UserServiceImpl();


                CallCounter.countAndInvoke(processor, method, new Object[0]);
                CallCounter.countAndInvoke(processor, method, new Object[0]);
                CallCounter.countAndInvoke(processor, method, new Object[0]);
            } catch (Throwable e) {
                e.printStackTrace();
            }

            //Задания по Regex
            //  1
            String emailText = "Контакты: ivan@mail.ru, support@company.com и admin@site.org";
            RegexTasks.extractEmails(emailText);

            System.out.println("\n---\n");

            //  2
            String phone1 = "+7(999)123-45-67";
            String phone2 = "8(812)555-12-34";
            String phone3 = "123-456";

            System.out.println("Валидация телефонов:");
            System.out.println(phone1 + " -> " + RegexTasks.isValidPhone(phone1)); // true
            System.out.println(phone2 + " -> " + RegexTasks.isValidPhone(phone2)); // true
            System.out.println(phone3 + " -> " + RegexTasks.isValidPhone(phone3)); // false

            System.out.println("\n---\n");

            //  3
            String text = "This is bad and ugly code, very stupid!";
            String censoredText = RegexTasks.censorText(text);

            System.out.println("Исходный текст: " + text);
            System.out.println("Цензурный текст: " + censoredText);
        }
    }

