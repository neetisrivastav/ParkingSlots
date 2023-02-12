package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class shalloCopy {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        Set<String> set2 = set;
        set.add("Ankita");
        set.add("Harshit");
        set.add("Kiara");

        Iterator<String> itr = set2.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
