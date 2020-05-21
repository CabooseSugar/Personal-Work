import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        if (n == 0){
            return;
        }
        sc.nextLine();
        List<Character> cards1 = new ArrayList<>();
        List<Character> cards2 = new ArrayList<>();
        for (int i = 0; i < n; i++){
            cards1.add(sc.next().toCharArray()[0]);
        }
        for (int i = 0; i < n; i++){
            cards2.add(sc.next().toCharArray()[0]);
        }

        System.out.println(getMax(cards1, cards2, 0));


    }

    static int getMax(List<Character> cards1, List<Character> cards2, int max){
        if (cards1.size() == 0 || cards2.size() == 0){
            return max;
        }

        if (matching(cards1, cards2)){
            int val = checkVal(cards1, cards2);
            if (val > max){
                max = val;
            }
        }

        for (int i = 0; i < cards1.size(); i++){
            List<Character> temp1 = new ArrayList<>();
            temp1.addAll(cards1);
            temp1.remove(i);
            for (int j = 0; j < cards2.size(); j++){
                List<Character> temp2 = new ArrayList<>();
                temp2.addAll(cards2);
                temp2.remove(j);
                int tempMax = getMax(temp1, temp2, max);
                if (tempMax > max){
                    max = tempMax;
                }
            }
        }

        return max;
    }

    static boolean matching(List<Character> cards1, List<Character> cards2){
        if (cards1.size() != cards2.size()) {
            return false;
        }
        for (int i = 0; i < cards1.size(); i++){
            if (cards1.get(i) != cards2.get(i) && (cards1.get(i) != 'R' && cards2.get(i) != 'R')){
                return false;
            }
        }
        return true;
    }

    static int checkVal(List<Character> cards1, List<Character> cards2){
        int sum = 0;

        for (int i = 0; i < cards1.size(); i++){
            if (cards1.get(i) == 'R' && cards2.get(i) == 'R'){
                sum += 100;
            }
            else if ((cards1.get(i) == 'R' && cards2.get(i) == 'T') || (cards2.get(i) == 'R' && cards1.get(i) == 'T')){
                sum += 20;
            }
            else if ((cards1.get(i) == 'R' && cards2.get(i) == 'A') || (cards2.get(i) == 'R' && cards1.get(i) == 'A')){
                sum += 40;
            }
            else if ((cards1.get(i) == 'R' && Character.isLetter(cards2.get(i))) || (cards2.get(i) == 'R' && Character.isLetter(cards1.get(i)))){
                sum += 30;
            }
            else if (cards1.get(i) == 'R' && Character.isDigit(cards2.get(i))) {
                sum  += (int) (cards2.get(i) - 48) * 2;
            }
            else if (cards2.get(i) == 'R' && Character.isDigit(cards1.get(i))){
                sum  += (int) (cards1.get(i) - 48) * 2;
            }
            else if (cards1.get(i) == 'T'){
                sum += 20;
            }
            else if (cards1.get(i) == 'A'){
                sum += 40;
            }
            else if (Character.isLetter(cards1.get(i))){
                sum += 30;
            }
            else if (Character.isDigit(cards1.get(i))){
                sum += (int) (cards1.get(i) - 48) * 2;
            }
        }

        return sum;
    }
}
