import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for(int z = 0; z < cases; z++){
            int n = sc.nextInt();
            int[] items = new int[n];
            for (int i = 0; i < n; i++){
                items[i] = sc.nextInt();
            }
            Arrays.sort(items);
            int highestB4 = -1;
            for (int i = 0; i < n; i++){
                if (items[i] < 50){
                    highestB4 = i;
                }
                if (items[i] >= 50){
                    break;
                }
            }

            if (highestB4 == -1){
                System.out.println("Case #" + (z+1) + ": " + n);
                continue;
            }

            int trips = 0;
            int index = 0;
            int fardex = highestB4;
            int used50counter = 0;
            int[] used = new int[n];
            for(int i = 0; i < n; i++){
                used[i] = 0;
            }

            while(index != fardex){
                int sum = items[fardex];
                used[fardex] = 1;
                while (sum < 50){
                    sum += items[fardex];
                    used[index] = 1;
                    index++;
                    if (index == fardex && sum < 50){
                        used50counter++;
                        sum += 50;
                        break;

                    }
                    if (index == fardex && sum >= 50){
                        break;
                    }
                }
                trips++;
                fardex--;
                if (fardex < index){ // means went through one of two above ifs
                    break;
                }
                if (fardex == index && used[index] == 0){
                    used50counter++;
                    trips++;
                    break;
                }
            }

            trips += (n - highestB4) - used50counter - 1;
            System.out.println("Case #" + (z+1) + ": " + trips);
        }


    }
}
