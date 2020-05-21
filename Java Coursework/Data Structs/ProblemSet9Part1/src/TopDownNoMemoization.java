import java.lang.reflect.Array;
import java.util.*;

public class TopDownNoMemoization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numDenoms = sc.nextInt();
        long denoms[] = new long[numDenoms];
        for (int i = 0; i < numDenoms; i++){
            denoms[i] = sc.nextLong();
        }
        Arrays.sort(denoms);

        int n = sc.nextInt();
        while (n > 0){
            if (numDenoms == 1){
                System.out.println(1);
                n--;
                continue;
            }
            long amt = sc.nextLong();
            long ways = output(denoms, amt, 0);
            n--;
            System.out.println(ways);
        }
    }

    static long output(long[] d, long amt, long ways){
        if (amt == 0){
            ways++;
            return ways;
        }
        if (amt < 0){
            return ways;
        }

        for (int i = d.length - 1; i >=0; i--) {
            ways = output(d, amt - d[i], ways);
        }
        return ways;
    }
}
