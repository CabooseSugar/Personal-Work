import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Character> list = new ArrayList<>();
        Scanner sc = new Scanner( System.in ).useDelimiter("(\\b|\\B)");
        while(sc.hasNext()) {
            String item = sc.next();
            char[] cArr = item.toCharArray();
            for (char c: cArr){
                if (c == '\n')
                    continue;
                list.add(c);
            }
        }

        ArrayList<Character> decodedFirst = new ArrayList<>();
        ArrayList<Character> decodedSecond = new ArrayList<>();

        for (int i = 0; i < list.size() / 2 + 1; i++){
            decodedFirst.add(list.get(i));
        }

        for (int i = list.size() / 2 + 1; i < list.size(); i++){
            decodedSecond.add(list.get(i));
        }

        while(!decodedFirst.isEmpty() || !decodedSecond.isEmpty()){
            if (!decodedFirst.isEmpty()){
                if (decodedFirst.get(0) == '*'){
                    System.out.print('\n');
                }
                else {
                    System.out.print(decodedFirst.get(0));
                }
                decodedFirst.remove(0);
            }
            if (!decodedSecond.isEmpty()){
                if(decodedSecond.get(0) == '*'){
                    System.out.print('\n');
                }
                else {
                    System.out.print(decodedSecond.get(0));
                }
                decodedSecond.remove(0);
            }
        }








    }
}
