import java.util.*;

public class Solution {

    public static class Station{
        String name;
        List<Station> connections;

        public Station(String name) {
            this.name = name;
            connections = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public List<Station> getConnections() {
            return connections;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        List<Station> stations = new ArrayList<>();

        for (int i = 0; i < n; i++){
            String line = sc.nextLine();
            String[] data = line.split(" ");

            Station curr = null;

            boolean isIn1 = false;
            for (Station stat: stations){
                if (stat.name.equals(data[0])){
                    isIn1 = true;
                    curr = stat;
                    break;
                }
            }
            if (!isIn1){
                curr = new Station(data[0]);
                stations.add(curr);
            }

            for (int j = 1; j < data.length; j++){
                boolean isIn2 = false;
                for (Station stat: stations){
                    if (stat.name.equals(data[j])){
                        isIn2 = true;
                        if (!curr.getConnections().contains(stat)) {
                            curr.getConnections().add(stat);
                        }
                        if (!stat.getConnections().contains(curr)) {
                            stat.getConnections().add(curr);
                        }
                        break;
                    }
                }
                if (!isIn2) {
                    Station neigh = new Station(data[j]);
                    stations.add(neigh);
                    if (!curr.getConnections().contains(neigh)) {
                        curr.getConnections().add(neigh);
                    }
                    if (!neigh.getConnections().contains(curr)) {
                        neigh.getConnections().add(curr);
                    }
                }
            }
        }

        String line = sc.nextLine();
        String[] data = line.split(" ");
        String s = data[0];
        String e = data[1];

        Station start = null;
        Station end = null;

        boolean startNotFound = true;
        boolean endNotFound = true;
        for (Station stat: stations){
            if (stat.name.equals(s)){
                start = stat;
                startNotFound = false;
            }
            if (stat.name.equals(e)){
                end = stat;
                endNotFound = false;
            }
        }

        if (startNotFound || endNotFound){
            System.out.println("no route found");
            return;
        }


        List<Station> path = new ArrayList<>();
        List<Station> finalPath = new ArrayList<>();

        findPath(start, end, path, finalPath);

        if (finalPath.size() == 0){
            System.out.println("no route found");
            return;
        }

        for (Station stat : finalPath){
            System.out.print(stat.name + " ");
        }
    }

    private static void findPath(Station start, Station end, List<Station> path, List<Station> finalPath) {
        path.add(start);

        if (start.name.equals(end.name)){
            for (Station stat : path){
                finalPath.add(stat);
            }
            return;
        }

        List<Station> neighbors = start.getConnections();

        for (Station n : neighbors){
            if (path.contains(n)){
                continue;
            }
            List<Station> newPath = new ArrayList<>(path);
            findPath(n, end, newPath, finalPath);
        }
    }
}
