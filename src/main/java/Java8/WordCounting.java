package Java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordCounting {

    public static void main(String[] args) {

         //String str[] = {"hello", "remo", "Ankita", "Ankita", "hello", "hello"};
      List<String> list = Arrays.asList("hello", "remo", "Ankita", "Ankita", "hello", "hello");
////
        Map<String,Long> set= list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(set);

        //or
        Set<String> set1 = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toSet());
        System.out.println(set);
//
//        System.out.println(collect);
//
//        System.out.println(collect);
//        Map<String, Integer> map = new HashMap<String,Integer>();
//
//        for(int i =0; i<str.length; i++)
//        {
//            map.put(str[i],map.getOrDefault(str[i],1));
//        }
//
//        for(Map.Entry<String,Integer> map1: map.entrySet())
//        {
//            if(map1.get==1)
//            {
//                System.out.println();
//            }
//        }
//    }

        //first non repetitive character
//       String s = "helloeha";
//       Map<Character,Integer> map = new HashMap<>();
//       for(Character chr: s.toCharArray())
//       {
//           map.put(chr, map.getOrDefault(chr,0)+1);
//       }

     //  System.out.println(map.entrySet().stream().filter(x -> x.getValue() == 1).findFirst().get().getKey());
//        for(Map.Entry<Character,Integer> map1: map.entrySet())
//        {
//            if(map1.getValue()==1)
//            {
//                System.out.println(map1.getKey());
//                break;
//            }
//        }
//
//        int amp = -1;
//        char gh = ' ';
//        for (char i : s.toCharArray()) {
//            if (s.indexOf(i) == s.lastIndexOf(i)) { //
//                gh = i;
//                break;
//            } else {
//                amp = amp + 1;
//            }
//        }
//
//        if (amp == 1) {
//            System.out.println("repeating");
//        } else {
//            System.out.println("non repeating character: "+gh);
//        }


        String name ="Hackerearth";
        for(int i =0; i<name.length();i++)
        {
            System.out.println(name.charAt(i+1));
        }
    }
}
