package exercise6;

// sort first without deleting repeat entries

import java.util.ArrayList;

public class IntList {
    public static void main(String[] args) {
        int data[] = {-8, -5, 0, 1, -5, 0, 9, 2, 7, 3, -4, 2, -5, -8, 9, 9};
        int data2[] = {8,8,0, -4, -7, -4, 4, 3, 2, 1, 0, 0, -5, -3, 9, 1, 2};

        IntList test = new IntList(data);
        IntList test2 = new IntList(data2);

        test.printList();
        System.out.println("\n");
        test2.printList();
    }

    // INSTANCE DATA
    private int arr[];

    // CONSTRUCTOR
    public IntList(int[] arr) {
        this.arr = arr;
    }

    // MUTATOR METHODS
    // sorts array from smallest to biggest number and returns the result in a new array, doesn't remove any elements,
    // used by occurrenceCounter and shortenArray methods
    private int[] sortArray() {
        int temp;
        int sortedArr[] = this.arr;

        for (int i = 0; i < sortedArr.length - 1; i++)
            for (int j = i + 1; j < sortedArr.length; j++)
                if (sortedArr[i] < sortedArr[j]) {
                    temp = sortedArr[i];
                    sortedArr[i] = sortedArr[j];
                    sortedArr[j] = temp;
                }

        return sortedArr;
    }

    // Puts the number of occurrences of numbers in the sorted array in a separate array
    // that corresponds to the array created by shortenArray, and returns it
    private int[] occurrenceCounter() {
        int occurrences = 1;
        int occPosition = 0;
        int sortedArr[] = sortArray();
        ArrayList<Integer> shortenedArr = shortenArray(); // used to get size for occurrenceArray
        int occurrenceArray[] = new int[shortenedArr.size()];

        for (int i = 0; i < sortedArr.length; i++) {
            if (i == sortedArr.length - 1) {                    // this "if" has to be here because "else if" will count occurrences to the
                occurrenceArray[occPosition] = occurrences;     // last number, but won't trigger the else statement to put result into the
                occPosition++;                                  // occurrenceArray before exiting the for loop otherwise.
            } else if (sortedArr[i + 1] == sortedArr[i]) {
                occurrences++;
            } else {
                occurrenceArray[occPosition] = occurrences;
                occPosition++;
                occurrences = 1;
            }
        }

        return occurrenceArray;
    }

    // Removes redundancies from sorted array and returns result in a new array
    private ArrayList<Integer> shortenArray() {
        int sortedArr[] = sortArray();
        ArrayList<Integer> shortArr = new ArrayList<>();

        shortArr.add(sortedArr[0]);
        for(int i = 1; i < sortedArr.length; i++)
            if (sortedArr[i] == sortedArr[i - 1])
                continue;
            else
                shortArr.add(sortedArr[i]);

        return shortArr;
    }

    // Prints the results using occurrenceCounter and shortenArray, this is the only method main needs to call
    public void printList(){
        System.out.println("-------------");
        System.out.println("| N | COUNT |");
        System.out.println("-------------");
        for (int i = 0; i < occurrenceCounter().length; i++)
        {
            System.out.format("|%2d |%7d|\n", shortenArray().get(i), occurrenceCounter()[i]);
            System.out.println("-------------");
        }
    }
}

/*
-------------
| N | COUNT |
-------------
| 9 |      3|
-------------
| 7 |      1|
-------------
| 3 |      1|
-------------
| 2 |      2|
-------------
| 1 |      1|
-------------
| 0 |      2|
-------------
|-4 |      1|
-------------
|-5 |      3|
-------------
|-8 |      2|
-------------


-------------
| N | COUNT |
-------------
| 9 |      1|
-------------
| 8 |      2|
-------------
| 4 |      1|
-------------
| 3 |      1|
-------------
| 2 |      2|
-------------
| 1 |      2|
-------------
| 0 |      3|
-------------
|-3 |      1|
-------------
|-4 |      2|
-------------
|-5 |      1|
-------------
|-7 |      1|
-------------
 */