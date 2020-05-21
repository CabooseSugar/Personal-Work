import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        while (n >0){
            int fullRot = sc.nextInt();
            int iniT = sc.nextInt();
            int iniA = sc.nextInt();
            int time = sc.nextInt();

            boolean leadingA = iniA > iniT;
            int timeNeeded = leadingA ? iniA - iniT : (fullRot - iniT) + iniA;

            if (timeNeeded == time){
                System.out.println(0);
                n--;
                continue;
            }

            if (iniT == iniA){
                if (time <= fullRot / 2) {
                    System.out.println(time);
                }
                else {
                    System.out.println(fullRot - time);
                }
                n--;
                continue;
            }

            if (timeNeeded < time && leadingA){
                System.out.println(time - timeNeeded);
                n--;
                continue;
            }

            if (timeNeeded > time && leadingA){
                System.out.println(timeNeeded - time);
                n--;
                continue;
            }

            if (timeNeeded < time && !leadingA){
                System.out.println(time - timeNeeded);
                n--;
                continue;
            }

            if (timeNeeded > time && !leadingA){
                System.out.println(timeNeeded - time);
                n--;
                continue;

            }
        }



    }
}
