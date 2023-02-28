package Java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AssendingOrderGreaterThanFourComparator {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(23, 4, 6, 8, 9, 12, 10,23);
        Predicate<Integer> predicate = t -> t > 4;
        list.stream().filter(t->t>4).sorted(Collections.reverseOrder()).distinct().forEach(System.out::println);
        list.stream().filter(t->t>4).sorted(Collections.reverseOrder()).distinct().max(Integer::compare).get();
        int sum = list.stream().filter(t -> t > 4).sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).sum();
        //or
        list.stream().collect(Collectors.summingInt(Integer::intValue));
        //or
        list.stream().reduce(0, Integer::sum);
//or
        list.stream().reduce(0,(a,b)->a+b);
        System.out.println(sum);
        //Find the smallest positive number missing from an unsorted array | Set 1
        int array[] = {2, 3, 7, 6, 8, -1, -10, 15};
        int min = Arrays.stream(array).filter(i -> i >= 0).min().orElse(0);
        System.out.println(min);
    }
}

