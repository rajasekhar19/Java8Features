package com.lambda;

import dto.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReduceTester {
    public static void main (String[] args) {
        Person p1 = new Person("Raja", "G", 41);
        Person p2 = new Person("Raja", "E", 43);
        Person p3 = new Person("Anitha", "A", 36);
        Person p4 = new Person("Nidhi", "G", 11);
        Person p5 = new Person("Sekhar", "G", 41);

        List<Person> pers = new ArrayList<>();
        pers.add(p1);
        pers.add(p2);
        pers.add(p3);
        pers.add(p4);
        pers.add(p5);
        String res = pers.stream()
                .filter(person -> person.getAge() > 20)
                .map(person -> person.getlName())
                .collect(Collectors.joining(","));
        System.out.println(res);

        List<Person> lst = pers.stream().collect(Collectors.toList());
        System.out.println("Collecting all persons with out filter");
        lst.stream().forEach(person -> System.out.println(person.getfName()));

        System.out.println("Collecting filtered persons");
        List<Person> lst1 = pers.stream()
                        .filter(person -> person.getAge() > 20)
                 //               .map()
                .collect(Collectors.toList());
        lst1.stream().forEach(person -> System.out.println(person.getfName()));

        System.out.println("Collecting filtered persons in map");

        Map<Integer, List<Person>> perMap = pers.stream()
                .filter(person -> person.getAge() > 20)
                .collect(Collectors.groupingBy(Person::getAge));
        perMap.forEach((key, value) -> System.out.println(value));

        System.out.println("Down stream collector");
        Map<Integer, Long> dwnMap = pers.stream()
                .filter(person -> person.getAge() > 20)
                .collect(Collectors.groupingBy(
                        Person :: getAge, Collectors.counting()));
        dwnMap.forEach((key, value) -> System.out.println(value));

     }

}
