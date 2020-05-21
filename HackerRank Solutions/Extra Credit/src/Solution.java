import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        while(n != 0) {
            int W = sc.nextInt();
            int Q = sc.nextInt();

            int[][] points = new int[W][Q];
            for (int i = 0; i < W; i++) {
                for (int j = 0; j < Q; j++) {
                    points[i][j] = sc.nextInt();
                }
            }

            int[][] extra = new int[Q][Q];
            for (int i = 0; i < Q; i++) {
                for (int j = 0; j < Q; j++) {
                    extra[i][j] = sc.nextInt();
                }
            }


            List<Integer> maxPoints = new ArrayList<>();
            maxPoints.add(0);
            for (int i = 0; i < points[0].length; i++) {
                int question = i;
                int week = 0;
                int prevQuestion = -1;
                int currPoints = 0;
                findMax(points, extra, week, question, prevQuestion, currPoints, maxPoints);
            }

            System.out.println(maxPoints.get(0));
            n--;
        }
    }

    private static void findMax(int[][] points, int[][] extra, int week, int question, int prevQuestion, int currPoints, List<Integer> maxPoints) {
        if (prevQuestion != -1) {
            currPoints = currPoints + points[week][question] + extra[question][prevQuestion];
        }
        else {
            currPoints = currPoints + points[week][question];
        }
        prevQuestion = question;

        if (week == points.length - 1){
            if (currPoints > maxPoints.get(0)){
                maxPoints.remove(0);
                maxPoints.add(currPoints);
            }
            return;
        }

        for (int j = question; j < points[0].length; j++){
            int tempCurrPoints = currPoints;
            findMax(points, extra, week + 1, j, prevQuestion, tempCurrPoints, maxPoints);
        }


    }
}
