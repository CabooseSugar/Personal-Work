import java.util.*;

public class BottomUpConstantSpace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numDenoms = sc.nextInt();
        int denoms[] = new int[numDenoms];
        for (int i = 0; i < numDenoms; i++) {
            denoms[i] = sc.nextInt();
        }
        Arrays.sort(denoms);

        int n = sc.nextInt();
        int[] amts = new int[n];
        for (int i = 0; i < n; i++){
            amts[i] = sc.nextInt();
        }

        int[] temp = new int[amts.length];
        System.arraycopy(amts, 0, temp, 0, amts.length);
        Arrays.sort(temp);

        Map<Integer, Integer> map = new HashMap<>();

        if (denoms.length == 1){
            for (int i = 0; i < denoms.length; i++){
                map.put(temp[i], 1);
            }
        }

        else{
            int amtIndex = 0;
            int[] arr = new int[denoms[denoms.length - 1]];
            for (int i = 1; i <= amts[amts.length - 1]; i++){
                output(denoms, i, arr);
                if (i == temp[amtIndex]){
                    map.put(i, arr[(i - 1) % denoms[denoms.length - 1]]);
                    amtIndex++;
                }
            }
        }

        for (int i = 0; i < amts.length; i++){
            System.out.println(map.get(amts[i]));
        }

    }

    static void output(int d[], int amt , int[] arr) {
        long ways = 0;

        for (int i = 0; i < d.length; i++){
            if (d[i] <= amt){
                int diff = amt - d[i];
                if (diff == 0) {
                    ways++;
                }
                else {
                    ways = (ways + (long)arr[(diff - 1) % arr.length]) % 1000000007;
                }
            }
            else break;
        }
        arr[(amt - 1) % arr.length] = (int)ways;
    }
}
