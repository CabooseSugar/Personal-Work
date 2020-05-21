package java_arrays;

import java.util.Arrays;

public class ArrayTest {

    public static void main(String[] args) {
        int[] myNums = new int[] {4, 2, 3, 5, 1};
        for (int i = 0; i < myNums.length; i++) // notice length is not a method [length()], it's a property
            System.out.println(myNums[i]);

        System.out.println("BEFORE SORT: ");
        printArray(myNums);

        //sortArray(myNums);
        Arrays.sort(myNums); // Java built-in sorting method for arrays [merge sort -> worst case: O( N*logN)]

        System.out.println("AFTER SORT: ");
        printArray(myNums);

        System.out.println("AGAIN WITH NEW PRINT METHOD: ");
        printArray2(myNums);

        // System.out.println("OUT OF BOUNDS ELEMENT: " + myNums[10]); Java is more strict with this than C++
    }

    private static void printArray(int[] myNums) {
        //for (int i = 0; i < myNums.length; i++)
        for (int myNum: myNums) // different way to iterate through the array
            //System.out.print(String.format("%s ", myNums[i]));
            System.out.print(String.format("%s ", myNum));
        System.out.println();
    }

    private static void printArray2(int[] myNums) {
        Arrays.stream(myNums).forEach( i -> System.out.print(i + " ")); //lambda expression
        System.out.println();
    }

    private static void sortArray(int[] myNums) {
        //
        // Bubble sort
        boolean didSwap = false;
        do {
            didSwap = false;
            for (int i = 0; i < myNums.length - 1; i++)
                if (myNums[i] > myNums[i+1]) {
                    int swap = myNums[i];
                    myNums[i] = myNums[i+1];
                    myNums[i+1] = swap;
                    didSwap = true;
                }

        } while(didSwap);
    }
}
