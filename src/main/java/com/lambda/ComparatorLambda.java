package com.lambda;

import java.util.*;
import java.util.function.Predicate;

public class ComparatorLambda {
    public static void main (String[] args) {
        /*Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        };*/
    //Lambda
        Comparator<String> comparator = (String s1, String s2) ->
                Integer.compare(s2.length(), s1.length());

        List<String> lstStr = Arrays.asList("***","*","****","**");
        Collections.sort(lstStr, comparator);

        /*for(String s : lstStr) {
            System.out.println(s);
        }*/


        Map<String, String> m = new HashMap<>();

        System.out.println(m.putIfAbsent("a", "A"));
        m.put("b", "B");
        System.out.println(m.putIfAbsent("a", "C"));
        m.forEach((k,v) -> System.out.println(v));
    }

}
