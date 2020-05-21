import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++){
            int W = sc.nextInt();
            int Q = sc.nextInt();

            int points[][] = new int[W+1][Q+1];
            int extra[][] = new int[Q+1][Q+1];

            for (int j = 1; j <= W; j++){
                for (int k = 1; k <= Q; k++){
                    points[j][k] = sc.nextInt();
                }
            }

            for (int j = 1; j <= Q; j++){
                for (int k = 1; k <= Q; k++){
                    extra[j][k] = sc.nextInt();
                }
            }

            findSums(points, extra, 1);

        }
    }
}
