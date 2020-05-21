import java.math.BigInteger;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        long m = sc.nextInt();

        long[] aItems = new long[a];
        long[] bItems = new long[b];

        for (int i = 0; i < a; i++) {
            aItems[i] = sc.nextLong();
        }
        for (int i = 0; i < b; i++) {
            bItems[i] = sc.nextLong();
        }

        Arrays.sort(aItems);
        Arrays.sort(bItems);

        int start = 0;
        int end = bItems.length-1;
        long closest = aItems[0] + bItems[(start + end) /2];

        for (int i = 0; i < a;){
            long sum;
            long add = aItems[i];
            int mid = (start + end) / 2;
            sum = add + bItems[mid];

            if(start == end) {
                if (Math.abs(sum - m) < Math.abs(closest - m)){
                    closest = sum;
                }
                start = 0;
                end = bItems.length-1;
                i++;
                continue;
            }

            if (sum == m){
                closest = sum;
                break;
            }

            if (sum > m){
                if (Math.abs(sum - m) < Math.abs(closest - m)){
                    closest = sum;
                }
                end = mid;
                continue;
            }

            else{
                if (Math.abs(sum - m) < Math.abs(closest - m)){
                    closest = sum;
                }
                start = mid + 1;
                continue;
            }
        }

        System.out.println(closest);

    }
}

