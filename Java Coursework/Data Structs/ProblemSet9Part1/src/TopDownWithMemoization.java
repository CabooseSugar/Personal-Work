import java.util.*;

public class TopDownWithMemoization {
    public static void main(String[] args) {
        Map<Long, Long> memo = new HashMap<>();
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
            long ways = output(denoms, amt, 0, memo);
            n--;
            System.out.println(ways);
        }
    }

    static long output(long[] d, long amt, long ways, Map<Long, Long> memo){
        if (amt == 0){
            ways++;
            return ways;
        }
        if (amt < 0){
            return ways;
        }

        if(memo.containsKey(amt)){
            return (ways += memo.get(amt)) % 1000000007;
        }

        long localWays = 0;
        for (int i = d.length - 1; i >=0; i--) {
            localWays = output(d, amt - d[i], localWays, memo);
        }
        memo.put(amt, localWays);
        return (ways + localWays) % 1000000007;
    }
}
