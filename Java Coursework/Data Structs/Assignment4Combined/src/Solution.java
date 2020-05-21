import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        IMedianQueue<Integer> medianQ = new MedianQueue<>();
        Scanner keyboard = new Scanner(System.in);

        int n = keyboard.nextInt();
        int m = keyboard.nextInt();

        for (int i = 0; i < m; i++) {
            medianQ.enqueue(keyboard.nextInt());
        }

        if (medianQ.getMedian().compareTo(medianQ.back()) > 0)
            System.out.println("sell");
        else if (medianQ.getMedian().compareTo(medianQ.back()) == 0)
            System.out.println("hold");
        else
            System.out.println("buy");

        for (int i = 0; i < n - m; i++) {
            medianQ.replace(keyboard.nextInt());

            if (medianQ.getMedian().compareTo(medianQ.back()) > 0)
                System.out.println("sell");
            else if (medianQ.getMedian().compareTo(medianQ.back()) == 0)
                System.out.println("hold");
            else
                System.out.println("buy");
        }
    }

    public interface IMedian<E extends Comparable<? super E>> {

        void add(E x);
        boolean remove(E x);
        boolean replace(E oldVal, E newVal);
        E getMedian();

    }

    public static class SortedArray <E extends Comparable<? super E>> implements IMedian<E> {

        ArrayList<E> list = new ArrayList<E>();

        @Override
        public void add(E x) { // adds, sorted in ascending order
            if (list.size() == 0) {
                list.add(x);
                return;
            }

            for (int i = 0; i < list.size(); i++) {
                if (x.compareTo(list.get(i)) > 0)  // x > list.get(i) = 1, x = list.get(i) = 0, x < list.get(i) = -1, that's how compareTo works
                    continue;

                if (x.compareTo(list.get(i)) == 0 || x.compareTo(list.get(i)) == -1) {
                    list.add(i, x); // add here inserts at i and shifts everything else right
                    return;
                }
            }
            list.add(x);
        }

        @Override
        public boolean remove(E x) {
            if (list.size() == 0)
                return false;

            int index = binarySearch(x);

            if (index == -1)
                return false;

            if (index == list.size() - 1) {
                list.remove(list.size() - 1);
                return true;
            }

            for (int i = index; i < list.size() - 1; i++)
                list.set(i, list.get(i + 1));
            list.remove(list.size() - 1);
            return true;
        }

        @Override
        public boolean replace(E oldVal, E newVal) {
            if (remove(oldVal)) {
                add(newVal);
                return true;
            }
            return false;
        }

        @Override
        public E getMedian() {
            if (list.size() % 2 == 0)
                return null;
            return list.get(list.size() / 2);
        }

        int binarySearch(E x) { // returns -1 if x not in list
            int start = 0;
            int end = list.size() - 1;
            int middle;

            while (start <= end) {
                middle = (start + end) / 2;
                if (list.get(middle).compareTo(x) < 0)
                    start = middle + 1;
                else if (list.get(middle).compareTo(x) > 0)
                    end = middle - 1;
                else
                    return middle;
            }
            return -1;
        }
    }

    public interface IMedianQueue <E extends Comparable<? super E>> {
        E getMedian();

        void enqueue (E x);
        E dequeue();
        void replace(E newVal);
        E front();
        E back();
        boolean IsEmptyQueue();

    }

    public static class MedianQueue<E extends Comparable<? super E>> implements IMedianQueue<E>{

        IMedian<E> median = new SortedArray<>();
        LinkedList<E> list = new LinkedList<>();

        @Override
        public E getMedian() {
            if (list.size() % 2 == 0)
                return null;
            return median.getMedian();
        }

        @Override
        public void enqueue(E x) {
            list.addLast(x);
            median.add(x);
        }

        @Override
        public E dequeue() {
            E nextVal = front();
            list.removeFirst();
            median.remove(nextVal); // this is removing ALL occurrences from SortedArray, might want to change - CHANGED TO REMOVE JUST ONE INSTANCE OF nextVal
            return nextVal;
        }

        @Override
        public void replace(E newVal) {
            E oldVal = dequeue(); // same as above note
            enqueue(newVal);
            //median.replace(oldVal, newVal); REDUNDANT AND CAUSES PROBLEMS (look into why test case 1 still worked with this being here though)
        }

        @Override
        public E front() {
            return list.getFirst();
        }

        @Override
        public E back() {
            return list.getLast();
        }

        @Override
        public boolean IsEmptyQueue() {
            return list.isEmpty();
        }
    }
}
