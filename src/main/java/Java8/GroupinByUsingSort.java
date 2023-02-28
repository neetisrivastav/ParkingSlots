package Java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupinByUsingSort {
    //3 apple, 2 banana, others 1
    public static void main(String[] args) {
        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");

        Set<String> numbersWithoutDups = items.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toSet());
        System.out.println(numbersWithoutDups);
        Map<String,Long> map =items.stream().sorted().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        System.out.println(map);

//        Set<String> result =
//                items.stream().collect(
//                        Collectors.groupingBy(
//                                Function.identity(), Collectors.counting()
//                        )
//                ).keySet();
//
//        Set<String> finalMap = new LinkedHashSet<>();
//
//        //Sort a map and add to finalMap
//        result.stream()
//                .sorted().forEachOrdered(e -> finalMap.add);
//
//        System.out.println(result);
    }
}
