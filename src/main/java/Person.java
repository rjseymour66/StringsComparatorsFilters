import java.util.List;

public class Person {

    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String getName() { return name; }

    public int getAge() { return age; }

    public int ageDifference(final Person other) {
        return age - other.age;
    }
    public static void printPeople(
            final String message, final List<Person> people) {
        System.out.println(message);
        people.forEach(System.out::println);
    }

    public String toString() {
        return String.format("%s - %d", name, age);
    }
}
