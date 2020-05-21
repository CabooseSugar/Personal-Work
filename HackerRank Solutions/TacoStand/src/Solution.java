import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int days = sc.nextInt();
        while (days != 0){
            int shells = sc.nextInt();
            int meat = sc.nextInt();
            int rice = sc.nextInt();
            int beans = sc.nextInt();

            int[] ingredients = {meat, rice, beans};
            Arrays.sort(ingredients);
            int highestInd = 2;
            int nextHighestInd = 1;
            int remainerInd = 0;

            int numTacos = 0;
            while (shells != 0){
                if (ingredients[highestInd] != 0 && ingredients[nextHighestInd] != 0){
                    ingredients[highestInd]--;
                    ingredients[nextHighestInd]--;
                    numTacos++;

                    if (ingredients[remainerInd] > ingredients[highestInd]){
                        int temp1 = highestInd;
                        int temp2 = nextHighestInd;
                        highestInd = remainerInd;
                        nextHighestInd = temp1;
                        remainerInd = temp2;
                    }
                    else if (ingredients[remainerInd] > ingredients[nextHighestInd]){
                        int temp = nextHighestInd;
                        nextHighestInd = remainerInd;
                        remainerInd = temp;
                    }

                }
                else {
                    break;
                }
                shells--;
            }

            System.out.println(numTacos);
            days--;
        }
    }
}
