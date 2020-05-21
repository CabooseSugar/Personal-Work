import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = sc.next();
        String op = sc.next();
        String num2 = sc.next();
        sc.next();
        String equals = sc.next();

        for (int i = 1; i < 37; i++){
            
        }



    }

    static Integer convertBase(int num, int radix) {

        List<Integer> remainder = new ArrayList<>();

        int count = 0;
        String result = "";
        while(num != 0)
        {
            remainder.add( count, num % radix != 0 ? num % radix : 0 );
            num /= radix;
            result += remainder.get(count);
        }
        return new Integer(new StringBuffer(result).reverse().toString());

    }
}
