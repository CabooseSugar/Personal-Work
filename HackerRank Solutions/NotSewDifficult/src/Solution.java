import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int n = sc.nextInt();
            if (n < 0)
                return;

            int biggestX = 10000 ;
            int biggestY = 10000;
            int max = 0;
            int[][] board = new int[biggestX][biggestY];
            for (int z = 0; z < n; z++){
                int x1 = sc.nextInt();
                int y1 = sc.nextInt();
                int x2 = sc.nextInt();
                int y2 = sc.nextInt();

                if (x1 == x2 || y1 == y2){
                    continue;
                }

                if (x1 <= x2 && y1 <= y2){
                    for (int i = x1; i <= x2; i++) {
                        for (int j = y1; j <= y2; j++) {
                            board[i][j]++;
                            if (board[i][j] > max)
                                max = board[i][j];
                        }
                    }
                }

                if (x1 > x2 && y1 <= y2){
                    for (int i = x2; i <= x1; i++) {
                        for (int j = y1; j <= y2; j++) {
                            board[i][j]++;
                            if (board[i][j] > max)
                                max = board[i][j];
                        }
                    }
                }

                if (x1 <= x2 && y1 > y2){
                    for (int i = x1; i <= x2; i++) {
                        for (int j = y2; j <= y1; j++) {
                            board[i][j]++;
                            if (board[i][j] > max)
                                max = board[i][j];
                        }
                    }
                }

                if (x1 > x2 && y1 > y2){
                    for (int i = x2; i <= x1; i++) {
                        for (int j = y2; j <= y1; j++) {
                            board[i][j]++;
                            if (board[i][j] > max)
                                max = board[i][j];
                        }
                    }
                }

            }

            System.out.println(max);



        }
    }
}
