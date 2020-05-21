import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String word = scanner.next();

            word = word.replace("qu", "1");
            word = word.replace("tr", "2");
            word = word.replace("br", "3");
            word = word.replace("str", "4");
            word = word.replace("st", "5");
            word = word.replace("sl", "6");
            word = word.replace("bl", "7");
            word = word.replace("cr", "8");
            word = word.replace("ph", "9");
            word = word.replace("ch", "0");

            Character[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};

            List<Character> vowelsList = new ArrayList<>();
            for (Character v : vowels) {
                vowelsList.add(v);
            }

            int realLength = word.length();
            if (word.contains(".") || word.contains(";") || word.contains(",") || word.contains("!") || word.contains("?")) {
                realLength -= 1;
            }

            if (realLength < 3) {
                System.out.println(word);
                continue;
            }

            char[] wordArr = word.toCharArray(); // iterate over this because letterList will be changing
            List<Character> letterList = new ArrayList<>();
            for (char c : wordArr) {
                letterList.add(c);
            }

            int buffer = 0;
            for (int i = 0; i < realLength - 2; i++) {
                char one = wordArr[i];
                char two = wordArr[i + 1];
                char three = wordArr[i + 2];
                char four = ' ';
                if (i != realLength - 3) {
                    four = wordArr[i + 3];
                }

                if (i != realLength - 3 && vowelsList.contains(one) && !vowelsList.contains(two) && !vowelsList.contains(three) && vowelsList.contains(four)) {
                    letterList.add(i + 2 + buffer, '-');
                    buffer++;
                    i += 1; // skip ahead to after new -
                }

                if (vowelsList.contains(one) && !vowelsList.contains(two) && vowelsList.contains(three)) {
                    if (!((three == 'e' || three == 'E') && i == realLength - 3)) {
                        letterList.add(i + 1 + buffer, '-');
                        buffer++;
                    }
                }
            }

            StringBuilder st = new StringBuilder();
            for (char c : letterList) {
                st.append(c);
            }

            String finished = st.toString();

            finished = finished.replace("1", "qu");
            finished = finished.replace("2", "tr");
            finished = finished.replace("3", "br");
            finished = finished.replace("4", "str");
            finished = finished.replace("5", "st");
            finished = finished.replace("6", "sl");
            finished = finished.replace("7", "bl");
            finished = finished.replace("8", "cr");
            finished = finished.replace("9", "ph");
            finished = finished.replace("0", "ch");

            System.out.println(finished);
        }
    }
}
