import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split(" ");
        int n = Integer.valueOf(tokens[0]);
        int m = Integer.valueOf(tokens[1]);

        IMedianQueue<Integer> median = new MedianQueue<>();

        StringBuffer sbOut = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            int lastPrice = Integer.valueOf(reader.readLine());
            if (i <= m) {
                median.enqueue(lastPrice);
            }
            else {
                median.replace(lastPrice);
            }
            if (i >= m) {
                // Output decision
                Integer currentMedian = median.getMedian();
                //System.out.println("LAST PRICE: " + lastPrice);
                if (lastPrice > currentMedian) sbOut.append("buy\n");
                else if (lastPrice < currentMedian) sbOut.append("sell\n");
                else sbOut.append("hold\n");
            }
        }
        System.out.print(sbOut.toString());
    }
}

class LazyPriorityQueue<E extends Comparable<? super E>> extends PriorityQueue<E> {
    private static final long serialVersionUID = 1L;
    public HashMap<E,Integer> pendingDeletes = new HashMap<>();
    public int pendingDeleteCount = 0; // The number of elements in the PriorityQueue that have been
    // marked for deletion

    public LazyPriorityQueue() {
        super();
    }

    public LazyPriorityQueue(int initialCapacity, Comparator<? super E> comparator) {
        super(initialCapacity, comparator);
    }

    /**
     * Add element to the heap
     *
     * @see java.util.PriorityQueue#add(java.lang.Object)
     */
    @Override
    public boolean add(E element) {
        // TODO: Add code to remove element from the pending delete map
        // If element is not a pending delete, then add it to the queue
        if (pendingDeleteCount == 0) {
            super.add(element);
            return false;
        }
        else if (pendingDeletes.containsKey(element)) {
            if (pendingDeletes.get(element).compareTo(1) > 0) {
                pendingDeletes.put(element, pendingDeletes.get(element) - 1);
                pendingDeleteCount -= 1;
            }
            else {
                pendingDeletes.remove(element);
                pendingDeleteCount -= 1;
            }
            return true;
        }

        else
            super.add(element);
        return false;
    }

    /**
     * Remove the object from the heap
     *
     * @see java.util.PriorityQueue#remove(java.lang.Object)
     */
    @Override
    public boolean remove(Object object) {
        // TODO Do not call super.remove(element), instead, simply record in the
        // pending deletes hashmap that there is one more element that needs to be
        // deleted. Also, make sure you update the total number of elements marked
        // for deletion.  Note that we always return true from remove

        @SuppressWarnings("unchecked")
        E element = (E) object;
        if (pendingDeletes.containsKey(element)) {
            pendingDeletes.put(element, pendingDeletes.get(element) + 1);
            pendingDeleteCount += 1;
        }
        else {
            pendingDeletes.put(element, 1);
            pendingDeleteCount += 1;
        }

        //super.remove(element);
        return true;
    }

    /**
     * Return the number of elements in the heap
     *
     * @see java.util.PriorityQueue#size()
     */
    @Override
    public int size() {
        // TODO Update this method so that it works correctly, taken
        // into account the number of pending deletes
        //return super.size();

        return super.size() - pendingDeleteCount;
    }

    /**
     * Return the top of the heap
     *
     * @see java.util.AbstractQueue#element()
     */
    @Override
    public E element() {
        // TODO Update this method, so that it does not return an element
        // that has been lazy deleted

        if (pendingDeleteCount == 0)
            return super.element();

        while (pendingDeletes.containsKey(super.element())){ // super.element returns but doesn't delete top of queue
            add(super.element());
            super.remove();
        }

        return super.element();
    }

    /**
     * @see java.util.AbstractQueue#remove()
     */
    @Override
    public E remove() {
        // TODO Update this method, so that it does not return an element
        // that has been lazy deleted

        while (pendingDeletes.containsKey(super.element())){
            add(super.element());
            super.remove();
        }

        return super.remove();
    }
}


interface IMedian <T extends Comparable <? super T>>{
    void add(T x);
    void remove(T x);
    T getMedian();
    void replace(T oldValue, T newValue);
}

class FastMedian<E extends Comparable <? super E>> implements IMedian<E> {

    private LazyPriorityQueue<E> maxHeap = new LazyPriorityQueue<E>(11, Collections.reverseOrder());
    private LazyPriorityQueue<E> minHeap = new LazyPriorityQueue<E>();

    @Override
    public void add(E x) {
        if (minHeap.isEmpty())
            minHeap.add(x);
        else if (x.compareTo(minHeap.element()) >= 0)
            minHeap.add(x);
        else
            maxHeap.add(x);
    }

    @Override
    public void remove(E x) {
        if (x.compareTo(minHeap.element()) >= 0 ) //>=??
            minHeap.remove(x);
        else
            maxHeap.remove(x);
    }

    @Override
    public E getMedian() {


        /*
        System.out.println("MIN HEAP: " + minHeap.toString());
        System.out.println("MAX HEAP: " + maxHeap.toString());
        System.out.println("MIN PENDING: " + minHeap.pendingDeletes.entrySet());
        System.out.println("MAX PENDING: " + maxHeap.pendingDeletes.entrySet());
        */


        if (minHeap.size() != maxHeap.size() + 1){
            if (minHeap.size() > maxHeap.size()){
                while(minHeap.size() != maxHeap.size() + 1){
                    maxHeap.add(minHeap.remove());
                }
            }
            else {
                while (minHeap.size() != maxHeap.size() + 1) {
                    minHeap.add(maxHeap.remove());
                }
            }
        }

        //System.out.println("MEDIAN" + minHeap.element());
        return minHeap.element();
    }

    @Override
    public void replace(E oldValue, E newValue) {
        remove(oldValue);
        add(newValue);
    }
}

interface IMedianQueue <T extends Comparable <? super T>>{
    T front();
    void enqueue(T x);
    T dequeue();
    T getMedian();
    void replace(T x);
}

class MedianQueue<E extends Comparable <? super E>> implements IMedianQueue<E> {
    private LinkedList<E> q = new LinkedList<E>();
    private IMedian<E> median = new FastMedian<>();

    @Override
    public E front() {
        return q.getFirst();
    }

    @Override
    public void enqueue(E x) {
        q.addLast(x);
        median.add(x);
    }

    @Override
    public E dequeue() {
        E retVal = q.removeFirst();
        median.remove(retVal);
        return retVal;
    }

    @Override
    public E getMedian() {
        return median.getMedian();
    }

    @Override
    public void replace(E x) {
        E oldVal = q.removeFirst();
        q.addLast(x);
        median.replace(oldVal, x);
    }
}