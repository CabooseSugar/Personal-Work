package java_enums;

public class EnumTest {

    enum DayOfWeek {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY}


    public static void main(String[] args) {

        DayOfWeek[] values = DayOfWeek.values();

        for (int i = 0 ; i < 7; i++)
            //System.out.println("Enter temp for day: " + (i+1));
            System.out.println("Enter temp for day: " + values[i] + ": ");

    }


}
