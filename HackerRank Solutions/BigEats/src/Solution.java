import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numA = scanner.nextInt();
        int numB = scanner.nextInt();
        double target = scanner.nextDouble();
        List<Double> a = new ArrayList<>();
        List<Double> b = new ArrayList<>();
        for (int i = 0; i < numA; i++){
            a.add(scanner.nextDouble());
        }
        for (int i = 0; i < numB; i++){
            b.add(scanner.nextDouble());
        }

        Collections.sort(b);

        double closest = a.get(0) + b.get(0);
        for (int i = 0; i < a.size(); i++){
            double tempClosest = a.get(i) + b.get(0);
            double result = findClosest(a.get(i), b, target, tempClosest);
            if (result == target){
                System.out.printf("%.0f", result);
                return;
            }

            if (Math.abs(result - target) < Math.abs(closest - target)){
                closest = result;
            }
            else if (Math.abs(result - target) == Math.abs(closest - target)){
                if (result < closest)
                    closest = result;
            }


        }
        System.out.printf("%.0f", closest);
    }

    private static double findClosest(double aVal, List<Double> b, double target, double closest) {
        int l = 0;
        int r = b.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            double sum = aVal + b.get(mid);

            if (sum == target){
                return sum;
            }

            if (Math.abs(sum - target) < Math.abs(closest - target)){
                closest = sum;
            }
            else if (Math.abs(sum - target) == Math.abs(closest - target)){
                if (sum < closest)
                    closest = sum;
            }

            if (sum < target)
                l = mid + 1;
            else
                r = mid - 1;
        }

        return closest;
    }
}

