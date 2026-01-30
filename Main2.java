import java.util.*;
import java.util.stream.*;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    static boolean isOlderThan(Person p, int limit) {
        return p.age > limit;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int age = sc.nextInt();
            persons.add(new Person(name, age));
        }

        int ageLimit = sc.nextInt();

        persons.stream()
               .sorted(Comparator.comparing(p -> p.name))
               .map(p -> p.name)
               .forEach(name -> System.out.print(name + " "));
        System.out.println();

        persons.stream()
               .filter(p -> Person.isOlderThan(p, ageLimit))
               .map(p -> p.name)
               .forEach(name -> System.out.print(name + " "));
        System.out.println();

        persons.stream()
               .map(Person::getName)
               .map(String::toUpperCase)
               .forEach(name -> System.out.print(name + " "));
    }
}

