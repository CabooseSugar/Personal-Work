import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int z = 0; z < n; z++) {
            String num1 = sc.next();
            String op = sc.next();
            String num2 = sc.next();
            sc.next();
            String res = sc.next();

            char[] num1Arr = num1.toCharArray();
            char[] num2Arr = num2.toCharArray();
            char[] resArr = res.toCharArray();
            char highestChar = num1Arr[0];

            boolean onlyOnes = true;
            for (char c : num1Arr) {
                if (c > highestChar) {
                    highestChar = c;
                }
                if (c != '1'){
                    onlyOnes = false;
                }
            }
            for (char c : num2Arr) {
                if (c > highestChar) {
                    highestChar = c;
                }
                if (c != '1'){
                    onlyOnes = false;
                }
            }
            for (char c : resArr) {
                if (c > highestChar) {
                    highestChar = c;
                }
                if (c != '1'){
                    onlyOnes = false;
                }
            }

            int asInt;

            if (highestChar >= 'a' && highestChar <= 'z') {
                asInt = (int) (highestChar - 87);
            } else {
                asInt = (int) highestChar - 48;
            }

            boolean foundOne = false;

            if (!(highestChar == '1') || ((highestChar == '1') && !onlyOnes)) {
                asInt++;
            }
            for (int i = asInt; i <= 36; i++) {

                int num1Conv = convertToInt(num1Arr, i);
                int num2Conv = convertToInt(num2Arr, i);
                int resConv = convertToInt(resArr, i);

                double total;

                if (op.equals("+")) {
                    total = num1Conv + num2Conv;
                } else if (op.equals("-")) {
                    total = num1Conv - num2Conv;
                } else if (op.equals("*")) {
                    total = num1Conv * num2Conv;
                } else {
                    double num1ConvD = (double)num1Conv;
                    double num2ConvD = (double)num2Conv;
                    total = num1ConvD / num2ConvD;
                }

                if (total == (double)resConv) {
                    foundOne = true;
                    if (i >= 10 && i <= 35) {
                        char temp = (char) ('A' + i + 22);
                        System.out.print(temp);
                    } else if (i == 36) {
                        System.out.print(0);
                    } else {
                        System.out.print(i);
                    }
                }
            }

            if (!foundOne) {
                System.out.print("invalid");
            }
            System.out.println();
        }
    }

    private static int convertToInt(char[] arr, int base) {
        int result = 0;
        int index = 0;
        for (int i = (arr.length - 1); i >= 0; i--){
            int num;
            char temp = arr[index];
            if (temp >= 'a' && temp <= 'z'){
                num = (int)(temp - 87);
            }
            else{
                num = (int)temp - 48;
            }
            index++;

            result += (num * (Math.pow(base, i)));
        }
        return result;
    }
}
