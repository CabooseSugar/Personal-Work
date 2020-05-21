import java.util.Random;

public class Driver {
    public static void main(String[] args) {
        PriorityQueue q = new PriorityQueue();
        Random r = new Random();
        for (int i = 0; i < 100; i++){
            q.insert(r.nextInt(20), r.nextInt(1000));
        }
        q.insert(21, 1);
        q.insert(20, 0);

        System.out.println("Current size: " + q.getSize());
        System.out.println("Removing highest priority elem: " + q.removeHighestElem());
        System.out.println("Current size: " + q.getSize());
        System.out.println("Elem w/ highest priority: " + q.getHighestElem());
        System.out.println("Current size: " + q.getSize());
        System.out.println("Highest priority in queue: " + q.getHighestPriority());

    }
}
