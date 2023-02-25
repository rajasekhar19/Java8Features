package com.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class FlatMapExample {
    public static void main(String[] args) {
        List<Integer> lst1 = Arrays.asList(1,2,3,4,5,6,7);
        List<Integer> lst2 = Arrays.asList(2,4,6);
        List<Integer> lst3 = Arrays.asList(3,5,7);

        List<List<Integer>> list = Arrays.asList(lst1, lst2,lst3);
        System.out.println(list); //prints the content of list

        //lets build a stream .. which prints size of each sub list as 7,3,3
        /*list.stream().map(l -> l.size())
                .forEach( System.out::println);*/
        //we can write map expression as Function
        Function<List<?>, Integer> size = List::size;
        /*list.stream().map(size)
                .forEach( System.out::println);*/
        //build a Function for flat map.
        Function<List<Integer>, Stream<Integer>> flatMapper =
                l -> l.stream();
        list.stream().map(flatMapper)
                .forEach( System.out::println); // returns stream of streams

        System.out.println("-----------------");

        //if we use flatMap method then it flattens the streams and prints
        //i.e the integers in each 3 streams will be flattened as one stream.
        list.stream().flatMap(flatMapper)
                .forEach( System.out::println);
        System.out.println("-----------------");


    }
}
