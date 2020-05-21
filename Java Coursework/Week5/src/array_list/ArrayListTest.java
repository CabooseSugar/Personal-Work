package array_list;

import java.util.*;

public class ArrayListTest {

    public static void main(String[] args) {

        /*
            Array List
         */

        // array list of type object
        ArrayList boringCollection = new ArrayList();

        // array list of type integer
        // ArrayList<Integer> awesomeCollection = new ArrayList<>(Integer);
        // ArrayList<Integer> awesomeCollection = new ArrayList<>();
        List<Integer> awesomeCollection = new ArrayList<>(); // ^ all do same thing, instantiates array lists
        List<String> myStack = new Stack<>();               // List includes ArrayList, stacks...
        List<Integer> myLinkedList = new LinkedList<>();    // ... and linked lists
                                                            // List is what is known as a "collection class"
        // Another collection class is Set - List is ordered w/ duplicates, Set is unordered without duplicates

        //
        // basic list operations
        awesomeCollection.add(4);
        awesomeCollection.add(2); // can use Shift+Control+Arrow keys to rearrange lines of code to mix these up
        awesomeCollection.add(1);
        awesomeCollection.add(5);
        awesomeCollection.add(3);

        System.out.println("BEFORE SORT: ");
        printList(awesomeCollection);
        Collections.sort(awesomeCollection); // Collections refers to and does stuff with any collection class(?)
        System.out.println("AFTER SORT: ");
        //printList(awesomeCollection);
        printList2(awesomeCollection);

        //
        // deep copy of array List is easy:
        List<Integer> myAwesomeCollectionCopy = new ArrayList<>(awesomeCollection);

    }

    private static void printList(List<Integer> awesomeCollection) {
       // for (int i = 0; i < awesomeCollection.size(); i++)
        // System.out.println(awesomeCollection.get(1) + " ");
        for (Integer integer : awesomeCollection) // : represents "in"
            System.out.println(integer + " ");
        System.out.println();

    }

    private static void printList2(List<Integer> awesomeCollection) {
        awesomeCollection.stream().forEach(i -> System.out.print(i + " "));
        System.out.println();
    }
}
