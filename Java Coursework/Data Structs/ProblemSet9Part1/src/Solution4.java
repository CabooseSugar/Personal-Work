import java.util.*;

public class Solution4 {

    int numOfCoin;
    int numOfQuery;
    int queryIdx;
    int maxCoin;
    int[] coins;
    int[] queries;
    int[] countArr;
    Solution4(int numOfCoin, int numOfQuery, int[] coins, int[] queries){
        this.numOfCoin = numOfCoin; // d.length
        this.numOfQuery = numOfQuery;  // n
        this.coins = coins;          // d[]
        this.queries = queries;      // all qeuries
        this.queryIdx = 0;           // current queiry
        this.maxCoin = coins[numOfCoin - 1];  // highest coin value
        this.countArr = new int[maxCoin];    // new array size of highest coin value
    }

    public static void main(String[] args) {
        Solution4 coinInfo = Initialize();
        int[] temp = CopyAndSortQuery(coinInfo.numOfQuery, coinInfo.queries);
        int maxQuery = temp[coinInfo.numOfQuery - 1];
        Map<Integer, Integer> map = new HashMap<>();

        // if only have 1 denom
        if (coinInfo.numOfCoin == 1){
            // for every query, put an answer of 1
            for (int i = 0; i < coinInfo.numOfQuery; i++){
                map.put(temp[i], 1);
            }
        }

        // if have multiple denoms
        else{
            for (int i = 1; i <= maxQuery; i++){
                Count(coinInfo.numOfCoin, i, coinInfo.coins, coinInfo.countArr);
                if (i == temp[coinInfo.queryIdx]){
                    map.put(i, coinInfo.countArr[(i - 1) % coinInfo.maxCoin]);
                    coinInfo.queryIdx++;
                }
            }
        }

        for (int i = 0; i < coinInfo.numOfQuery; i++){
            System.out.println(map.get(coinInfo.queries[i]));
        }
    }

    static void Count(int numOfCoin, int query, int[] coins, int[] countArr){
        int size = countArr.length; // = highest coin value
        double count = 0;
        double denom = (Math.pow(10,9) + 7);

        for (int i = 0; i < numOfCoin; i++){ // d.length
            if (coins[i] <= query){         // if d[i] <= amt
                int diff = query - coins[i]; // diff = amt - d[i]
                if (diff == 0) count += 1;    // if you hit 0 you add one to count
                else count = (count + (double)countArr[(diff - 1) % size]) % denom; // else, count = count +
            }                                                                           // 50 highest 30, diff 20, because of 1's combo?
            else break; // if you go over, stop
        }
        countArr[(query - 1) % size] = (int)count; // putting that query shit in there
    }

    static int[] CopyAndSortQuery(int size, int[] arr){
        int[] temp = new int[size];
        System.arraycopy(arr, 0, temp, 0, size);
        Arrays.sort(temp);
        return temp;
    }

    static Solution4 Initialize(){
        int numOfCoin; //num Denoms
        int numOfQuery; //n
        int[] coins; // denoms
        int[] queries; // queries

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

        Solution4 coinInfo = new Solution4(numOfCoin, numOfQuery, coins, queries);

        return coinInfo;
    }
}
