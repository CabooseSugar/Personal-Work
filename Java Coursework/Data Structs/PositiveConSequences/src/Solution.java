import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner keyboard = new Scanner(System.in);
        boolean isEnd;
        int difference;
        int[] seq = new int[4];

        while(true) {
            isEnd = true;
            // fill up the sequence array
            for (int i = 0; i < 4; i++)
                seq[i] = keyboard.nextInt();

            // check for all -1's, thus ending program
            for(int i = 0; i < 4; i++) {
                if(seq[i] != -1) {
                    isEnd = false;
                    break;
                }
            }

            if (isEnd)
                return;

            // if first number is missing
            if (seq[0] == -1) {
                difference = seq[3] - seq[2];
                if (difference != seq[2] - seq[1]) {
                    if (difference % (seq[2] - seq[1]) == 0 && seq[1] - difference / (seq[2] - seq[1]) > 0)
                        System.out.println(seq[1] - difference / (seq[2] - seq[1]));
                    else
                        System.out.println(-1);
                }
                else if (seq[1] - difference < 1)
                    System.out.println(-1);
                else
                    System.out.println(seq[1] - difference);
            }

            // if second number is missing
            else if (seq[1] == -1) {
                difference = seq[3] - seq[2];
                if (seq[0] + difference != seq[2] - difference) {
                    if (geometricCheck1(seq, difference)) {}
                    else
                        System.out.println(-1);
                }
                else if (seq[2] - difference < 1)
                    System.out.println(-1);
                else
                    System.out.println(seq[2] - difference);
            }
            // if third number is missing
            else if (seq[2] == -1){
                difference = seq[1] - seq[0];
                if (seq[1] + difference != seq[3] - difference) {
                    if (geometricCheck2(seq, difference)) {}
                    else
                        System.out.println(-1);
                }
                else if (seq[3] - difference < 1)
                    System.out.println(-1);
                else
                    System.out.println(seq[3] - difference);

            }
            // if last number is missing
            else {
                difference = seq[1] - seq[0];
                if (difference != seq[2] - seq[1]) {
                    if ((seq[2] - seq[1]) % difference == 0 && seq[2] + difference * (seq[2] - seq[1]) > 0)
                        System.out.println(seq[2] + difference * (seq[2] - seq[1]));
                    else
                        System.out.println(-1);
                }
                else if (seq[2] + difference < 1)
                    System.out.println(-1);
                else
                    System.out.println(seq[2] + difference);
            }
        }
    }

    public static boolean geometricCheck1(int[] seq, int difference) {
        for (int i = 2; i < 100; i++) {
            if (seq[0] + difference / i / i == seq[2] - difference / i) {
                if (seq[2] - difference / i < 1) {
                    System.out.println(-1);
                    return true;
                }
                System.out.println(seq[2] - difference / i);
                return true;
            }
        }
        return false;
    }

    public static boolean geometricCheck2(int[] seq, int difference) {
        for (int i = 2; i < 100; i++) {
            if (seq[1] + difference * i  == seq[2] - difference * i * i) {
                if (seq[1] + difference * i < 1){
                    System.out.println(-1);
                    return true;
                }
                System.out.println(seq[1] + difference * i);
                return true;
            }
        }
        return false;
    }
}
