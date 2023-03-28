package collection;

//https://www.w3resource.com/java-exercises/collection/index.php

import java.util.*;

//convert a hash set to an array
public class MiscCollectionPractiice {


    public static void main(String[] args) {
//*******************Convert a hash set to a String Array*************************

        // Create a empty hash set
        HashSet<String> h_set = new HashSet<String>();
        // use add() method to add values in the hash set
        h_set.add("Red");
        h_set.add("Green");
        h_set.add("Black");
        h_set.add("White");
        h_set.add("Pink");
        h_set.add("Yellow");
        System.out.println("Original Hash Set: " + h_set);
        // Creating an Array
        String[] new_array = new String[h_set.size()];
        h_set.toArray(new_array);

        // Displaying Array elements
        System.out.println("Array elements: ");
        for (String element : new_array) {
            System.out.println(element);
        }

//*******************Convert a hash set to a tree set*************************
        Set<String> tree_set = new TreeSet<String>(h_set);

        // Display TreeSet elements
        System.out.println("TreeSet elements: ");
        for (String element : tree_set) {
            System.out.println(element);
        }

//**************Convert a hash set to a List/ArrayList********************
        // Create a List from HashSet elements
        List<String> list = new ArrayList<String>(h_set);

        // Display ArrayList elements
        System.out.println("ArrayList contains: " + list);

//*********remove the element**************
        h_set.clear();
//**************Compare two HashSet********************

        // Create a empty hash set
        HashSet<String> h_set1 = new HashSet<String>();
        // use add() method to add values in the hash set
        h_set1.add("Red");
        h_set1.add("Green");
        h_set1.add("Black");
        h_set1.add("White");

        HashSet<String> h_set2 = new HashSet<String>();
        h_set2.add("Red");
        h_set2.add("Pink");
        h_set2.add("Black");
        h_set2.add("Orange");
        //comparison output in hash set
        HashSet<String> result_set = new HashSet<String>();
        for (String element : h_set1) {
            System.out.println(h_set2.contains(element) ? "Yes" : "No");
        }


//********************Create a reverse order view of the elements contained in a given tree set***********

        TreeSet<String> t_set = new TreeSet<String>();
        // use add() method to add values in the tree set
        t_set.add("Red");
        t_set.add("Green");
        t_set.add("Black");
        t_set.add("Pink");
        t_set.add("orange");
        // print original list
        System.out.println("Original tree set:" + t_set);
        Iterator it = t_set.descendingIterator();
        // Print list elements in reverse order
        System.out.println("Elements in Reverse Order:");
        while (it.hasNext()) {
            System.out.println(it.next());
        }
//*********Get the first and last elements in a tree set****************
        Object first_element = t_set.first();
        System.out.println("First Element is: " + first_element);

        // Find last element of the tree set
        Object last_element = t_set.last();
        System.out.println("Last Element is: " + last_element);

//*********Clone a tree set list to another tree set****************
        TreeSet<String> new_t_set = (TreeSet<String>) t_set.clone();
        System.out.println("Cloned tree list: " + t_set);

        TreeSet <Integer>tree_num = new TreeSet<Integer>();
        TreeSet <Integer>treeheadset = new TreeSet<Integer>();

           // Add numbers in the tree
           tree_num.add(10);
           tree_num.add(22);
           tree_num.add(36);
           tree_num.add(25);
           tree_num.add(16);
           tree_num.add(70);
           tree_num.add(82);
           tree_num.add(89);
           tree_num.add(14);



//************Get the element in a tree set which is greater than or equal to the given element
       System.out.println("Greater than or equal to 86 : " + tree_num.ceiling(86));
        System.out.println("Greater than or equal to 29 : " + tree_num.ceiling(29));

//************Get an element in a tree set which is strictly greater than the given element

       System.out.println("Strictly greater than 76 : "+tree_num.higher(76));
       System.out.println("Strictly greater than 31 : "+tree_num.higher(31));

 //************Retrieve and remove the first element of a tree set****************
      System.out.println("Removes the first(lowest) element: "+tree_num.pollFirst());
     System.out.println("Tree set after removing first element: "+tree_num);

 //************Remove a given element from a tree set****************
       System.out.println("Removes 70 from the list: "+tree_num.remove(70));
       System.out.println("Tree set after removing last element: "+tree_num);
    }
}