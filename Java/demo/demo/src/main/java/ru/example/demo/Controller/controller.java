
@RestController
@RequestMapping("/api/test")
public class HomeController {
    private List<Person> people;
    private List<String> list;

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    public HomeController() {
        people = new ArrayList<>();
        people.add(new Person("Farid", "Abdullayev", 29));
        people.add(new Person("Oleq", "Qazmanov", 74));
        people.add(new Person("Dima", "Bilan", 48));

        list = new ArrayList<>();
        list.add("Farid");
        list.add("Oleq");
        list.add("Dima");
    }

    @GetMapping("/hi")
    public String test() {
        logger.info("Метод test вызван");
        return "Hello world!";
    }

    @GetMapping("/add")
    public boolean add(@RequestParam(name = "name") String name) {
        if (name != null && !name.isEmpty()) {
            return list.add(name);
        }
        return false;
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestParam(name = "id") int id) {
        if (id >= 0 && id < list.size()) {
            list.remove(id);
            return true;
        }
        return false;
    }

    @PutMapping("/edit")
    public boolean edit(@RequestParam(name = "id") int id,
                        @RequestParam(name = "newName") String newName) {
        if (id >= 0 && id < list.size() && newName != null && !newName.isEmpty()) {
            list.set(id, newName);
            return true;
        }
        return false;
    }

    @GetMapping("/getAll")
    public List<String> getAll() {
        return list;
    }
}

class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
