import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> map = new HashMap<>();
        while(scanner.hasNext()){
            String team1 = scanner.next();
            int score1 = scanner.nextInt();
            String team2 = scanner.next();
            int score2 = scanner.nextInt();
            if(scanner.hasNext())
                scanner.nextLine();

            if (score1 > score2){
                if (map.containsKey(team2)){
                    map.put(team2, map.get(team2) + 1);
                }
                else{
                    map.put(team2, 1);
                }
                if (!map.containsKey(team1)){
                    map.put(team1, 0);
                }
            }
            else {
                if (map.containsKey(team1)){
                    map.put(team1, map.get(team1) + 1);
                }
                else{
                    map.put(team1, 1);
                }
                if (!map.containsKey(team2)){
                    map.put(team2, 0);
                }
            }

        }

        List<String> winningTeams = new ArrayList<>();
        for (String key : map.keySet()){
            if (map.get(key) == 0){
                winningTeams.add(key);
            }
        }
        Collections.sort(winningTeams);

        for (String team: winningTeams){
            System.out.println(team);
        }



    }
}
