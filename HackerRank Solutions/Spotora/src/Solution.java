import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double[] sl1 = new double[n*2];
        double[] sl2 = new double[n*2];
        for (int i = 0; i < sl1.length; i++){
            sl1[i] = sc.nextDouble();
        }
        for (int i = 0; i < sl2.length; i++){
            sl2[i] = sc.nextDouble();
        }

        System.out.printf("%.0f", maxEnj(sl1, sl2, 0, 0, true, n, 0,0, 0));

    }

    private static double maxEnj(double[] sl1, double[] sl2, int indx1, int indx2, boolean skip, int n, double total, double max, int streak) {
        if (n == 0){
            if (total > max){
                return total;
            }
            return max;
        }

        if (streak == 3){
            streak = 0;
            skip = true;
        }

        double tempMax;

        // listen to one song from sl1 - only increment the streak if no skip is stored
        if (indx1 < sl1.length && skip) {
            tempMax = maxEnj(sl1, sl2, indx1 + 1, indx2, skip, n - 1, total + sl1[indx1], max, streak);
            if (tempMax > max)
                max = tempMax;
        }
        else if (indx1 < sl1.length) {
            tempMax = maxEnj(sl1, sl2, indx1 + 1, indx2, skip, n - 1, total + sl1[indx1], max, streak + 1);
            if (tempMax > max)
                max = tempMax;
        }
        // listen to one song from sl2 - only increment the streak if no skip is stored
        if (indx2 < sl2.length && skip) {
            tempMax = maxEnj(sl1, sl2, indx1, indx2 + 1, skip, n - 1, total + sl2[indx2], max, streak);
            if (tempMax > max)
                max = tempMax;
        }
        else if (indx2 < sl2.length) {
            tempMax = maxEnj(sl1, sl2, indx1, indx2 + 1, skip, n - 1, total + sl2[indx2], max, streak + 1);
            if (tempMax > max)
                max = tempMax;
        }
        // skip song from sl1 and listen to next
        if (indx1 + 1 < sl1.length && skip) {
            tempMax = maxEnj(sl1, sl2, indx1 + 2, indx2, false, n - 1, total + sl1[indx1 + 1], max, streak + 1);
            if (tempMax > max)
                max = tempMax;
        }
        // skip song from sl2
        if (indx2 + 1 < sl2.length && skip) {
            tempMax = maxEnj(sl1, sl2, indx1, indx2 + 2, false, n - 1, total + sl2[indx2 + 1], max, streak + 1);
            if (tempMax > max)
                max = tempMax;
        }

        return max;



    }
}
