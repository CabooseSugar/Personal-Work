import java.util.*;

public class Solution {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        int count = keyboard.nextInt();
        keyboard.nextLine();

        Map<String, ArrayList<String>> relationMap = new TreeMap<>();

        // will use these hashSets to find the roots of the trees - the top bosses of each gang
        Set<String> parents = new HashSet<>();
        Set<String> children = new HashSet<>();

        while (count != 0) {
            // <boss, underlings> where boss is the key
            String name = keyboard.next();
            String boss = keyboard.next();

            parents.add(boss);
            children.add(name);

            if (!relationMap.containsKey(boss))
                relationMap.put(boss, new ArrayList<String>());
            relationMap.get(boss).add(name);

            count--;
        }

        // if a name appears in parents but not in children, must be a root
        List<String> roots = new ArrayList<>();
        Iterator<String> iterator = parents.iterator();
        while (iterator.hasNext()) {
            String test = iterator.next();
            if (!children.contains(test))
                roots.add(test);
        }

        // as it is, relationMap only has leaders, and their DIRECT followers. Will need to count
        // indirect followers too for map below

        // this is a faster approach than original. Before, this for loop would go through every single
        // boss, whether they were the top boss of all or not. Now just getting those top bosses' (roots') number
        // of total followers. This TreeMap below will have much fewer keys in nearly all cases - in the case
        // of the example test case in HackerRank, just two: napoleon and aprile. Oof, madone.
        Map<String, Integer> followerCountMap = new TreeMap<>();
        for(int i=0; i < roots.size(); i++){
            followerCountMap.put(roots.get(i), getNumFollowers(relationMap, roots.get(i)));
        }

        // Calculates which of the very top bosses has the most total followers based on contents of newest TreeMap
        String largestFollowing = ((TreeMap<String, Integer>) followerCountMap).firstKey();
        for (int i = 1; i< followerCountMap.size(); i++){
            if (followerCountMap.get(followerCountMap.keySet().toArray()[i].toString()) >
            followerCountMap.get(largestFollowing))
                largestFollowing = followerCountMap.keySet().toArray()[i].toString();
        }

        System.out.println(largestFollowing);

    }

    static int getNumFollowers(Map<String, ArrayList<String>> map, String boss){
        int count = 0;
        if (!map.containsKey(boss)) // base case, has no bosses
            return count;

        count += map.get(boss).size();

        for (int i = 0; i < map.get(boss).size(); i++)
            count += getNumFollowers(map, map.get(boss).get(i)); // recursive call inside a for loop... probably not too fast

        return count;
    }
}

