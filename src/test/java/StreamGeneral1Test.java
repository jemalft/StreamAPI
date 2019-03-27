import StreamPersonExample.Person;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class StreamGeneral1Test {


    @Test
    public void filteringStreams(){
       List<String> fiteredValue =  StreamGeneral1.stringCollection().stream()
                .filter((s) -> s.startsWith("a"))
                .collect(Collectors.toList());
               // .forEach(System.out::println);

        System.out.println(fiteredValue);

        Assert.assertEquals(Arrays.asList("aaa2","aaa1"),fiteredValue);

    }

    @Test
    public void sortingStreams(){
        List<String> sortedValue = StreamGeneral1.stringCollection().stream()
                .sorted()
                .filter((s) -> s.startsWith("a"))
                .collect(Collectors.toList());
               // .forEach(System.out::println);
        System.out.println(sortedValue);
        Assert.assertEquals(sortedValue,Arrays.asList("aaa1","aaa2"));

        // "aaa1", "aaa2"

    }


    @Test
    public void mappingStreams(){
       List<String> mappedValue =  StreamGeneral1.stringCollection().stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> b.compareTo(a))
                .collect(Collectors.toList());
                //.forEach(System.out::println);
        System.out.println(mappedValue);
        Assert.assertEquals(mappedValue,Arrays.asList("DDD2", "DDD1", "CCC", "BBB3", "BBB2", "BBB1","AAA2", "AAA1"));

        // "DDD2", "DDD1", "CCC", "BBB3", "BBB2", "AAA2", "AAA1"

    }

    @Test
    public void machingStreamsanyMatch(){
        // matching

        boolean anyStartsWithA = StreamGeneral1.stringCollection()
                .stream()
                .anyMatch((s) -> s.startsWith("a")); // true

        Assert.assertTrue(anyStartsWithA);
    }

    @Test
    public void machingStreamsanyallMatch(){
        boolean allStartsWithA = StreamGeneral1.stringCollection()
                .stream()
                .allMatch((s) -> s.startsWith("a")); // false

        Assert.assertFalse(allStartsWithA);
    }

    @Test
    public void machingStreamsAnynoneMatch(){
        boolean noneStartsWithZ = StreamGeneral1.stringCollection()
                .stream()
                .noneMatch((s) -> s.startsWith("z"));
        Assert.assertTrue(noneStartsWithZ); // true

    }

    @Test
    public void countingStreams() {
        long startsWithB = StreamGeneral1.stringCollection()
                .stream()
                .filter((s) -> s.startsWith("b"))
                .count();

        Assert.assertEquals(startsWithB,3);

    }

    @Test
    public void reducingStreams() {

        Optional<String> reduced =
                StreamGeneral1.stringCollection()
                        .stream()
                        .sorted()
                        .reduce((s1, s2) -> s1 + "#" + s2);

        Assert.assertEquals(reduced.get(),"aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2");

        reduced.ifPresent(System.out::println);
        // "aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2"
    }



}