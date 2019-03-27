package LambdaBasic;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareLambda {


    // lamda expression is an instance of anounymous class
    // Type of lamda express is a functional interface (interface with 1 abstract method )
    //
    public static void main(String[] args) {

       /* Comparator<String> comp = new Comparator<String>() {

            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        }; */


        Comparator<String> complambda = (String s0, String s1) -> Integer.compare(s0.length(), s1.length());

        List<String> list = Arrays.asList("***","**","****","*","*****","******");
        Collections.sort(list,complambda);

        for(String s : list){
            System.out.println(s);
        }

    }
}
