import java.util.Collections;
import java.util.PriorityQueue;

public class test {
    public static void main(String[] args) {
        PriorityQueue<Integer> t = new PriorityQueue<>();
        t.add(3);
        t.add(5);
        t.add(2);
        t.add(0);

        System.out.println(t.remove());
        System.out.println(t.remove());
        System.out.println(t.remove());
        System.out.println(t.remove());

        PriorityQueue<Integer> t2 = new PriorityQueue<Integer>(3, Collections.reverseOrder());
        t2.add(3);
        t2.add(5);
        t2.add(2);

        System.out.println(t2.remove());
        System.out.println(t2.remove());
        System.out.println(t2.remove());
    }
}
