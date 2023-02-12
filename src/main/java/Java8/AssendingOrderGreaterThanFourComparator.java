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
        int sum = list.stream().filter(t -> t > 4).sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).sum();
        //or
        list.stream().collect(Collectors.summingInt(Integer::intValue));
        //or
        list.stream().reduce(0, Integer::sum);
        System.out.println(sum);
    }
}

