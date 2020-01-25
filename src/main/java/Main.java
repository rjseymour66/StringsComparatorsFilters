import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {



    public static void main(String[] args) {

        final List<Person> people = Arrays.asList(
                new Person("John", 20),
                new Person("Sarah", 21),
                new Person("Jane", 21),
                new Person("Greg", 35));


        try {

            final Path path = Paths.get(".");
            final WatchService watchService =
                    path.getFileSystem()
                            .newWatchService();

            path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);

            System.out.println("Report any file changes within next 1 minute...");

            final WatchKey watchKey = watchService.poll(1, TimeUnit.MINUTES);

            if(watchKey != null) {
                watchKey.pollEvents()
                        .stream()
                        .forEach(event -> System.out.println(event.context()));

            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }





     //   final File[] files = new File(".").listFiles(file -> file.isHidden());
     // final File[] files = new File(".").listFiles(File::isHidden);



/*
        try {
            Files.newDirectoryStream(
                    Paths.get("../../Functional_Programming_in_Java/collections/fpij"), path -> path.toString().endsWith(".java"))
                    .forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        final String[] files =
                new File("fpij").list(new java.io.FilenameFilter() {
                    public boolean accept(final File dir, final String name) {
                        return name.endsWith(".java");
                    }
                });

        try {
            Files.list(Paths.get("."))
                    .forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Error listing files " + e.getMessage());
        }

        System.out.println("*************************");

        try {
            Files.list(Paths.get("."))
                    .filter(Files::isDirectory)
                    .forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Error listing files " + e.getMessage());
        }
        Comparator<Person> byAge = Comparator.comparing(Person::getAge);
        Map<Character, Optional<Person>> oldestPersonOfEachLetter =
                people.stream()
                        .collect(Collectors.groupingBy(
                                person -> person.getName().charAt(0), Collectors.reducing(BinaryOperator.maxBy(byAge))));
        System.out.println("Oldest person of each letter:");
        System.out.println(oldestPersonOfEachLetter);


        Map<Integer, List<String>> nameOfPeopleByAge =
                people.stream()
                        .collect(
                                Collectors.groupingBy(Person::getAge,
                                        Collectors.mapping(Person::getName,
                                                Collectors.toList())));
        System.out.println("People grouped by age: " + nameOfPeopleByAge);
        Map<Integer, List<Person>> peopleByAge =
                people.stream()
                        .collect(Collectors.groupingBy(Person::getAge));
        System.out.println("Grouped by age: " + peopleByAge);

        List<Person> olderThan20 =
                people.stream()
                        .filter(person -> person.getAge() > 20)
                        .collect(Collectors.toList());
        System.out.println("People older than 20: " + olderThan20);
        List<Person> olderThan20 =
                people.stream()
                        .filter(person -> person.getAge() > 20)
                        .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println("People older than 20: " + olderThan20);

        List<Person> olderThan20 = new ArrayList<>();
        people.stream()
                .filter(person -> person.getAge() > 20)
                .forEach(person -> olderThan20.add( person));
        System.out.println("People older than 20: " + olderThan20);

        // Multiple and fluent comparisons

        // sort people by comparing their names
        final Function<Person, String> byName = person -> person.getName();

        people.stream()
                .sorted(Comparator.comparing(byName));

        final Function<Person, Integer> byAge = person -> person.getAge();
        final Function<Person, String> byTheirName = person -> person.getName();

        Person.printPeople("Sorted in ascending order by age and name: ",
                people.stream()
                        .sorted(Comparator.comparing(byAge).thenComparing(byTheirName))
                        .collect(Collectors.toList()));


        // sort by age
        Comparator<Person> compareAscending =
                (person1, person2) -> person1.ageDifference(person2);

        Comparator<Person> compareDescending = compareAscending.reversed();

        Person.printPeople("Sorted in ascending order:",
                people.stream()
                        .sorted(compareAscending)
                        .collect(Collectors.toList()));
        System.out.println();

        Person.printPeople("Sorted in descending order:",
                people.stream()
                        .sorted(compareDescending)
                        .collect(Collectors.toList()));

        // sort by name
        Person.printPeople("Sorted in ascending order by name:",
                people.stream()
                        .sorted((person1, person2) ->
                                person1.getName().compareTo(person2.getName()))
                        .collect(Collectors.toList()));

        // find youngest
        people.stream()
                .min(Person::ageDifference)
                .ifPresent(youngest -> System.out.println("Youngest: " + youngest));

        // find oldest
        people.stream()
                .max(Person::ageDifference)
                .ifPresent(oldest -> System.out.println("Oldest: " + oldest));


        Person.printPeople("Sorted in descending order by age:",
                people.stream()
                        .sorted((person1, person2) -> person2.ageDifference(person1))
                        .collect(Collectors.toList()));
        List<Person> ascendingAge =
                people.stream()
                        .sorted(Person::ageDifference)
                        .collect(Collectors.toList());
        Person.printPeople("Sorted in ascending order by age: ", ascendingAge);


        final String str = "w00t";


        str.chars()
                .forEach(ch -> System.out.println(ch));

        str.chars()
                .forEach(System.out::println);

        str.chars()
                .forEach(Strings::printChar);

        str.chars()
                .mapToObj(ch -> Character.valueOf((char)ch))
                .forEach(System.out::println);

        System.out.println();

        // filter out digits from stream
        str.chars()
                .filter(ch -> Character.isDigit(ch))
                .forEach(ch -> Strings.printChar(ch));

        System.out.println("*********");

        // using method references
        str.chars()
                .filter(Character::isDigit)
                .forEach(Strings::printChar);

        */
    }
}
