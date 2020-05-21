import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String[]> list = new ArrayList<>();
        Set<String> connectsToJose = new HashSet<>();
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++){
            String[] items = new String[2];
            items[0] = sc.next();
            items[1] = sc.next();
            list.add(items);
        }

        connectsToJose.add("San_Jose");
        while(true){
            int numAdded = 0;

            for (int i = 0; i < n; i++){
                if (connectsToJose.contains(list.get(i)[0]) && !(connectsToJose.contains(list.get(i)[1]))){
                    connectsToJose.add(list.get(i)[1]);
                    numAdded++;
                }
                else if (connectsToJose.contains(list.get(i)[1]) && !(connectsToJose.contains(list.get(i)[0]))){
                    connectsToJose.add(list.get(i)[0]);
                    numAdded++;
                }
            }

            if (numAdded == 0)
                break;
        }

        n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++){
            if (connectsToJose.contains(sc.nextLine())){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
        }



    }
}
