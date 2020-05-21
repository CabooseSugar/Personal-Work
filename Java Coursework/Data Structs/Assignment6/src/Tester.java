import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class Tester {
    public static void main(String[] args) {
        Random prng = new Random();
        LazyPriorityQueue<Integer> lazypq = new LazyPriorityQueue<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Queue<Integer> q = new LinkedList<>();

        long pqTime = 0, lazypqTime = 0;
        for (int i = 0; i < 10_000_000; i++) {
            int operation = prng.nextInt(4);
            if (q.size() <= 1000 || operation == 0) {
                Integer element = prng.nextInt(100000);
                q.add(element);
                long time = System.currentTimeMillis();
                pq.add(element);
                pqTime += System.currentTimeMillis() - time;
                time = System.currentTimeMillis();
                lazypq.add(element);
                lazypqTime += System.currentTimeMillis() - time;
                if (lazypq.size() != pq.size()) {
                    throw new RuntimeException("After an add, the size of the LazyPriorityQueue (" + lazypq.size() +
                            ") does not match the size of the PriorityQueue (" + pq.size() + ")");
                }
            }
            else if (operation == 1) {
                Integer element = q.remove();
                long time = System.currentTimeMillis();
                pq.remove(element);
                pqTime += System.currentTimeMillis() - time;
                time = System.currentTimeMillis();
                lazypq.remove(element);
                lazypqTime += System.currentTimeMillis() - time;
                if (lazypq.size() != pq.size()) {
                    throw new RuntimeException("After a remove(element), the size of the LazyPriorityQueue (" + lazypq.size() +
                            ") does not match the size of the PriorityQueue (" + pq.size() + ")");
                }
            }
            else if (operation == 2) {
                long time = System.currentTimeMillis();
                Integer top1 = pq.remove();
                pqTime += System.currentTimeMillis() - time;
                time = System.currentTimeMillis();
                Integer top2 = lazypq.remove();
                lazypqTime += System.currentTimeMillis() - time;
                if (lazypq.size() != pq.size()) {
                    throw new RuntimeException("After a remove(), the size of the LazyPriorityQueue (" + lazypq.size() +
                            ") does not match the size of the PriorityQueue (" + pq.size() + ")");
                }
                if (!top1.equals(top2)) {
                    throw new RuntimeException("The top of the LazyPriorityQueue does not match the top of the PriorityQueue");
                }
                q.remove(top1);
            }
            else {
                long time = System.currentTimeMillis();
                Integer top1 = pq.element();
                pqTime += System.currentTimeMillis() - time;
                time = System.currentTimeMillis();
                Integer top2 = lazypq.element();
                lazypqTime += System.currentTimeMillis() - time;
                if (lazypq.size() != pq.size()) {
                    throw new RuntimeException("After a element(), the size of the LazyPriorityQueue (" + lazypq.size() +
                            ") does not match the size of the PriorityQueue (" + pq.size() + ")");
                }
                if (!top1.equals(top2)) {
                    throw new RuntimeException("The top of the LazyPriorityQueue does not match the top of the PriorityQueue");
                }
            }
        }
        System.out.println("Code passed tests.\n");
        System.out.println("Time taken by priority queue: " + pqTime + " ms.");
        System.out.println("Time taken by lazy priority queue: " + lazypqTime + " ms.");
    }
}

