import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;


public class Driver {
    public static int SEED = 1;
    private static Random prng = new Random(SEED);

    public static void main(String[] args) throws IOException {

        Solution solution = Solution.getInstance();
        System.out.printf("Initial Solution created with fitness: %.1f\n", solution.getFitness());

        // TODO: Try to improve on solution by calling the methods that
        // explore solutions in the neighborhood of this one, e.g.
        int startCity, endCity, insertionPoint;
        int count = 0;
        do {
            double oldSolution = solution.getFitness();

            startCity = prng.nextInt(solution.getCityCount());
            endCity = prng.nextInt(solution.getCityCount());

            while (endCity < startCity){
                endCity = prng.nextInt(solution.getCityCount());
            }

            insertionPoint = prng.nextInt(solution.getCityCount());

            while (insertionPoint >= startCity && insertionPoint <= endCity){
                insertionPoint = prng.nextInt(solution.getCityCount());
            }

            if (solution.getFitnessIfPathInsertedAt(startCity, endCity, insertionPoint) >= solution.getFitness()){
                if (startCity != endCity && solution.getFitnessIfPathReversed(startCity, endCity) >= solution.getFitness()){
                    if (solution.getFitnessIfPathInsertedInReverseOrderAt(startCity, endCity, insertionPoint) < solution.getFitness()){
                        solution.reversePathAndInsertAt(startCity, endCity, insertionPoint);
                    }
                }
                else if (startCity != endCity) {
                    solution.reversePath(startCity, endCity);
                }
            }
            else{
                solution.insertPathAt(startCity, endCity, insertionPoint);
            }

            count++;
            if (count == 1000000){
                System.out.printf("%.1f\n", solution.getFitness());
                count = 0;
            }
        } while (solution.getFitness() >= 12182888.0); // closest i can get

        System.out.printf("Final Fitness: %.1f\n", solution.getFitness());

        PrintWriter pw = new PrintWriter("final.txt");
        pw.println(solution);
        pw.close();
    }
}

class Solution {
    private Coordinate[] order;
    private Coordinate[] buffer;
    private Double fitness;
    private static Solution singleton;

    /**
     * Get the instance of the Solution
     *
     * @return the singleton instance
     */
    public synchronized static Solution getInstance() throws IOException {
        if (singleton == null) {
            singleton = new Solution();
        }
        return singleton;
    }

    /**
     *
     * @return the number of cities to be connnected
     */
    public int getCityCount() {
        return order.length;
    }

    /**
     * Get the length of the associated tour
     *
     * @return the length of this solution
     */
    public double getFitness() {
        if (fitness == null) {
            HashSet<Coordinate> used = new HashSet<>();
            fitness = 0.0;

            Coordinate last = order[order.length - 1];
            for (Coordinate next: order) {
                if (used.contains(next)) throw new RuntimeException("Attempted to visit city twice!");
                used.add(next);
                fitness += last.distance(next);
                last = next;
            }
        }
        return fitness;
    }

    /**
     * Determine the cost of the tour if the tour jumped directly from the city before startCity to
     * the city after endCity, and the path from startCity to endCity were inserted after the
     * insertionPoint.
     *
     * @param startCity The index of the start city in the array
     * @param endCity The index of the end city in the array
     * @param insertionPoint The index after which the start city should be placed
     * @return The cost of the tour if it were altered
     */
    public double getFitnessIfPathInsertedAt(int startCity, int endCity, int insertionPoint) {
        if (startCity < 0 || startCity >= order.length) {
            throw new IllegalArgumentException("The startCity must be in the interval [0.." + order.length + ")");
        }
        if (endCity < 0 || endCity >= order.length) {
            throw new IllegalArgumentException("The endCity must be in the interval [0.." + order.length + ")");
        }
        if (insertionPoint < 0 || insertionPoint >= order.length) {
            throw new IllegalArgumentException("The insertionPoint must be in the interval [0.." + order.length + ")");
        }
        if ((endCity + 1) % order.length == startCity) {
            throw new IllegalArgumentException("The path cannot include all cities in the tour.");
        }
        if ((startCity <= endCity && insertionPoint >= startCity && insertionPoint <= endCity) ||
                (startCity > endCity && (insertionPoint <= endCity || insertionPoint >= startCity))) {
            throw new IllegalArgumentException("The path cannot be inserted within itself.  You must choose an insertion point that corresponds to an index outside of the path.");
        }
        if (insertionPoint == (startCity - 1 + order.length) % order.length) {
            // Note that this is no net change
            return getFitness();
        }

        int prevNdx = (startCity - 1 + order.length) % order.length;
        int nextNdx = (endCity + 1) % order.length;
        int insertionAfterNdx = (insertionPoint + 1) % order.length;

        return getFitness()
                - order[prevNdx].distance(order[startCity])
                - order[endCity].distance(order[nextNdx])
                - order[insertionPoint].distance(order[insertionAfterNdx])
                + order[prevNdx].distance(order[nextNdx])
                + order[insertionPoint].distance(order[startCity])
                + order[endCity].distance(order[insertionAfterNdx]);
    }

    /**
     * Determine the cost of the tour if the tour jumped directly from the city before startCity to
     * the city after endCity, and the path from startCity to endCity were inserted in REVERSE order
     * after the insertionPoint.
     *
     * @param startCity The index of the start city in the array
     * @param endCity The index of the end city in the array
     * @param insertionPoint The index after which the start city should be placed
     * @return The cost of the tour if it were altered
     */
    public double getFitnessIfPathInsertedInReverseOrderAt(int startCity, int endCity, int insertionPoint) {
        if (startCity < 0 || startCity >= order.length) {
            throw new IllegalArgumentException("The startCity must be in the interval [0.." + order.length + ")");
        }
        if (endCity < 0 || endCity >= order.length) {
            throw new IllegalArgumentException("The endCity must be in the interval [0.." + order.length + ")");
        }
        if (insertionPoint < 0 || insertionPoint >= order.length) {
            throw new IllegalArgumentException("The insertionPoint must be in the interval [0.." + order.length + ")");
        }
        if ((endCity + 1) % order.length == startCity) {
            throw new IllegalArgumentException("The path cannot include all cities in the tour.");
        }
        if (startCity == endCity) {
            throw new IllegalArgumentException("The path must have more than one city.");
        }
        if ((startCity <= endCity && insertionPoint >= startCity && insertionPoint <= endCity) ||
                (startCity > endCity && (insertionPoint <= endCity || insertionPoint >= startCity))) {
            throw new IllegalArgumentException("The path cannot be inserted within itself.  You must choose an insertion point that cooresponds to an index outside of the path.");
        }
        if (insertionPoint == (startCity - 1 + order.length) % order.length) {
            // Note that this is reversing in place
            return getFitnessIfPathReversed(startCity, endCity);
        }

        int prevNdx = (startCity - 1 + order.length) % order.length;
        int nextNdx = (endCity + 1) % order.length;
        int insertionAfterNdx = (insertionPoint + 1) % order.length;

        return getFitness()
                - order[prevNdx].distance(order[startCity])
                - order[endCity].distance(order[nextNdx])
                - order[insertionPoint].distance(order[insertionAfterNdx])
                + order[prevNdx].distance(order[nextNdx])
                + order[insertionPoint].distance(order[endCity])
                + order[startCity].distance(order[insertionAfterNdx]);
    }

    /**
     * Determine the cost of the tour if the path between startCity and endCity were reversed in the tour
     *
     * @param startCity The index of the start city in the array
     * @param endCity The index of the end city in the array
     * @return The cost of the tour if it were altered
     */
    public double getFitnessIfPathReversed(int startCity, int endCity) {
        if (startCity < 0 || startCity >= order.length) {
            throw new IllegalArgumentException("The startCity must be in the interval [0.." + order.length + ")");
        }
        if (endCity < 0 || endCity >= order.length) {
            throw new IllegalArgumentException("The endCity must be in the interval [0.." + order.length + ")");
        }
        if ((endCity + 1) % order.length == startCity) {
            throw new IllegalArgumentException("The path cannot include all cities in the tour.");
        }
        if (startCity == endCity) {
            throw new IllegalArgumentException("The path must have more than one city.");
        }

        int prevNdx = (startCity - 1 + order.length) % order.length;
        int nextNdx = (endCity + 1) % order.length;

        return getFitness()
                - order[prevNdx].distance(order[startCity])
                - order[endCity].distance(order[nextNdx])
                + order[prevNdx].distance(order[endCity])
                + order[startCity].distance(order[nextNdx]);
    }

    /**
     * Change the tour so that it jumps directly from the city before startCity to
     * the city after endCity, and the path from startCity to endCity is after the
     * insertionPoint.
     *
     * @param startCity The index of the start city in the array
     * @param endCity The index of the end city in the array
     * @param insertionPoint The index after which the start city should be placed
     */
    public void insertPathAt(int startCity, int endCity, int insertionPoint) {
        if (startCity < 0 || startCity >= order.length) {
            throw new IllegalArgumentException("The startCity must be in the interval [0.." + order.length + ")");
        }
        if (endCity < 0 || endCity >= order.length) {
            throw new IllegalArgumentException("The endCity must be in the interval [0.." + order.length + ")");
        }
        if (insertionPoint < 0 || insertionPoint >= order.length) {
            throw new IllegalArgumentException("The insertionPoint must be in the interval [0.." + order.length + ")");
        }
        if ((endCity + 1) % order.length == startCity) {
            throw new IllegalArgumentException("The path cannot include all cities in the tour.");
        }
        if ((startCity <= endCity && insertionPoint >= startCity && insertionPoint <= endCity) ||
                (startCity > endCity && (insertionPoint <= endCity || insertionPoint >= startCity))) {
            throw new IllegalArgumentException("The path cannot be inserted within itself.  You must choose an insertion point that cooresponds to an index outside of the path.");
        }
        if (insertionPoint == (startCity - 1 + order.length) % order.length) {
            // Note that this is no net change
            return;
        }

        shift(startCity, endCity, insertionPoint);
        fitness = null;
        getFitness();
    }

    private void shift(int start, int end, int insertionPoint) {

        // Store values to insert
        int p = start;
        int length = 0;
        while (p != end) {
            buffer[length++] = order[p];
            p = (p + 1) % order.length;
        }
        buffer[length++] = order[end];

        // Shift values to make gap
        int toNdx = start;
        int fromNdx = (end + 1) % order.length;
        while (fromNdx != insertionPoint) {
            order[toNdx] = order[fromNdx];
            toNdx = (toNdx + 1) % order.length;
            fromNdx = (fromNdx + 1) % order.length;
        }
        order[toNdx] = order[insertionPoint];
        toNdx = (toNdx + 1) % order.length;

        // Insert values into new spots
        for (int i = 0; i < length; i++) {
            order[toNdx] = buffer[i];
            toNdx = (toNdx + 1) % order.length;
        }
    }

    /**
     * Change the tour so that the tour jumps directly from the city before startCity to
     * the city after endCity, and the path from startCity to endCity is inserted in REVERSE order
     * after the insertionPoint.
     *
     * @param startCity The index of the start city in the array
     * @param endCity The index of the end city in the array
     * @param insertionPoint The index after which the start city should be placed
     */
    public void reversePathAndInsertAt(int startCity, int endCity, int insertionPoint) {
        if (startCity < 0 || startCity >= order.length) {
            throw new IllegalArgumentException("The startCity must be in the interval [0.." + order.length + ")");
        }
        if (endCity < 0 || endCity >= order.length) {
            throw new IllegalArgumentException("The endCity must be in the interval [0.." + order.length + ")");
        }
        if (insertionPoint < 0 || insertionPoint >= order.length) {
            throw new IllegalArgumentException("The insertionPoint must be in the interval [0.." + order.length + ")");
        }
        if ((endCity + 1) % order.length == startCity) {
            throw new IllegalArgumentException("The path cannot include all cities in the tour.");
        }
        if ((startCity <= endCity && insertionPoint >= startCity && insertionPoint <= endCity) ||
                (startCity > endCity && (insertionPoint <= endCity || insertionPoint >= startCity))) {
            throw new IllegalArgumentException("The path cannot be inserted within itself.  You must choose an insertion point that cooresponds to an index outside of the path.");
        }
        if (startCity == endCity) {
            throw new IllegalArgumentException("The path must have more than one city.");
        }

        if (insertionPoint != (startCity - 1 + order.length) % order.length) {
            reverse(startCity,endCity);
            shift(startCity,endCity,insertionPoint);
            fitness = null;
            getFitness();
        }
        else {
            reversePath(startCity, endCity);
        }
    }

    /**
     * Change the tour so that the path between startCity and endCity is reversed
     *
     * @param startCity The index of the start city in the array
     * @param endCity The index of the end city in the array
     */
    public void reversePath(int startCity, int endCity) {
        if (startCity < 0 || startCity >= order.length) {
            throw new IllegalArgumentException("The startCity must be in the interval [0.." + order.length + ")");
        }
        if (endCity < 0 || endCity >= order.length) {
            throw new IllegalArgumentException("The endCity must be in the interval [0.." + order.length + ")");
        }
        if ((endCity + 1) % order.length == startCity) {
            throw new IllegalArgumentException("The path cannot include all cities in the tour.");
        }
        if (startCity == endCity) {
            throw new IllegalArgumentException("The path must have more than one city.");
        }
        reverse(startCity, endCity);
        fitness = null;
        getFitness();
    }

    private void reverse(int start, int end) {
        boolean done = false;
        while (!done) {
            Coordinate tmp = order[start];
            order[start] = order[end];
            order[end] = tmp;

            start = (start + 1) % order.length;
            done = (start == end);
            end = (end - 1 + order.length) % order.length;
            done = done | (start == end);
        }
    }

    /**
     * @return a string with all coordinates in the tour in order that they appear
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%.1f\n", getFitness()));
        sb.append(order.length);
        sb.append("\n");
        for (Coordinate c: order) {
            sb.append(c);
            sb.append("\n");
        }
        return sb.toString();
    }

    private Solution() throws IOException {
        Scanner sc = null;
        try {
            sc = new Scanner(new File("input.txt"));
        }
        catch (FileNotFoundException fnfe) {
            throw new FileNotFoundException("The 'input.txt' file must be in the working directory");
        }
        double fitness = sc.nextDouble();
        int n = sc.nextInt();
        order = new Coordinate[n];
        buffer = new Coordinate[n];

        for (int i = 0; i < n; i++) {
            order[i] = new Coordinate(sc.nextInt(), sc.nextInt());
        }
        sc.close();
    }

    private static class Coordinate {
        public int x, y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public double distance(Coordinate that) {
            double distX = this.x - that.x;
            double distY = this.y - that.y;
            return Math.sqrt(distX * distX + distY * distY);
        }

        @Override
        public boolean equals(Object other) {
            if (other == null) return false;
            if (this == other) return true;
            if (this.getClass() != other.getClass()) return false;

            Coordinate that = (Coordinate) other;
            return this.x == that.x && this.y == that.y;
        }

        @Override
        public int hashCode() {
            return x * 37 + y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }


}

