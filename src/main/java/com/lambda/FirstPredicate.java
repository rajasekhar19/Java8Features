package com.lambda;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class FirstPredicate {
    public static void main(String[] args) {
        Stream<String> strm1 = Stream.of("one","two", "three", "four");

        Predicate<String> p1 = s -> s.length() > 3;
        Predicate<String> p2 = s -> s.equals("two");
        Predicate<String> p3 = Predicate.isEqual("three");

        strm1
                .filter(p2.or(p3))
                .forEach( s -> System.out.println(s));
    }

}
