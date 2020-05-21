import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int width = sc.nextInt();
        int height = sc.nextInt();
        int numChars = sc.nextInt();
        sc.nextLine();

        Map<Character, Character[][]> dict = new HashMap<>();

        for (int i = 0; i < numChars; i++){
            String l =  sc.nextLine();
            Character letter[][] = new Character[width][height];
            // handle empty string
            if (l.equals("")){
                for(int j = 0; j < height; j++) {
                    sc.nextLine();
                    for (int k = 0; k < width; k++)
                        letter[j][k] = ' ';
                }
                char c = ' ';
                dict.put(c, letter);
            }
            // handle everything else
            else {
                char c = l.toCharArray()[0];
                for (int j = 0; j < height; j++) {
                    String line = sc.nextLine();
                    int ind = 0;
                    for (char ch : line.toCharArray()) {
                        letter[j][ind] = ch;
                        ind++;
                    }
                }
                dict.put(c, letter);
            }

        }
        int sentences = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < sentences; i++){
            String sentence = sc.nextLine();
            printLetter(sentence, dict, width, height);
            System.out.println();
        }
    }

    static void printLetter(String sen, Map<Character, Character[][]> map, int w, int h){
        for (int i = 0; i < h; i++) {
            for (char c : sen.toCharArray()) {
                for (int j = 0; j < w; j++){
                    System.out.print(map.get(c)[i][j]);
                }
            }
            System.out.println();
        }




    }
}
