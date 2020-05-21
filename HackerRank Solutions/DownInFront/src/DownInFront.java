import java.util.*;

public class DownInFront {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++){
            String name = sc.next();
            int feet = sc.nextInt() * 12;
            int inches = sc.nextInt() + feet;
            list.add(inches);
            sc.nextLine();
        }

        int aggro = 0;

        for (int i = list.size()-1; i >= 1; i--){
            Set<Integer> usedHeights = new HashSet<>();
            for (int j = i-1; j >= 0; j--){
                if (list.get(j) > list.get(i)){
                    boolean tallerOrSame = false;
                    for (Integer h : usedHeights){
                        if (h >= list.get(j)){
                            tallerOrSame = true;
                            break;
                        }
                    }
                    if (!tallerOrSame) {
                        usedHeights.add(list.get(j));
                        aggro++;
                    }
                }
            }
        }

        System.out.println(aggro);


    }
}
