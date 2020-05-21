import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();

        List<Integer> validAs = new ArrayList<>();
        List<Integer> validBs = new ArrayList<>();
        for (int i = 2; i <= s / 2 + 1; i++){
            int a = i;
            int b = i - 1;

            if (validChecker(s,a,b)){
                validAs.add(a);
                validBs.add(b);
            }

            b += 1;

            if (validChecker(s,a,b)){
                validAs.add(a);
                validBs.add(b);
            }
       }

       System.out.println(s + ":");

       for (int i = 0; i < validAs.size(); i++){
           System.out.print(validAs.get(i) + "," + validBs.get(i));
           System.out.println();
       }


    }


    public static boolean validChecker(int s, int a, int b){
        for (int i = 1; i < s - 2; i++){ // ?? -2 tight?
            if (a * i  + b * (i-1) == s){
                return true;
            }
            else if(a * i + b * i == s){
                return true;
            }
        }
        return false;
    }
}
