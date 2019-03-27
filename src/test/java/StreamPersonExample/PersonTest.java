package StreamPersonExample;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

public class PersonTest {

    Person person ;

    @Test
    public void testPersonListFilter() {
       Set<Person> persons =  person.personList()
                .stream()
                .filter(b -> b.name.startsWith("P"))
                //.forEach(System.out::println);
                .collect(Collectors.toSet());
       System.out.println(persons);

        List<Person> expected = Arrays.asList(person.personList().get(1),person.personList().get(2));

        System.out.println(expected);

        Assert.assertEquals(persons,expected);
    }

    @Test
    public void testGroupingPersonsByAge(){

        Map<Integer,List<Person>> personsAge = person.personList()
                .stream()
                .collect(Collectors.groupingBy(p -> p.age));

        personsAge.forEach((age, p) -> System.out.format("age %s: %s\n", age, p));
    }
    @Test
    public void testAvarageAgeOfPersons(){
        Double avg =  person.personList()
                .stream()
                .collect(Collectors.averagingInt(p -> p.age));

        //System.out.println(avg);     // 19.0

        Assert.assertEquals(avg,19.0);
    }

    @Test
    public void testSummarizingReport(){
        IntSummaryStatistics ageSummary = person.personList()
                .stream()
                .collect(Collectors.summarizingInt(p -> p.age));
        System.out.println(ageSummary);
    }
    @Test
    public void joinsAllPersons2SingleString(){
        String phrase = person.personList().stream()
                .filter(p -> p.age >= 18)
                .map(p -> p.name)
                .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));

        System.out.println(phrase);
// In Germany Max and Peter and Pamela are of legal age.
    }

    @Test
    public void transformStreamToMap(){
        Map<Integer, String> map =  person.personList()
                .stream()
                .collect(Collectors.toMap(
                        p -> p.age,
                        p -> p.name,
                        (name1, name2) -> name1 + ";" + name2));

        System.out.println(map);
// {18=Max, 23=Peter;Pamela, 12=David}

    }

    @Test
    public void reduceFunctionForPerson(){
        Optional<Person> reduced = person.personList()
                .stream()
                .reduce((p1, p2) -> p1.age > p2.age ? p1 : p2);

        Assert.assertEquals(reduced.get().name,"David");
        reduced.ifPresent(System.out::println);

    }


}