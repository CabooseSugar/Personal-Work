package exercise6;

import java.io.*;

public class WordLadder {

    public static void main(String[] args) throws IOException {
        String start1 = "cat";
        String end1 = "dog";

        String start2 = "mast";
        String end2 = "come";

        String start3 = "dog";
        String end3 = "catapult";

        System.out.println(start1);
        ladder(start1, end1,  0);
        System.out.println();

        System.out.println(start2);
        ladder(start2, end2, 0);
        System.out.println();

        System.out.println(start3);
        ladder(start3, end3, 0);
    }

    public static void ladder(String start, String end, int index) throws IOException {
        File myFile = new File("C:\\Users\\Kyle\\Desktop\\College\\2018-2019\\Fall\\CMPSC221\\ProblemSet3\\src\\exercise6\\words.txt");
        BufferedReader bReader = new BufferedReader(new FileReader(myFile));

        // in case of different lengths for start and end
        if (start.length() != end.length()) {
            System.out.println("No solution, words must be of equal length");
            return;
        }

        char[] endArray = end.toCharArray();
        String line;
        String testString = "";
        char[] testArray = start.toCharArray();

        if (start.equalsIgnoreCase(end)) { // end case, word ladder game is complete
            return;
        }

        // this while loop is here to avoid an infinite loop caused by a recursion call. If a letter is changed to the same
        // letter, a "new" word would be formed that'd always be found in the dictionary seeing as its the same as the old one and no change
        // actually happened.
        while (testArray[index] == endArray[index] && index < testArray.length - 1)
            index++;

        // swap characters at index and convert into a string for .equals() and passing use
        testArray[index] = endArray[index];
        for (char c: testArray)
            testString += c;

        // with the character swapped, go through dictionary to see if this is a valid word
        while ((line = bReader.readLine()) != null) {
            if (testString.equalsIgnoreCase(line)) {
                System.out.println(testString); // print word if valid
                ladder(testString, end, 0); // recursive call for successful word
                return;
            }
        }

        // hit this if statement if no match was found, if it's also the end of the index, the word ladder game can't be completed
        if (index + 1 == testArray.length) {
            System.out.println("No solution, check dictionary");
            return;
        }

        // if it's not the end of the index, increase the index by one
        ladder(start, end, index + 1); // recursive call for when new word isn't in dictionary
    }
}

/*
cat
dat
dot
dog

mast
cast
cost
cose
come

dog
No solution, words must be of equal length

Process finished with exit code 0
 */