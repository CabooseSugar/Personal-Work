import java.util.*;

public class Solution3 {

    int numOfCoin;
    int numOfQuery;
    int maxCoin;
    int[] coins;
    int[] queries;
    Solution3(int numOfCoin, int numOfQuery, int[] coins, int[] queries){
        this.numOfCoin = numOfCoin;
        this.numOfQuery = numOfQuery;
        this.coins = coins;
        this.queries = queries;
        this.maxCoin = coins[numOfCoin - 1];
    }

    public static void main(String[] args) {
        Solution3 coinInfo = Initialize();
        int[] temp = CopyAndSortQuery(coinInfo.numOfQuery, coinInfo.queries);
        int maxQuery = temp[coinInfo.numOfQuery - 1];
        Map<Integer, Integer> map = new HashMap<>();

        if (coinInfo.numOfCoin == 1){
            for (int i = 0; i < coinInfo.numOfQuery; i++){
                map.put(temp[i], 1);
            }
        }

        else{
            for (int i = 1; i <= maxQuery; i++){
                Count(coinInfo.numOfCoin, i, coinInfo.coins, map);
            }
        }

        for (int i = 0; i < coinInfo.numOfQuery; i++){
            System.out.println(map.get(coinInfo.queries[i]));
        }
    }

    static void Count(int numOfCoin, int query, int[] coins, Map<Integer, Integer> map){
        double count = 0;
        double denom = (Math.pow(10,9) + 7);

        for (int i = 0; i < numOfCoin; i++){
            if (coins[i] <= query){
                int diff = query - coins[i];
                if (diff == 0) count += 1;
                else count = (count + (double)map.get(diff)) % denom;
            }
            else break;
        }

        map.put(query, (int)count);
    }

    static int[] CopyAndSortQuery(int size, int[] arr){
        int[] temp = new int[size];
        System.arraycopy(arr, 0, temp, 0, size);
        Arrays.sort(temp);
        return temp;
    }

    static Solution3 Initialize(){
        int numOfCoin;
        int numOfQuery;
        int[] coins;
        int[] queries;

        Scanner sc = new Scanner(System.in);
        numOfCoin = sc.nextInt();
        coins = new int[numOfCoin];
        for (int i = 0; i < numOfCoin; i++){
            coins[i] = sc.nextInt();
        }
        numOfQuery = sc.nextInt();
        queries = new int[numOfQuery];
        for (int i = 0; i < numOfQuery; i++){
            queries[i] = sc.nextInt();
        }
        sc.close();

        Arrays.sort(coins);

        Solution3 coinInfo = new Solution3(numOfCoin, numOfQuery, coins, queries);

        return coinInfo;
    }
}
