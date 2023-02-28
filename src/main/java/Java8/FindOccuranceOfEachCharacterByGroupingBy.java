package Java8;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

//WAP using stream to find freq of each character in a given string?
public class FindOccuranceOfEachCharacterByGroupingBy {
    public static void main(String[] args) {
        String input = "Basanta";
//        Map<String, Long> collect = Arrays.stream(input.split("")).
//                collect(groupingBy(Function.identity(), Collectors.counting()));
//        System.out.println(collect);


        List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orang", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );

        //group by price
        Map<BigDecimal, List<Item>> groupByPriceMap =
                items.stream().collect(Collectors.groupingBy(Item::getPrice));

        System.out.println(groupByPriceMap);

        // group by price, uses 'mapping' to convert List<Item> to Set<String>
        Map<String, Set<BigDecimal>> result =
                items.stream().collect(
                        Collectors.groupingBy(Item::getName,
                                Collectors.mapping(Item::getPrice, Collectors.toSet())
                        )
                );

        System.out.println(result);
    }
}

 class Item {

    private String name;
    private int qty;
    private BigDecimal price;

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public int getQty() {
         return qty;
     }

     public void setQty(int qty) {
         this.qty = qty;
     }

     public BigDecimal getPrice() {
         return price;
     }

     public void setPrice(BigDecimal price) {
         this.price = price;
     }

     public Item(String name, int qty, BigDecimal price) {
         this.name = name;
         this.qty = qty;
         this.price = price;
     }

     //constructors, getter/setters
}