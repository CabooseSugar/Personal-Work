import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.floor;
import static java.lang.Math.min;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigDecimal sum = new BigDecimal("0.00000");
        sc.nextLine();

        while (n != 0) {
            String tempStr = sc.nextLine();
            BigDecimal temp = new BigDecimal(tempStr);
            sum = sum.add(temp);
            n--;
        }
        BigDecimal multi = new BigDecimal(".06");
        sum = sum.multiply(multi);
        String str = String.valueOf(sum);
        char[] ch = str.toCharArray();
        int decPlace = 0;
        boolean decFound = false;
        boolean allZerosAfter = true;
        for (int i = 0; i < ch.length; i++){
            if (ch[i] == '.'){
                decFound = true;
                decPlace = i;
                i += 2;
            }
            if (decFound){
                if (ch[i] != '0'){
                    allZerosAfter = false;
                    break;
                }
            }
        }

        if (!allZerosAfter){
            if (ch[decPlace + 2] != '9'){
                ch[decPlace + 2] += 1;
            }
            else {
                int i = decPlace + 2;
                ch[i] = '0';
                i--;
                while(true){
                    if (ch[i] == '.'){
                        i--;
                        continue;
                    }
                    if (ch[i] == '9'){
                        ch[i] = '0';
                        i--;
                        if (i == -1){
                            char[] newCh = Arrays.copyOf(ch, ch.length + 1);
                            newCh[0] = '1';
                            System.arraycopy(ch, 0, newCh, 1, ch.length);
                            ch = newCh;
                            decPlace += 1;
                            break;
                        }
                    }
                    else {
                        ch[i] += 1;
                        break;
                    }

                }
            }
        }

        System.out.print('$');
        for (int i = 0; i <= decPlace + 2; i++){
            System.out.print(ch[i]);
        }

    }
}
