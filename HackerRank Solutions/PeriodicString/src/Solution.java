import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        // split line
        // cut off at half, if goes beyond then answer will just be length of string
        // mod % has to = 0 or know will be invalid

        int index = 0;
        String[] partitions = new String[line.length()];
        for (int i = 1; i < line.length() / 2 + 1; i++){
            if (line.length() % i != 0) {
                continue;
            }
            String temp = line.substring(0, i);
            partitions[index] = temp;
            index++;
        }

        for(String s: partitions){
            if (s == null){
                break;
            }
            if (checker(s, line)){
                System.out.println(s.length());
                return;
            }

        }

        // default
        System.out.println(line.length());
    }

    static boolean checker(String s, String line){
        for (int i = s.length(); i < line.length(); i += s.length()){
            String temp = line.substring(i, i + s.length());

            String sSort = sorter(s);
            String tempSort = sorter(temp);
            if (!sSort.equals(tempSort)){
                return false;
            }

            if ((s.toCharArray()[s.length() - 1] != temp.toCharArray()[0])){
                return false;
            }
            s = temp;
        }
        return true;
    }

    static String sorter(String s){
        char[] cArr = s.toCharArray();
        Arrays.sort(cArr);
        return new String (cArr);
    }
}
