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

        for (int i = 0; i < a; i++){
            aItems[i] = sc.nextLong();
        }
        for (int i = 0; i < b; i++){
            bItems[i] = sc.nextLong();
        }

        Arrays.sort(bItems);

        long closest = aItems[0] + bItems[0];
        for (int i = 0; i < a; i++){
            long test = findClosest(bItems, aItems[i], 0, bItems.length - 1, closest, m);
            if (Math.abs(test - m) == Math.abs(closest - m)){
                if(test < closest){
                    test = closest;
                }
            }
            if (Math.abs(test - m) < Math.abs(closest - m)){
                closest = test;
            }
        }

        System.out.println(closest);
    }

    static long findClosest(long[] b, long add, int start, int end, long closest, long m){
        long sum;
        if (start == end){
            sum = add + b[start];
            if (Math.abs(sum - m) < Math.abs(closest - m)){
                return sum;
            }
            else {
                return closest;
            }
        }

        int mid = (start + end) / 2;
        sum = add + b[mid];

        if (sum == m){
            return sum;
        }

        if (sum > m){
            if (Math.abs(sum - m) < Math.abs(closest - m)){
                closest = sum;
            }
            closest = findClosest(b, add, start , mid, closest, m);
        }
        else{
            if (Math.abs(sum - m) <= Math.abs(closest - m)){
                closest = sum;
            }
            closest = findClosest(b, add, mid + 1 , end , closest, m);
        }
        return closest;

    }
}

