package exercise5;

import java.util.ArrayList;

public class StringContains {
    public static void main(String[] args) {
        if (contains("cat", "ct") == true)
           System.out.println("found");
        else
            System.out.println("fail");
        if (contains("dog", "at") == true)
            System.out.println("found");
        else
            System.out.println("fail");
        if (contains("hello", "elio"))
            System.out.println("found");
        else
            System.out.println("fail");
        if (contains("cat", "cat") == true)
            System.out.println("found");
        else
            System.out.println("fail");
        if (contains("cat", "c") == true)
            System.out.println("found");
        else
            System.out.println("fail");
        if (contains("cat", "t") == true)
            System.out.println("found");
        else
            System.out.println("fail");
        if (contains("ccat", "cat") == true)
            System.out.println("found");
        else
            System.out.println("fail");
    }

    // The core idea behind this method is to trim the first letters off the haystack until getting to a place where
    // the first letter of the haystack equals the first letter of the needle. At this point, any matches of the first letters
    // will result in both the haystack's and needle's first letter getting trimmed off. If the needle has all its letters removed,
    // it has been found, and true is returned. Otherwise, false is.
    public static boolean contains(String haystack, String needle) {
        // Start by putting haystack and needle into ArrayLists of characters with for-each loops. (Can do with lambdas?)
        // This way can easily trim letters with .remove(0)
        ArrayList<Character> oldHay = new ArrayList<>();
        for (char c: haystack.toCharArray())
            oldHay.add(c);
        ArrayList<Character> oldNeedle = new ArrayList<>();
        for (char c: needle.toCharArray())
            oldNeedle.add(c);

        // Checks if needle has no letters left, at which point true is returned which will "cascade" through recursive calls
        if (oldNeedle.isEmpty())
            return true;

        // This condition will be true if the haystack has no letters left but needle still does, indicating either a partial
        // but incomplete match or no match at all
        if (oldHay.isEmpty())
            return false;

        // If both still have letters left, have to know whether there's a match in the first letters before trimming
        // the haystack
        if (oldHay.get(0) == oldNeedle.get(0)) {
            // Empty if statement, this is needed to scout ahead one place (making sure not to go out of bounds) in the
            // case where there's a first letter match, but too early. Without this, the needle "ct" would register as
            // being in the haystack "cat", for instance.
            if (oldHay.size() > 1 && oldNeedle.size() > 1 && oldHay.get(1) != oldNeedle.get(1)) { }
            else
                oldNeedle.remove(0); // trim a letter off the needle to represent a safe match
        }

        oldHay.remove(0); // trim a letter off the haystack to advance the search

        // converting ArrayLists back into Strings
        String newHay = "";
        for (Character c: oldHay)
            newHay += c;
        String newNeedle = "";
        for (Character c: oldNeedle)
            newNeedle += c;

        if(contains(newHay, newNeedle)) // recursive call
            return true;
        else
            return false;
    }
}

/*
fail
fail
fail
found
found
found
found
 */
