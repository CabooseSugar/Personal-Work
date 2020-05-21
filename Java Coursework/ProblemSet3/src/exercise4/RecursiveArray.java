package exercise4;

public class RecursiveArray {
    public static void main(String[] args) {
        String [][] data = {
                {"A", "B"},         // [0][]
                {"1", "2"},         // [1][]
                {"XX", "YY", "ZZ"}  // [2][]
        };

        printCombos(data, "", 0, 0);

        System.out.println();

        String[][] data2 = {
                {"A"},
                {"1"},
                {"2"},
                {"XX", "YY"}
        };

        printCombos(data2, "", 0, 0);
    }


    public static void printCombos(String[][] d, String s, int r, int c) {
        String[][] data = d;

        String combo = s + data[r][c];    // add element to a string (begins as empty string + data[0][0])

        if (r == data.length - 1)           // If in last row, print the combo string (note use data.length - 1 as recursive call does r + 1)
            System.out.println(combo);
        if (r < data.length - 1)        // If not in last row, recursive call advances rows until you are, doing "A" + "1" along way
            printCombos(d, combo, r + 1, 0); // This will reach "XX" and add it to "A1" on second time called
        if (c < data[r].length - 1)         // Now you're in last row, recursive call but advance 1 along columns of row 3...
            printCombos(d, s, r, c + 1);   // ... and passing s which = what was passed to it to start before last element was added (A1)...
                                                // ... that'll give A1YY and A1ZZ (printing each because r still == data.length - 1 through...
                                                // ... all these recursive calls).
        // Start kicking out of recursives now. c = 2, 1, and 0 for r = 3 have run through entire method now in that order,
        // So now kicked up to r = 2, which still needs to run through bottom if statement for all it's possible c values
        // (c = 0 and c = 1 or "1" and "2" respectively). Then will go through recursive in first if statement but with "2" instead of "1"
        // to get to A2's bottom row, which goes through recursives just like A1 did. Then you get kicked up to r = 1, and repeat it all
        // but starting with "B" instead of "A".

        /*
        Can picture it sort of like a big binary tree. First recursive navigates through leftmost branches to the bottom, second
        recursive navigates through adjacent sibling leaves to the right until all are done. You get kicked back up to the parent, second
        recursive navigates to first adjacent sibling node to the right, first recursive moves you down, second recursive picks up the leaves,
        etc, etc.
        */
    }
}

/*
A1XX
A1YY
A1ZZ
A2XX
A2YY
A2ZZ
B1XX
B1YY
B1ZZ
B2XX
B2YY
B2ZZ

A12XX
A12YY

Process finished with exit code 0
 */