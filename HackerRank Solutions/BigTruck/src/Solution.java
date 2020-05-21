import java.util.*;

public class Solution {

    public static class City {
        int num;
        int stuff;
        List<int[]> roads;

        public City(int num, int stuff) {
            this.num = num;
            this.stuff = stuff;
            this.roads = new ArrayList<>();
        }

        public List<int[]> getRoads() {
            return roads;
        }

        public int getStuff() {
            return stuff;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<City> cities = new ArrayList<>();

        int c = sc.nextInt();
        for (int i = 0; i < c; i++) {
            cities.add(new City(i + 1, sc.nextInt()));
        }

        int r = sc.nextInt();
        for (int i = 0; i < r; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int d = sc.nextInt();

            int[] road = new int[2];
            road[0] = b;
            road[1] = d;
            cities.get(a - 1).getRoads().add(road);

            int[] revRoad = new int[2];
            revRoad[0] = a;
            revRoad[1] = d;
            cities.get(b - 1).getRoads().add(revRoad);
        }

        List<Integer> path = new ArrayList<>();
        Map<List<Integer>, Integer> allPaths = new HashMap<>();
        getAllPaths(cities, 1, path, 0, allPaths);

        if (allPaths.size() == 0){
            System.out.println("impossible");
            return;
        }

        int lowest = Integer.MAX_VALUE;
        for (List<Integer> l : allPaths.keySet()){
            if (allPaths.get(l) < lowest){
                lowest = allPaths.get(l);
            }
        }

        List<List<Integer>> allLowests = new ArrayList<>();

        for (List<Integer> l : allPaths.keySet()){
            if (allPaths.get(l) == lowest){
                allLowests.add(l);
            }
        }

        int dist = -1;
        int highestSum = -1;
        for (List<Integer> l: allLowests){
            int sum = 0;
            for (Integer i : l){
                sum += cities.get(i -1).getStuff();
            }
            if (sum > highestSum){
                highestSum = sum;
                dist = allPaths.get(l);
            }
        }

        System.out.println(dist + " " + highestSum);

    }


    private static void getAllPaths(List<City> cities, int start, List<Integer> path, int dist, Map<List<Integer>, Integer> allPaths) {

        path.add(start);

        if (start == cities.size()){
            if (allPaths.containsKey(path)){
                if (allPaths.get(path) > dist){
                    allPaths.put(path, dist);
                }
            }
            else{
                allPaths.put(path, dist);
            }
            return;
        }

        for (int i = 0; i < cities.get(start - 1).getRoads().size(); i++){
            int[] r = cities.get(start - 1).getRoads().get(i);
            if (!path.contains(r[0])){
                List<Integer> tempPath = new ArrayList<>(path);
                getAllPaths(cities, r[0], tempPath, dist + r[1], allPaths);
            }
        }

    }
}