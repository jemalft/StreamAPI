import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.testng.Assert.*;

public class StreamExamplesTest {
    StreamExamples streamExamples;

    @Test
    public void validateStreamSize_of_streamed_lists(){
        streamExamples = new StreamExamples();


        Assert.assertEquals(Arrays.asList(7,3,3),streamExamples.list.stream()
               .map(l -> l.size())
               .collect(Collectors.toList()));
    }


    @Test
    public void validateStringMapCollect(){

        List<String> myList = Stream.of("a", "b")
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        assertEquals(Arrays.asList("A", "B"), myList);
    }

    @Test
    public void streamOfArray(){
        streamExamples = new StreamExamples();


        Stream<List<Integer>> list = Stream.of(streamExamples.list1,streamExamples.list2,streamExamples.list3);
        //list.map(l -> l.size())
         //       .collect(Collectors.toList());

        Assert.assertEquals(list.map(l -> l.size())
                .collect(Collectors.toList()), Arrays.asList(7,3,3));

    }

}