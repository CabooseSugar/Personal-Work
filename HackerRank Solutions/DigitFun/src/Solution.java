import java.util.Scanner;
import java.lang.Math;


public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLong()){
            long line = sc.nextLong();
            if (line == 0)
                System.out.println(2);
            else {
                long answ = recurs(line, 0);
                System.out.println(answ);
            }
        }

    }

    static long recurs(long num, long i){
        if (num == countDigits(num)){
            return i + 1;
        }

        long newNum = countDigits(num);
        return recurs(newNum, i + 1);
    }

    static long countDigits(long n){
        long temp = n;
        long c = 0;
        while(temp > 0){
            temp = temp / 10;
            c++;
        }
        return c;
    }
}
