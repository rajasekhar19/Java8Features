package collections;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionsTester {
    public static void main (String[] args) {
        HashSet<String> hashset = new HashSet<>();
        //List<String> hashset = new ArrayList<>();
        // Add elements to HashSet
        hashset.add("Pear");
        hashset.add("Apple");
        hashset.add("Orange");
        hashset.add("Papaya");
        hashset.add("Banana");

        //hashset.stream().forEach(System.out::println);

        //String res = hashset.stream().collect(Collectors.joining(","));
        //System.out.println(res);
        hashset.stream().collect(Collectors.toList())
        .forEach(s -> System.out.println(s));

        Map<String, String> map = new HashMap<>();
        map.put("1", "11");

        System.out.print(map.containsKey("1"));
        System.out.print(map.containsKey("11"));
        System.out.print(map.containsValue("1"));
        System.out.print(map.containsValue("11"));

        String[] cities={"Boston", "Dallas", "New York", "Chicago"};

        //Converting Array to ArrayList using Arrays.asList()
        //ArrayList<String> list= new ArrayList<>(Arrays.asList(cities));
        List<String> list= Arrays.asList(cities);
        list.stream().sorted().forEach(System.out::println);
    }
}
