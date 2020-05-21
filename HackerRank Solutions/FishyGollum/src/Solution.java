import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Map<String, Character> dict = new HashMap<>();
        dict.put("S", '0');
        dict.put("Z", '0');
        dict.put("D", '1');
        dict.put("T", '1');
        dict.put("N", '2');
        dict.put("M", '3');
        dict.put("R", '4');
        dict.put("ER", '4');
        dict.put("ER0", '4');
        dict.put("ER1", '4');
        dict.put("ER2", '4');
        dict.put("L", '5');
        dict.put("JH", '6');
        dict.put("CH", '6');
        dict.put("SH", '6');
        dict.put("K", '7');
        dict.put("G", '7');
        dict.put("F", '8');
        dict.put("V", '8');
        dict.put("P", '9');
        dict.put("B", '6');

        Set<String> forbidden = new HashSet<>();
        forbidden.add("DH");
        forbidden.add("TH");
        forbidden.add("NG");
        forbidden.add("ZH");

        Scanner sc = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        while(true){
            String line = sc.nextLine();
            if (line.equals("ENDDICT")){
                break;
            }
            input.add(line);
        }

        String num = sc.nextLine();
        char[] digits = num.toCharArray();
        Set<Character> digitSet = new HashSet<>();
        for (char c: digits){
            digitSet.add(c);
        }
        boolean foundOne = false;

        for (String s : input){
            int currentDigitIndex = 0;
            String[] line = s.split(" ");
            boolean validWord = true;
            for (int i = 2; i < line.length; i++){
                if (forbidden.contains(line[i])){
                    validWord = false;
                    break;
                }
                if (dict.containsKey(line[i])){
                    char val = dict.get(line[i]);
                    if (currentDigitIndex >= digits.length && digitSet.contains(val)){
                        validWord = false;
                        break;
                    }
                    if (!digitSet.contains(val)){
                        validWord = false;
                        break;
                    }
                    if (digits[currentDigitIndex] != val){
                        validWord = false;
                        break;
                    }
                    else{
                        currentDigitIndex++;
                    }
                }
            }
            if (validWord){
                System.out.println(line[0]);
                foundOne = true;
            }
        }

        if (!foundOne){
            System.out.println("(NO SUGGESTIONS)");
        }



    }
}
