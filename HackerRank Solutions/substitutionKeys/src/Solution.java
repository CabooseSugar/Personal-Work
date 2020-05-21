import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> memo = new HashMap<>();
        System.out.println(ways(n, n, 0, memo));


    }

    int ways(int n, int present, int not, Map<Integer, Integer> memo){
        if (n == 1 && present == 1)
            return 0;
        if (n == 1 && not == 1)
            return 1;

        int w = ways(n, not - 1)
    }
}
