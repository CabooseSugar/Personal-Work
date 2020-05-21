package exercise4;

import java.util.ArrayList;

public class PriorityQueue {
    public static void main(String[] args) {

        PriorityQueue q = new PriorityQueue();

        // Adding data to priority queue. Desired result is A,C,B.
        q.enqueue('A', 3);
        q.enqueue('B', 1);
        q.enqueue('C', 2);

        // Removing data from priority queue and printing to screen
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue() + "\n");

        // Adding data to priority queue. Desired result is N, M, A, C, O, B (though really A and M, and B and O could be swapped)
        q.enqueue('A', 3);
        q.enqueue('B', 1);
        q.enqueue('C', 2);
        q.enqueue('M', 3);
        q.enqueue('N', 5);
        q.enqueue('O', 1);

        // Removing data from priority queue and printing to screen
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }

    // INSTANCE DATA
    private ArrayList<Character[]> aList = new ArrayList<>(); // have to use wrapper class with ArrayList?

    // MUTATOR METHODS
    // Adds item to the priority queue(represented as an ArrayList)
    public void enqueue(char entry, int priority){
        // Converting entry + priority into one array of chars so we can put both points of data into the ArrayList together
        // Use an array of chars instead of two-character String since, unlike C++, can't step through a string like an array (s[3] = 'G')
        Character data[] = new Character[2]; // notice use of wrapper class to compliment ArrayList declaration
        data[0] = entry; // also notice though that you can put a primitive char into wrapper class Character array
        data[1] = (char)priority; // converts priority to char

        // If Array List is empty, adds without searching
        if (aList.size() == 0) {
            aList.add(data);
            return;
        }

        // Searching for correct place to put data
        for (int i = 0; i < aList.size(); i++) {
            if (priority < (int)aList.get(i)[1]) // finds second char ([1] - the priority) in data array i of ArrayList and converts back to int to compare
                continue;
            else {
                aList.add(i, data); // more complex version of .add() that lets us specify where we're putting the data array
                                    // in the Array List of Character arrays (this case i)
                return;
            }
        }
        aList.add(aList.size(), data); // need this here in case the data being entered would go on the very back of queue
                                    // because look at the for loop. If we put the i <= aList.size(), the for loop would go
                                    // to the end of the queue, but that spot would be empty at this time since the data has
                                    // yet to be added even though it wants to go there. The point is, there'd be nothing there
                                    // for the if statement to compare the data to. This line of code catches that case.
                                    // Notice it's not size() - 1, since the size hasn't been adjusted yet because nothing has
                                    // yet been added.
        return;
    }

    // ACCESSOR METHODS
    public char dequeue() {
        Character[] data = new Character[2];
        data = aList.get(0);
        aList.remove(0); // removes data at front of queue (meaning highest priority) now that have the char to return
        return data[0];
    }
}

/*
A
C
B

N
M
A
C
O
B

Process finished with exit code 0
 */