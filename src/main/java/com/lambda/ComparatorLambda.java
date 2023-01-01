package com.lambda;

import java.util.*;

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
                Integer.compare(s1.length(), s2.length());
        List<String> lstStr = Arrays.asList("***","*","****","**");
        Collections.sort(lstStr, comparator);

        for(String s : lstStr) {
            System.out.println(s);
        }

    }

}
