package com.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ChainConsumer {
    public static void main(String[] args) {
        List<String> lstNames = Arrays.asList("Raja", "Sekhar", "reddy");
        List<String> result = new ArrayList<>();
        Consumer<String> csmr1 = System.out :: println;

        lstNames.forEach(csmr1);
        System.out.println("-------------------------");
        //chaining.
        //Consumer<String> csmr2 = s -> result.add(s);
        //Consumer<String> csmr2 = result :: add;

        Consumer<String> csmr2 = (lstNames1) -> result.addAll(lstNames);

        lstNames.forEach(csmr1.andThen(csmr2));
        System.out.println(result.size());
        System.out.println("-------------------------");
        //result.forEach(System.out::println);
        result.forEach(csmr2);
    }
}
