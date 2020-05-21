import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String sentence = sc.nextLine();
            String[] words = sentence.split(" ");
            for (String word : words) {
                char[] wordArr = word.toCharArray();
                if (wordArr.length == 1 && wordArr[0] == '_') {
                    System.out.print("_ ");
                } else if (word.contains("_") && (wordArr[0] == '_' || wordArr[wordArr.length - 1] == '_')) {
                    if (wordArr[0] == '_') {
                        String s = new String(wordArr, 1, wordArr.length - 1);
                        System.out.print(caseMod(s) + " ");
                    } else {
                        String s = new String(wordArr, 0, wordArr.length - 1);
                        System.out.print(caseMod(s) + " ");
                    }
                } else if (word.contains("_")) {
                    System.out.print(caseMod(word) + " ");
                } else {
                    System.out.print(word + " ");
                }
            }
            System.out.println();
        }
    }

    private static String caseMod(String s){
        char[] sArr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sArr.length; i++){
            if (sArr[i] != '_'){
                sArr[i] = Character.toLowerCase(sArr[i]);
            }
            if (i - 1 >= 0 && sArr[i-1] == '_') {
                sArr[i] = Character.toUpperCase(sArr[i]);
            }
            if (sArr[i] != '_'){
                sb.append(sArr[i]);
            }
        }

        return sb.toString();
    }
}
