package StreamPersonExample;

import java.util.Arrays;
import java.util.List;

public class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static List<Person> personList(){
        List<Person> persons =
                Arrays.asList(
                        new Person("Max", 18),
                        new Person("Peter", 23),
                        new Person("Pamela", 23),
                        new Person("David", 120));

        return persons;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name;
    }
}

