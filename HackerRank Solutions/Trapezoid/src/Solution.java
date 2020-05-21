import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true){
            int n = sc.nextInt();
            if (n == 0){
                return;
            }

            List<double[]> stones = new ArrayList<>();
            for (int i = 0; i < n; i++){
                double[] dim = new double[3];
                dim[0] = sc.nextDouble();
                dim[1] = sc.nextDouble();
                dim[2] = sc.nextDouble();
                stones.add(dim);
            }

            double porch = sc.nextDouble();
            double gaz = sc.nextDouble();

            double cheapest = Integer.MAX_VALUE;
            boolean first = true;
            double result = findCheapest(stones, porch, gaz, 0, cheapest, first, -1);
            System.out.printf("%.2f", result);
            System.out.println();

        }
    }

    private static double findCheapest(List<double[]> stones, double porch, double gaz, double currentPrice, double cheapest, boolean first, double nextSide) {
        if (porch == gaz){
            return 0;
        }

        if (nextSide == gaz){
            if (currentPrice < cheapest){
                cheapest = currentPrice;
            }
            return cheapest;
        }

        double price;

        if (first){
            for (double[] stone : stones){
                if (stone[0] == porch){
                    List<double[]> stonesCopy = new ArrayList<>(stones);
                    price = getPrice(stone);
                    double sum = currentPrice + price;
                    stonesCopy.remove(stone);
                    double temp = findCheapest(stonesCopy, porch, gaz, sum, cheapest, false, stone[1]);
                    if (temp < cheapest){
                        cheapest = temp;
                    }
                }
                else if (stone[1] == porch){
                    List<double[]> stonesCopy = new ArrayList<>(stones);
                    price = getPrice(stone);
                    double sum = currentPrice + price;
                    stonesCopy.remove(stone);
                    double temp = findCheapest(stonesCopy, porch, gaz, sum, cheapest, false, stone[0]);
                    if (temp < cheapest){
                        cheapest = temp;
                    }
                    stones.remove(stone);
                }
            }
        }

        else{
            for (double[] stone : stones){
                if (stone[0] == nextSide){
                    List<double[]> stonesCopy = new ArrayList<>(stones);
                    price = getPrice(stone);
                    double sum = currentPrice + price;
                    stonesCopy.remove(stone);
                    double temp = findCheapest(stonesCopy, porch, gaz, sum, cheapest, false, stone[1]);
                    if (temp < cheapest){
                        cheapest = temp;
                    }
                }
                else if (stone[1] == nextSide){
                    List<double[]> stonesCopy = new ArrayList<>(stones);
                    price = getPrice(stone);
                    double sum = currentPrice + price;
                    stonesCopy.remove(stone);
                    double temp = findCheapest(stonesCopy, porch, gaz, sum, cheapest, false, stone[0]);
                    if (temp < cheapest){
                        cheapest = temp;
                    }
                }
            }

        }
        return cheapest;
    }

    private static double getPrice(double[] stone) {
        double sum = stone[0] + stone[1];
        sum *= stone[2];
        sum *= 0.5;
        sum *= 0.02;
        return sum;
    }


}
