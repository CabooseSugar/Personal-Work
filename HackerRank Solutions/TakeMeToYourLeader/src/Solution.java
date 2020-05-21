import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        Map<String, Set<String>> leaderMap = new HashMap<>();
        for (int i = 0; i < n; i++){
            String follower = sc.next();
            String boss = sc.next();

            if (leaderMap.containsKey(boss)){
                leaderMap.get(boss).add(follower);
            }
            else{
                Set<String> followers = new HashSet<>();
                followers.add(follower);
                leaderMap.put(boss, followers);
            }
        }

        boolean changeMade;
        do {
            List<String> absorbedLeaders = new ArrayList<>();
            changeMade = false;
            for (String b : leaderMap.keySet()){
                for (String nb : leaderMap.keySet()){
                    if (leaderMap.get(b).contains(nb)){
                        leaderMap.get(b).addAll(leaderMap.get(nb));
                        absorbedLeaders.add(nb);
                        changeMade = true;
                    }
                }
            }
            for (int j = 0; j < absorbedLeaders.size(); j++){
                leaderMap.remove(absorbedLeaders.get(j));
            }
        } while (changeMade);


        String mostF = (String) leaderMap.keySet().toArray()[0];
        int biggest = leaderMap.get(mostF).size();
        for (String b: leaderMap.keySet()){
            if (leaderMap.get(b).size() > biggest) {
                mostF = b;
                biggest = leaderMap.get(b).size();
            }
        }

        for (String b: leaderMap.keySet()){
            if (leaderMap.get(b).size() == biggest && b.compareTo(mostF) < 0){
                mostF = b;
            }
        }

        System.out.println(mostF);

    }
}
