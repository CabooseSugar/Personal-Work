package print_vertically;

public class VerticalPrint {

    public static void print(Integer val) {
        String s = String.valueOf(val);
        for (Character c : s.toCharArray()) {
            System.out.println(c);
        }
    }

    public static void printRec(Integer val) {

        if (val < 10) { // base case
            System.out.println(val);
        }
        else { // recursive case
            String converted = String.valueOf(val);
            System.out.println(converted.charAt(0));
            Integer hack = Integer.parseInt(converted.substring(1));
            printRec(hack);
        }
    }
}
