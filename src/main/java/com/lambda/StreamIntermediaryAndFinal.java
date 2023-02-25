package com.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamIntermediaryAndFinal {
    public static void main(String[] args) {
        Stream<String> strm1 = Stream.of("one","two", "three", "four");
        List<String> list = new ArrayList<>();
        Predicate<String> p1 = s -> s.length() > 3;
        Predicate<String> p2 = s -> s.equals("two");
        Predicate<String> p3 = Predicate.isEqual("three");

        /*strm1   .peek(System.out::println)
                .filter(p2.or(p3))
                .peek(list :: add);
        System.out.println("Done");
        System.out.println(list.size());  //o/p : 0*/

        strm1   .peek(System.out::println)
                .filter(p2.or(p3))
                .forEach(list::add);
        System.out.println("Done");
        System.out.println(list.size());  //o/p : 2

    }
}
