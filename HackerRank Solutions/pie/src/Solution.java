import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        for (int z = 0; z < p; z++){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int tax[] = new int[N];

            List<List<Integer>> allPrices = new ArrayList<>();
            List<List<Integer>> allOrigPrices = new ArrayList<>();
            for (int i = 1; i <= N; i++){
                List<Integer> origPrices = new ArrayList<>();
                List<Integer> prices = new ArrayList<>();
                for (int j = 1; j <= M; j++){
                    int temp = sc.nextInt();
                    origPrices.add(temp);
                    prices.add(temp + 1); // + 1 for initial tax
                }
                Collections.sort(origPrices);
                Collections.sort(prices);
                allOrigPrices.add(origPrices);
                allPrices.add(prices);
                tax[i - 1] = 1;
            }

            Map<Integer, List<Integer>> boughtPies = new HashMap<>();
            int bought = 0;
            int sum = 0;
            while(bought < N){
                int currCheapest = Integer.MAX_VALUE;
                int cheapestLocale = 0;
                for (int i = 0; i < (bought + 1); i++){
                    if (allPrices.get(i).size() == 0){}
                    else if (allPrices.get(i).get(0) < currCheapest){
                        currCheapest = allPrices.get(i).get(0);
                        cheapestLocale = i;
                    }
                }

                if (boughtPies.containsKey(cheapestLocale + 1)) {
                    boughtPies.get(cheapestLocale + 1).add(allOrigPrices.get(cheapestLocale).get(0));
                }
                else{
                    boughtPies.put(cheapestLocale + 1, new ArrayList<>());
                    boughtPies.get(cheapestLocale + 1).add(allOrigPrices.get(cheapestLocale).get(0));
                }

                for (int i = 1; i < allPrices.get(cheapestLocale).size(); i++){
                    int price = allOrigPrices.get(cheapestLocale).get(i);
                    price += (int)Math.pow(tax[cheapestLocale] + 1, 2);
                    price -= (int)Math.pow(tax[cheapestLocale], 2);
                    allPrices.get(cheapestLocale).set(i, price);
                }
                tax[cheapestLocale]++;
                allPrices.get(cheapestLocale).remove(0);
                allOrigPrices.get(cheapestLocale).remove(0);

                bought++;
            }

            for(Integer day : boughtPies.keySet()){
                int pow = boughtPies.get(day).size();
                for (int i = 0; i < boughtPies.get(day).size(); i++){
                    sum += boughtPies.get(day).get(i);
                }
                sum += (int)Math.pow(pow, 2);
            }

            System.out.println("Case #" + (z + 1) + ": " + sum);
        }


    }
}









